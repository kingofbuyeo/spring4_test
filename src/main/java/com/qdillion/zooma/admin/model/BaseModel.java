package com.qdillion.zooma.admin.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Kimyongchul
 * Created on 2017. 11. 17.
 */
@Data
public class BaseModel implements Serializable {

    private int pageNo = 1;
    private int pageBlock;
    private int totalCnt;
}
