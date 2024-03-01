package com.atguigu.cloud.api;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "cloud-payment-service")
public interface OpenFeignApi {

    @PostMapping("/pay/add")
    ResultData<?> addPay(@RequestBody PayDTO payDTO);

    @DeleteMapping("/pay/delete/{id}")
    ResultData<?> deletePay(@PathVariable("id") Integer id);

    @PutMapping("/pay/update")
    ResultData<?> updatePay(@RequestBody PayDTO payDTO);

    @GetMapping("/pay/get/{id}")
    ResultData<?> getPay(@PathVariable("id") Integer id);

    @GetMapping("/pay/getAll")
    ResultData<?> getPay();


    @GetMapping("/pay/get/version")
    public String getAtguiguVersion();
}