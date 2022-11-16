package com.smart.travel.service.travel.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.smart.travel.service.travel.entity.ScenicSpotIntroduction;
import com.smart.travel.service.travel.entity.Strategy;
import com.smart.travel.service.travel.entity.TravelNote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 景点表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScenicSpotVO {
    /**
     * ID
     */
    private Long scenicSpotId;

    /**
     * 景点名字
     */
    private String scenicSpotName;

    /**
     * 图片
     */
    private String images;

    /**
     * 评分
     */
    private Long grade;

    /**
     * 标题
     */
    private String title;

    private List<String> imageList;
}