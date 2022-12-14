package org.kodluyoruz.medium.model;

import java.util.List;

public class User {
    private String name;
    private List<Blog> blogs;
    private List<User> following;
    private List<User> followers;
    private List<Tag> followingTags;

    public User(){
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, List<Blog> blogs) {
        this.name = name;
        this.blogs = blogs;
    }

    public User(String name, List<Blog> blogs, List<User> following, List<User> followers, List<Tag> followingTags) {
        this.name = name;
        this.blogs = blogs;
        this.following = following;
        this.followers = followers;
        this.followingTags = followingTags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<Tag> getFollowingTags() {
        return followingTags;
    }

    public void setFollowingTags(List<Tag> followingTags) {
        this.followingTags = followingTags;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", blogs=" + blogs +
                ", following=" + following +
                ", followers=" + followers +
                ", followingTags=" + followingTags +
                '}';
    }
}
