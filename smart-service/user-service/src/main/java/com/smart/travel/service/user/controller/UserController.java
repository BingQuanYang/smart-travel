package com.smart.travel.service.user.controller;

import com.smart.travel.common.core.base.BaseException;
import com.smart.travel.common.core.result.BaseResult;
import com.smart.travel.service.user.dto.UserDTO;
import com.smart.travel.service.user.entity.User;
import com.smart.travel.service.user.service.UserService;
import com.smart.travel.service.user.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ybq
 */
@RestController
@RequestMapping("/user/")
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("/getByUsername/{username}")
    public BaseResult<UserVO> getByUsername(@PathVariable("username") String username) throws BaseException {
        return BaseResult.success(userService.getByUsername(username));
    }

    @GetMapping("/getById/{id}")
    public BaseResult<UserVO> getById(@PathVariable("id") Long id) throws BaseException {
        return BaseResult.success(userService.getById(id));
    }

    @GetMapping("/getThreeByUsername/{username}")
    public BaseResult<UserVO> getThreeByUsername(@PathVariable("username") String username) throws BaseException {
        return BaseResult.success(userService.getThreeByUsername(username));
    }

    @PostMapping("/save")
    public BaseResult<UserVO> save(@RequestBody UserDTO userDTO) {
        return BaseResult.success(userService.save(userDTO));
    }

    @PostMapping("/getByPhone/{phone}")
    public BaseResult<UserVO> getByPhone(@PathVariable("phone") String phone) throws BaseException {
        return BaseResult.success(userService.getByPhone(phone));
    }

}
