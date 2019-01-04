package com.oo.facebook;

import java.util.List;

public interface Search {
    List<Member> searchMember(String name);

    List<Group> searchGroup(String name);

    List<Page> searchPage(String name);

    List<Post> searchPost(String word);
}
