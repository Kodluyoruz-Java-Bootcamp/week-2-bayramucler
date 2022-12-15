package org.kodluyoruz.medium.dao;

import org.kodluyoruz.medium.model.Tag;

import java.util.ArrayList;
import java.util.List;

public class TagDao {
    private static List<Tag> tagList = new ArrayList<>();

    public void saveTag(Tag tag) {
        tagList.add(tag);
    }

    public List<Tag> findAll(){
        return tagList;
    }
}
