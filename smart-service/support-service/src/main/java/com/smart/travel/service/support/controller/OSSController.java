package com.smart.travel.service.support.controller;

import com.smart.travel.common.core.result.BaseResult;
import com.smart.travel.service.support.service.OSSService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author ybq
 */
@RestController
@RequestMapping("/support/oss")
public class OSSController {

    @Resource
    OSSService ossService;

    /**
     * 文件上传
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public BaseResult<String> upload(@RequestBody MultipartFile file) throws IOException {
        return BaseResult.success(ossService.upload(file));
    }
}
