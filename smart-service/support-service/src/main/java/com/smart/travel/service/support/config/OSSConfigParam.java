package com.smart.travel.service.support.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ybq
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "oss")
public class OSSConfigParam {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String objectName;

}
