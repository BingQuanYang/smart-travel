package com.smart.travel.service.travel.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ybq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrategyDTO {
    /**
     * 主键
     */
    private Long strategyId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 景点ID
     */
    private Long scenicSpotId;

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
