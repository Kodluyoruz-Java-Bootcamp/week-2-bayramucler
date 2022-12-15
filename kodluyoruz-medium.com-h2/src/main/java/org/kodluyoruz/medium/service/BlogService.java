package org.kodluyoruz.medium.service;

import org.kodluyoruz.medium.dao.BlogDao;
import org.kodluyoruz.medium.model.Blog;

import java.util.List;

public class BlogService {

    private BlogDao blogDao = new BlogDao();

    public void createBlog(Blog blog){
        blogDao.saveBlog(blog);
        System.out.println("[BlogService] blog oluşturuldu.");
    }

    public void removeBlog(Blog blog){
        blogDao.removeBlog(blog);
        System.out.println("[BlogService] blog silindi.");
    }

    public List<Blog> getAll(){
        return blogDao.findAll();
    }

    public void printAllBlogs(){
        getAll().forEach(blog -> System.out.println(blog));
    }


}
