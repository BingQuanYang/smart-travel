package com.smart.travel.service.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.travel.service.user.entity.User;

public interface UserMapper extends BaseMapper<User> {
    User getThreeByUsername(String username);
}