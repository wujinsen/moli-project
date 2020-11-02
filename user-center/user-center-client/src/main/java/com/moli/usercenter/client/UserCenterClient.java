package com.moli.usercenter.client;

import com.moli.common.dto.response.UserResponseDTO;
import com.moli.reponse.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="user-center-server", value="user-center-server")
public interface UserCenterClient {

    @RequestMapping(value="/user/{id}",method = RequestMethod.POST)
    public Result<UserResponseDTO> select(@PathVariable("id") String id);

}
