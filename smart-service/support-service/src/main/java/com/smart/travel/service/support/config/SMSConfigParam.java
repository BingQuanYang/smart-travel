package com.smart.travel.service.support.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ybq
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sms")
public class SMSConfigParam {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String signName;
    private String templateCode;
}
