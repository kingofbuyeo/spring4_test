package com.qdillion.zooma.admin.service;

import com.qdillion.zooma.admin.dao.BlogMapper;
import com.qdillion.zooma.admin.model.BlogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kimyongchul
 * Created on 2017. 11. 17.
 */
@Service
public class BlogService {

    @Autowired
    BlogMapper blogMapper;

    public List<BlogModel> selectAllBlogs(){

        return blogMapper.selectAllBlogs();

    }



}
