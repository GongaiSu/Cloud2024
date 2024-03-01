package com.atguigu.cloud.controller;


import com.atguigu.cloud.api.OpenFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {


    @Resource
    private OpenFeignApi openFeignApi;



    @PostMapping("/feign/consumer/pay/add")
    public ResultData<?> addOrder(@RequestBody PayDTO payDTO){
        return openFeignApi.addPay(payDTO);
    }

    @DeleteMapping("/feign/consumer/pay/delete/{id}")
    public ResultData<?> deleteOrder(@PathVariable("id") Integer id){

        return openFeignApi.deletePay(id);
    }
    @GetMapping("/feign/consumer/pay/get/{id}")
    public ResultData<?> getPayInfo(@PathVariable("id") Integer id) {
        return openFeignApi.getPay(id);

    }

    @PutMapping("/feign/consumer/pay/update")
    public ResultData<?> updataOrder(@RequestBody PayDTO payDTO){
        return openFeignApi.updatePay(payDTO);
    }

    @GetMapping(value = "/feign/consumer/pay/get/version")
    private String getInfoByConsul()
    {
        return openFeignApi.getAtguiguVersion();
    }
}
