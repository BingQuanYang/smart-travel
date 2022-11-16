package com.smart.travel.common.core.result;

import com.smart.travel.common.core.base.BaseException;
import lombok.Builder;
import lombok.Getter;

/**
 * @author ybq
 */
@Builder
@Getter
public class BaseResult<T> {

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public static <T> BaseResult<T> success() {
        return success(null);
    }

    public static <T> BaseResult<T> success(T data) {
        ResultCode resultCode = ResultCode.SUCCESS;
        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
            resultCode = ResultCode.ERROR;
        }
        return result(resultCode, data);
    }

    public static <T> BaseResult<T> error() {
        return error(null);
    }

    public static <T> BaseResult<T> error(T data) {
        return result(ResultCode.ERROR, data);
    }

    public static <T> BaseResult<T> error(BaseException e) {
        return BaseResult.<T>builder()
                .status(e.getStatus())
                .message(e.getMessage())
                .build();
    }

    public static <T> BaseResult<T> result(Integer status, String message, T data) {
        return BaseResult.<T>builder()
                .status(status)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> BaseResult<T> result(ResultCode resultCode) {
        return result(resultCode, null);
    }

    public static <T> BaseResult<T> result(ResultCode resultCode, T data) {
        return BaseResult.<T>builder()
                .status(resultCode.getStatus())
                .message(resultCode.getMessage())
                .data(data)
                .build();
    }


    public static boolean isSuccess(BaseResult<?> baseResult) {
        if (baseResult != null && ResultCode.SUCCESS.getStatus().equals(baseResult.getStatus())) {
            return true;
        }
        return false;
    }
}