package com.qdillion.zooma.admin.dao;

import com.qdillion.zooma.admin.model.BlogModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Kimyongchul
 * Created on 2017. 11. 17.
 */
@Mapper
public interface BlogMapper {

    //@Select("SELECT id, name, handle, user_id as userId FROM blog")
    public List<BlogModel> selectAllBlogs();

}
