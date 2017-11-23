package com.qdillion.zooma.admin.model;


import lombok.Data;

import java.io.Serializable;

/**
 * Created by Kimyongchul
 * Created on 2017. 11. 17.
 */
@Data
public class BlogModel implements Serializable{
    private int id;
    private String name;
    private String handle;
    private Integer userId;
}
