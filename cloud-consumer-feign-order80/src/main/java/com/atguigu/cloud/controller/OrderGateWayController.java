package com.atguigu.cloud.controller;

import com.atguigu.cloud.api.OpenFeignApi;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @auther zzyy
 * @create 2023-11-20 16:48
 */
@RestController
public class OrderGateWayController
{
    @Resource
    private OpenFeignApi openFeignApi;

    @GetMapping(value = "/feign/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id)
    {
        return openFeignApi.getById(id);
    }

    @GetMapping(value = "/feign/pay/gateway/info")
    public ResultData<String> getGatewayInfo()
    {
        return openFeignApi.getGatewayInfo();
    }

    @GetMapping(value = "/feign/pay/gateway/filter")
    public ResultData<String> getGatewayFilter(HttpServletRequest request){
        request.getParameterMap().forEach((key,value)->{
            System.out.println(key);
            System.out.println(Arrays.toString(value));
        });
        return openFeignApi.getGatewayFilter(request);
    }
}