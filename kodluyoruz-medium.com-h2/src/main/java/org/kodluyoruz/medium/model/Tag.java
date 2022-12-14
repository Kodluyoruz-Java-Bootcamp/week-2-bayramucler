package org.kodluyoruz.medium.model;

import java.util.List;

public class Tag {
    private String name;
    private List<User> followers;

    public Tag(String tagName) {
        this.name = tagName;
    }

    public Tag(String tagName, List<User> followers) {
        this.name = tagName;
        this.followers = followers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }


    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name+
                "followers='" + followers+
                '}';
    }
}
