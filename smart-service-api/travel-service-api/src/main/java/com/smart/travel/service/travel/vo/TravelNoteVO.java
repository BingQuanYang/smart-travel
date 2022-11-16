package com.smart.travel.service.travel.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 游记表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelNoteVO {
    /**
     * ID
     */
    private Long travelNoteId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String userImage;

    /**
     * 图片
     */
    private String images;

    /**
     * 图片
     */
    private List<String> imageList;


    /**
     * 内容
     */
    private String content;

    /**
     * 内容列表
     */
    private List<String> contentList;
}