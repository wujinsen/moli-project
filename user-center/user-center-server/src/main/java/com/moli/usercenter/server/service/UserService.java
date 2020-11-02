package com.moli.usercenter.server.service;


import com.github.pagehelper.PageInfo;
import com.moli.common.dto.request.UserRequestDTO;
import com.moli.common.dto.response.UserResponseDTO;
import com.moli.request.PageRequest;
import com.moli.usercenter.server.domain.User;

import java.util.List;

public interface UserService {

    public UserResponseDTO select(String id);

    public PageInfo<User> userList(PageRequest request);

    public User selectUserByName(String userName);
}
