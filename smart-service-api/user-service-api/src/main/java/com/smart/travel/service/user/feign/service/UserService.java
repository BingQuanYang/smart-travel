package com.smart.travel.service.user.feign.service;

import com.smart.travel.common.core.result.BaseResult;
import com.smart.travel.service.user.dto.UserDTO;
import com.smart.travel.service.user.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author ybq
 */
@Component
@FeignClient(value = "user-server", contextId = "userServiceFeignClient", path = "/user")
public interface UserService {
    @GetMapping("/getByUsername/{username}")
    BaseResult<UserVO> getByUsername(@PathVariable("username") String username);

    @PostMapping("/save")
    BaseResult<UserVO> save(@RequestBody UserDTO userDTO);

    @PostMapping("/getByPhone/{phone}")
    BaseResult<UserVO> getByPhone(@PathVariable("phone") String phone);

    @GetMapping("/getById/{id}")
    BaseResult<UserVO> getById(@PathVariable("id") Long id);
}
