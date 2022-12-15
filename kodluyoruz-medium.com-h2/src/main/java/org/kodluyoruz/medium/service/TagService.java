package org.kodluyoruz.medium.service;



import org.kodluyoruz.medium.dao.TagDao;
import org.kodluyoruz.medium.model.Tag;

import java.util.List;

public class TagService {
    private TagDao tagDao = new TagDao();

    public void createTag(Tag tag){
        tagDao.saveTag(tag);
    }

    public List<Tag> getAllTags() {
        return tagDao.findAll();
    }

    public void printAllTags() {
        getAllTags().forEach(tag -> System.out.println(tag));
    }



}
