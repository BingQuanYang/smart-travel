package com.smart.travel.service.support.controller;

import com.smart.travel.common.core.result.BaseResult;
import com.smart.travel.service.support.service.SMSService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ybq
 */
@RestController
@RequestMapping("/support/sms")
public class SMSController {

    @Resource
    SMSService smsService;

    @GetMapping("/send-code/{phone}/")
    public BaseResult<String> sendCode(@PathVariable("phone") String phone) {
        return BaseResult.success(smsService.sendCode(phone));
    }
}
