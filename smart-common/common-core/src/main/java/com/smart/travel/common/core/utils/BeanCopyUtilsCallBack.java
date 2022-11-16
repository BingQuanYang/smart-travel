package com.smart.travel.common.core.utils;

/**
 * @author ybq
 */
public interface BeanCopyUtilsCallBack<S, T> {
    /**
     * 回调接口
     * @param t
     * @param s
     */
    void callBack(S t, T s);
}
