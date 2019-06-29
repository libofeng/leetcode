package com.leetcode.design;

import java.util.*;

public class No355DesignTwitter {

    /**
     * Initialize your data structure here.
     */

    private Map<Integer, Set<Integer>> followers = new HashMap<>();
    private Map<Integer, Set<Integer>> userFollows = new HashMap<>();
    private Map<Integer, List<Tweet>> userTweets = new HashMap<>();
    private final int TOP_TWEET_N = 10;
    private int timeStamp = 1;

    public No355DesignTwitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(timeStamp++, tweetId));
        follow(userId, userId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        final Queue<Tweet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));

        for (int uid : userFollows.getOrDefault(userId, new HashSet<>())) collectTweetFeeds(pq, uid);

        final LinkedList<Integer> result = new LinkedList<>();
        while (!pq.isEmpty()) result.addFirst(pq.poll().id);

        return result;
    }

    private void collectTweetFeeds(Queue<Tweet> pq, int uid) {
        for (Tweet t : getUserTopNTweets(uid)) {
            if (pq.size() < TOP_TWEET_N) pq.offer(t);
            else {
                if (t.time > pq.peek().time) {
                    pq.poll();
                    pq.offer(t);
                }
            }
        }
    }

    private List<Tweet> getUserTopNTweets(int userId) {
        final List<Tweet> result = new ArrayList<>();
        final List<Tweet> tweets = userTweets.getOrDefault(userId, new ArrayList<>());
        for (int i = tweets.size() - 1; i >= 0 && result.size() < TOP_TWEET_N; i--) {
            result.add(tweets.get(i));
        }

        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followeeId, k -> new HashSet<>()).add(followerId);
        userFollows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (followers.containsKey(followeeId)) followers.get(followeeId).remove(followerId);
        if (userFollows.containsKey(followerId)) userFollows.get(followerId).remove(followeeId);
    }

    class Tweet {
        int time;
        int id;

        Tweet(int t, int i) {
            time = t;
            id = i;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */