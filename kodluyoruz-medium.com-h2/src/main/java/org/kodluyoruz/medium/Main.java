package org.kodluyoruz.medium;

import org.kodluyoruz.medium.model.Blog;
import org.kodluyoruz.medium.model.BlogStatusType;
import org.kodluyoruz.medium.model.Tag;
import org.kodluyoruz.medium.model.User;
import org.kodluyoruz.medium.service.BlogService;
import org.kodluyoruz.medium.service.TagService;
import org.kodluyoruz.medium.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User userBayram = new User("bayram");
        User userOzer = new User("ozer");
        User userCem = new User("cem");
        User userSami = new User("sami");

        List<User> usrBayramFollowing = new ArrayList<>();
        usrBayramFollowing.add(userOzer);
        usrBayramFollowing.add(userCem);

        userBayram.setFollowing(usrBayramFollowing);

        Tag tag1 = new Tag("OOP");
        Tag tag2 = new Tag("Java");
        Tag tag3 = new Tag(".Net Core");
        Tag tag4 = new Tag("Microsoft");
        Tag tag5 = new Tag("Python");
        Tag tag6 = new Tag("Database");

        List<Tag> blog1Tags = List.of(tag1,tag2);
        List<Tag> blog2Tags = List.of(tag3,tag4);
        List<Tag> blog3Tags = List.of(tag5);
        List<Tag> blog4Tags = List.of(tag6);


        Blog blog1 = new Blog("Java - OOP Konu Anlatımı","Object Oriented Programming'in temelleri aşağıdaki gibidir.. ",
                             blog1Tags, BlogStatusType.DRAFT, userBayram);
        Blog blog2 = new Blog(".Net core","Microsoft .Net Core 2018 yılı...",
                             blog2Tags, BlogStatusType.DRAFT, userOzer);
        Blog blog3 = new Blog("Python","Pyhton programlama...",
                             blog3Tags, BlogStatusType.PUBLISHED, userSami);
        Blog blog4 = new Blog("DB","Database... ",
                             blog4Tags, BlogStatusType.DRAFT, userSami);

        userBayram.setBlogs(List.of(blog1));
        userOzer.setBlogs(List.of(blog2));
        userSami.setBlogs(List.of(blog3,blog4));

        userBayram.setFollowing(List.of(userCem,userOzer));
        userSami.setFollowers(List.of(userBayram,userOzer));

        userBayram.setFollowingTags(blog1Tags);

        UserService userService = new UserService();
        userService.createUser(userBayram);
        userService.createUser(userOzer);
        userService.createUser(userCem);
        userService.createUser(userSami);

        BlogService blogService = new BlogService();
        blogService.createBlog(blog1);
        blogService.createBlog(blog2);
        blogService.createBlog(blog3);
        blogService.createBlog(blog4);

        TagService tagService = new TagService();
        tagService.createTag(tag1);
        tagService.createTag(tag2);
        tagService.createTag(tag3);
        tagService.createTag(tag4);
        tagService.createTag(tag5);
        tagService.createTag(tag6);

        tagService.printAllTags();
        userService.printAllUsers();
        blogService.printAllBlogs();

        blogService.removeBlog(blog2);
        blogService.printAllBlogs();

    }
}