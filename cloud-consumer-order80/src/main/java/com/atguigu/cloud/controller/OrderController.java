package com.atguigu.cloud.controller;


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

//    private static final String PaymentSrv_URL = "http://localhost:8001";
    private static final String PaymentSrv_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;



    @PostMapping("/consumer/pay/add")
    public ResultData<?> addOrder(@RequestBody PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add",payDTO,ResultData.class);
    }

    @DeleteMapping("/consumer/pay/delete/{id}")
    public ResultData<?> deleteOrder(@PathVariable("id") String id){

        String url = PaymentSrv_URL + "/pay/delete/" + id;
        HttpEntity<String> requestEntity = new HttpEntity<>("");
        ResponseEntity<ResultData> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, ResultData.class);
        return response.getBody();
    }
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData<?> getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class, id);

    }

    @PutMapping("/consumer/pay/update")
    public ResultData<?> updataOrder(@RequestBody PayDTO payDTO){

        String url = PaymentSrv_URL + "/pay/update";
        HttpEntity<PayDTO> requestEntity = new HttpEntity<>(payDTO);
        ResponseEntity<ResultData> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, ResultData.class);
        return response.getBody();
    }

    @GetMapping(value = "/consumer/pay/get/version")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/version", String.class);
    }
}
