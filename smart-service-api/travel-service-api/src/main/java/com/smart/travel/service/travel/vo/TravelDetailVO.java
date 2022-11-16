package com.smart.travel.service.travel.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.smart.travel.service.travel.entity.Strategy;
import com.smart.travel.service.travel.entity.TravelNote;
import lombok.Data;

import java.util.List;

/**
 * @author ybq
 */
@Data
public class TravelDetailVO {
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
    private List<String> imagesList;

    /**
     * 评分
     */
    private Long grade;

    /**
     * 标题
     */
    private List<String> titleList;

    /**
     * 景点介绍
     */
    private ScenicSpotIntroductionVO scenicSpotIntroductionVO;

    /**
     * 游记
     */
    private List<TravelNoteVO> travelNoteVOList;

    /**
     * 攻略
     */
    private List<StrategyVO> strategyVOList;


}
