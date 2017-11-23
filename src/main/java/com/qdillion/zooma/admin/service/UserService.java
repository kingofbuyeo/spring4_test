package com.qdillion.zooma.admin.service;

import com.qdillion.zooma.admin.dao.UserMapper;
import com.qdillion.zooma.admin.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kimyongchul
 * Created on 2017. 11. 17.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserModel> selectUserList(){
        return userMapper.selectUserList();
    }
}