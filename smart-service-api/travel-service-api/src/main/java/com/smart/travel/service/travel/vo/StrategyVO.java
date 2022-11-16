package com.smart.travel.service.travel.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 攻略表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrategyVO {
    /**
     * 主键
     */
    private Long strategyId;

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
    private String image;

    /**
     * 主标题
     */
    private String mainTitle;

    /**
     * 主内容
     */
    private String mainContent;

    /**
     * 封面
     */
    private String cover;

    /**
     * 副标题1
     */
    private String subheadFirst;

    /**
     * 内容1
     */
    private String contentFirst;

    /**
     * 图片1
     */
    private String imagesFirst;

    /**
     * 副标题2
     */
    private String subheadSecond;

    /**
     * 内容2
     */
    private String contentSecond;

    /**
     * 图片2
     */
    private String imagesSecond;
}