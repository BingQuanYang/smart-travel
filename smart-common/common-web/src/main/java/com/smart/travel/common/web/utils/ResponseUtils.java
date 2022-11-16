package com.smart.travel.common.web.utils;

import com.alibaba.fastjson.JSON;
import com.smart.travel.common.core.result.BaseResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ybq
 */
public class ResponseUtils {

    public static void responseToJson(HttpServletResponse response, BaseResult<?> result) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().println(JSON.toJSONString(result));
    }
}
