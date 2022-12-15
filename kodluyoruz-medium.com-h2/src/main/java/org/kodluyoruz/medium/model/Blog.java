package org.kodluyoruz.medium.model;

import java.util.List;

public class Blog {
    private String title;
    private String text;
    private List<Tag> tags;
    private BlogStatusType statusType;
    private User user;

    public Blog(String title, String text, List<Tag> tags, BlogStatusType statusType, User user) {
        this.title = title;
        this.text = text;
        this.tags = tags;
        this.user = user;
        this.statusType = statusType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BlogStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(BlogStatusType statusType) {
        this.statusType = statusType;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", statusType=" + statusType + '\'' +
                ", userName='" + user.getName() + "'" +
                '}';
    }
}
