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
public class TravelNoteDTO {
    /**
     * ID
     */
    private Long travelNoteId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 景点ID
     */
    private Long scenicSpotId;

    /**
     * 图片
     */
    private String images;

    /**
     * 内容
     */
    private String content;
}
