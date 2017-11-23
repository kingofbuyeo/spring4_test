package com.qdillion.zooma.admin.dao;

import com.qdillion.zooma.admin.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Kimyongchul
 * Created on 2017. 11. 17.
 */
@Mapper
public interface UserMapper {

    public List<UserModel> selectUserList();
}
