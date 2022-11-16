package com.smart.travel.service.support.config;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.teaopenapi.models.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author ybq
 */
@Configuration
public class SupportlConfig {

    /**
     * 使用AK&SK初始化账号Client
     *
     * @return Client
     * @throws Exception
     */
    @Bean
    public Client client(SMSConfigParam smsConfigParam) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(smsConfigParam.getAccessKeyId())
                // 您的AccessKey Secret
                .setAccessKeySecret(smsConfigParam.getAccessKeySecret());
        // 访问的域名
        config.endpoint = smsConfigParam.getEndpoint();
        return new Client(config);
    }
}
