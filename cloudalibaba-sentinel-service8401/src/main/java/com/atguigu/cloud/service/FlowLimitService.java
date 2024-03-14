package com.atguigu.cloud.service;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class FlowLimitService {

    @SentinelResource(value = "dome")
    public void dome(){
        System.out.println("dome.....");
    }
}
