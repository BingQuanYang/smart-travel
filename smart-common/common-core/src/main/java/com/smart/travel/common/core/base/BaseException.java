package com.smart.travel.common.core.base;

import com.smart.travel.common.core.result.ResultCode;
import lombok.Getter;

/**
 * @author ybq
 */
@Getter
public class BaseException extends Exception {
    /**
     * 错误码
     */
    private Integer status;
    /**
     * 错误信息
     */
    private String message;

    public BaseException(Integer status, String message) {
        super(message);
        this.message = message;
        this.status = status;
    }

    public BaseException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.message = resultCode.getMessage();
        this.status = resultCode.getStatus();
    }

    public BaseException(ResultCode resultCode, String message) {
        super(message);
        this.message = message;
        this.status = resultCode.getStatus();
    }
}
