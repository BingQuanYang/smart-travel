package com.smart.travel.service.travel.vo;

import lombok.Data;

import java.util.List;

/**
 * @author ybq
 */
@Data
public class HomeVO {
    /**
     * 轮播导航
     */
    private List<ScenicSpotVO> navScenicSpotList;

    /**
     * 本周精选
     */
    private List<ScenicSpotVO> weekScenicSpotList;

    /**
     * 主题游玩
     */
    private List<ScenicSpotVO> titleScenicSpotList;

    /**
     * 游记
     */
    private List<TravelNoteVO> travelNoteVOList;
}
