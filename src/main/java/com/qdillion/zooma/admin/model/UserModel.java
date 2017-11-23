package com.qdillion.zooma.admin.model;

import lombok.Data;

/**
 * Created by Kimyongchul
 * Created on 2017. 11. 17.
 */
@Data
public class UserModel extends BaseModel{

    private Integer uSeq;
    private String uId;
    private String uPassword;
    private String uKey;
    private String uName;
    private String uEmail;
    private String uNickName;
    private String uPhone;
    private String uPhoneYn;
    private String uEmailYn;
    private String uPhoneView;
    private String uAge;
    private String uBirth;
    private String uGender;
    private String uProfileImage;
    private String uType;
    private String uStatus;
    private String uUseYn;
    private String uInfoYn;
    private String uLocationYn;
    private String uAdminYn;
    private String uRegisterdDate;
    private String uUpdateDate;

}
