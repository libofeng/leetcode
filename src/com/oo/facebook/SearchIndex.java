package com.oo.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchIndex implements Search, SearchManager {
    private final Map<String, List<Member>> memberNames = new HashMap<>();
    private final Map<String, List<Group>> groupNames = new HashMap<>();
    private final Map<String, List<Page>> pageNames = new HashMap<>();
    private final Map<String, List<Post>> postKeywords = new HashMap<>();

    @Override
    public List<Member> searchMember(String name) {
        return memberNames.get(name);
    }

    @Override
    public List<Group> searchGroup(String name) {
        return groupNames.get(name);
    }

    @Override
    public List<Page> searchPage(String name) {
        return pageNames.get(name);
    }

    @Override
    public List<Post> searchPost(String word) {
        return postKeywords.get(word);
    }

    @Override
    public void addMember(Member member) {
        memberNames.putIfAbsent(member.getName(), new ArrayList<>());
        if (memberNames.get(member.getName()).indexOf(member) < 0) memberNames.get(member.getName()).add(member);
    }

    @Override
    public void addGroup(Group group) {
        groupNames.putIfAbsent(group.getName(), new ArrayList<>());
        if (groupNames.get(group.getName()).indexOf(group) < 0) groupNames.get(group.getName()).add(group);
    }

    @Override
    public void addPage(Page page) {
        pageNames.putIfAbsent(page.getName(), new ArrayList<>());
        if (pageNames.get(page.getName()).indexOf(page) < 0) pageNames.get(page.getName()).add(page);
    }

    @Override
    public void addPost(Post post) {
        String[] keywords = getKeywords(post.getText());
        for (String keyword : keywords) {
            postKeywords.putIfAbsent(keyword, new ArrayList<>());
            if (postKeywords.get(keyword).indexOf(post) < 0) postKeywords.get(keyword).add(post);
        }
    }

    private String[] getKeywords(String text) {
        return new String[0];
    }
}
