package com.oo.facebook;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.reverseOrder;

public class Member extends Person {
    private Integer memberId;
    private Date dateOfMembership;
    private String name;

    private Profile profile;
    private Set<Integer> memberFollows;
    private Set<Integer> memberConnections;
    private Set<Integer> pageFollows;
    private Set<Integer> memberSuggestions;
    private Set<ConnectionInvitation> connectionInvitations;
    private Set<Integer> groupFollows;

    Member(Integer id) {
        this.memberId = id;
    }

    public boolean sendMessage(Message message) {
        return true;
    }

    public boolean createPost(Post post) {
        return true;
    }

    public boolean sendConnectionInvitation(ConnectionInvitation invitation) {
        return true;
    }

    public Map<Integer, Integer> searchMemeberSuggestions() {
        Map<Integer, Integer> suggestions = new HashMap<>();
        for (Integer memberId : memberConnections) {
            Set<Integer> firstLevelConnections = (new Member(memberId)).memberConnections;
            for (Integer firstLevelMemberId : firstLevelConnections) {
                findMemberSuggestion(suggestions, firstLevelMemberId);
                Set<Integer> secondLevelConnections = (new Member(firstLevelMemberId)).memberConnections;

                for (Integer secondLevelMemberId : secondLevelConnections) {
                    findMemberSuggestion(suggestions, secondLevelMemberId);
                }
            }
        }

        // order
        Map<Integer, Integer> result = new HashMap<>();
        suggestions.entrySet().stream().sorted(reverseOrder(Map.Entry.comparingByValue()))
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

        return suggestions;
    }

    private void findMemberSuggestion(Map<Integer, Integer> suggestions, Integer memberId) {
        if (memberConnections.contains(memberId) || connectionInvitations.contains(memberId)) return;
        suggestions.put(memberId, suggestions.getOrDefault(memberId, 0) + 1);
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getDateOfMembership() {
        return dateOfMembership;
    }

    public void setDateOfMembership(Date dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<Integer> getMemberFollows() {
        return memberFollows;
    }

    public void setMemberFollows(Set<Integer> memberFollows) {
        this.memberFollows = memberFollows;
    }

    public Set<Integer> getMemberConnections() {
        return memberConnections;
    }

    public void setMemberConnections(Set<Integer> memberConnections) {
        this.memberConnections = memberConnections;
    }

    public Set<Integer> getPageFollows() {
        return pageFollows;
    }

    public void setPageFollows(Set<Integer> pageFollows) {
        this.pageFollows = pageFollows;
    }

    public Set<Integer> getMemberSuggestions() {
        return memberSuggestions;
    }

    public void setMemberSuggestions(Set<Integer> memberSuggestions) {
        this.memberSuggestions = memberSuggestions;
    }

    public Set<ConnectionInvitation> getConnectionInvitations() {
        return connectionInvitations;
    }

    public void setConnectionInvitations(Set<ConnectionInvitation> connectionInvitations) {
        this.connectionInvitations = connectionInvitations;
    }

    public Set<Integer> getGroupFollows() {
        return groupFollows;
    }

    public void setGroupFollows(Set<Integer> groupFollows) {
        this.groupFollows = groupFollows;
    }
}
