package com.moli.common.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserResponseDTO implements Serializable {

    private String id;

    private String name;

    private String username;

    private String nickName;

    private String password;

    private String avatar;

    private String phone;

    private String email;

    private Integer sex;

    private String salt;

    private Integer status;


    private Date createTime;


    private Date updateTime;

    private String[] roles;

}
