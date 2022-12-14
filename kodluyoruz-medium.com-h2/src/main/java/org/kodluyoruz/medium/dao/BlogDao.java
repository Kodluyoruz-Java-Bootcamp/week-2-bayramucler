package org.kodluyoruz.medium.dao;

import org.kodluyoruz.medium.model.Blog;

import java.util.ArrayList;
import java.util.List;

public class BlogDao {
    private static List<Blog> blogList = new ArrayList<>();

    public void saveBlog(Blog blog) {
        blogList.add(blog);
    }

    public void removeBlog(Blog blog) {
        blogList.remove(blog);
    }

    public List<Blog> findAll(){
        return blogList;
    }
}
