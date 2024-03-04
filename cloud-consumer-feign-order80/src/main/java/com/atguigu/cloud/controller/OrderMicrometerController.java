package com.atguigu.cloud.controller;

import com.atguigu.cloud.api.OpenFeignApi;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyy
 * @create 2023-11-17 17:54
 *
 * Micrometer 替代 Sleuth
 */
@RestController
@Slf4j
public class OrderMicrometerController
{
    @Resource
    private OpenFeignApi openFeignApi;

    @GetMapping(value = "/feign/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id)
    {
        return openFeignApi.myMicrometer(id);
    }
}
