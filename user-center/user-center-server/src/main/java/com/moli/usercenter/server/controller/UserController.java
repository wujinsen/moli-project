package com.moli.usercenter.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.moli.common.dto.request.UserRequestDTO;
import com.moli.common.dto.response.UserResponseDTO;
import com.moli.reponse.Result;
import com.moli.request.PageRequest;
import com.moli.usercenter.client.UserCenterClient;
import com.moli.usercenter.server.domain.User;
import com.moli.usercenter.server.service.UserService;
import feign.Headers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Api(tags = {"用户接口"})
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @Autowired
    private UserCenterClient userCenterClient;

//    @PostMapping("/{id}")
//    @ApiOperation(value = "单个用户", notes = "单个用户")
//    @ResponseBody
//    public Result<UserResponseDTO> selectOne(@PathVariable("id") String id) {
//
//        return Result.success(userService.select(id));
//    }

    @PostMapping("/userList")
    @ApiOperation(value = "用户列表", notes = "用户列表")
    @ResponseBody
    public Result<PageInfo<User>> userList(PageRequest request) {

        return Result.success(userService.userList(request));

    }
    @RequestMapping(value = "/login", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @ResponseBody
    public Result<UserResponseDTO> login(@RequestBody UserRequestDTO dto){
        UserResponseDTO user = new UserResponseDTO();
        user.setUsername("admin");
        user.setPassword("aaa");
        return Result.success(user);
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ApiOperation(value = "用户信息", notes = "用户信息")
    @ResponseBody
    public Result<UserResponseDTO> info(){

        UserResponseDTO user = new UserResponseDTO();
        user.setAvatar("sfasdf");
        user.setName("aaa");
        user.setRoles(new String[]{"admin"});
        return Result.success(user);
    }
}
