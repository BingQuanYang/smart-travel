package com.smart.travel.service.travel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.travel.service.travel.entity.ScenicSpot;
import org.apache.ibatis.annotations.Param;

public interface ScenicSpotMapper extends BaseMapper<ScenicSpot> {
    ScenicSpot getThreeById(@Param("id") long id);
}