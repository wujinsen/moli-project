package com.moli.usercenter.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moli.common.dto.request.UserRequestDTO;
import com.moli.common.dto.response.UserResponseDTO;
import com.moli.request.PageRequest;
import com.moli.usercenter.server.domain.User;
import com.moli.usercenter.server.mapper.UserMapper;
import com.moli.usercenter.server.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public UserResponseDTO select(String id) {
        User user = new User();
        user.setId(id);
        User result = userMapper.selectOne(user);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        BeanUtils.copyProperties(result, userResponseDTO);
        return userResponseDTO;
    }

    public PageInfo<User> userList(PageRequest request) {

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        Example example = new Example(User.class);
//        example.createCriteria()
//                .andEqualTo("createTime", "");
        example.orderBy("createTime");
        List<User> userList = userMapper.selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;

    }

    public User selectUserByName(String userName) {
        User user = new User();
        user.setName(userName);

        return userMapper.selectOne(user);
    }
}
