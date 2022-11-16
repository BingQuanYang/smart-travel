package com.smart.travel.service.user.feign.service;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ybq
 */
@Configuration
@EnableFeignClients
@ComponentScan
public class FeignConfig {
}
