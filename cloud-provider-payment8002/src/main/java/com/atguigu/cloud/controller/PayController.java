package com.atguigu.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@Tag(name="支付微服务模块",description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;


    @PostMapping("/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法，json串做参数")
    public ResultData<?> addPay(@RequestBody Pay pay){
        log.info(pay.toString());
        int i = payService.add(pay);
        return ResultData.sussess("成功插入记录，返回值："+i);
    }

    @DeleteMapping("/pay/delete/{id}")
    @Operation(summary = "删除",description = "支付流水删除方法")
    public ResultData<?> deletePay(@PathVariable("id") Integer id){
        int i = payService.delete(id);
        return ResultData.sussess("成功删除记录，返回值："+i);
    }

    @PutMapping("/pay/update")
    @Operation(summary = "修改",description = "支付流水修改方法")
    public ResultData<?> updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDTO,pay);
        int i = payService.update(pay);
        return ResultData.sussess("成功修改记录，返回值："+i);
    }

    @GetMapping("/pay/get/{id}")
    @Operation(summary = "按ID流水查看",description = "支付流水查看方法")
    public ResultData<?> getPay(@PathVariable("id") Integer id){
        Pay pay = payService.select(id);
        return ResultData.sussess(pay);
    }

    @GetMapping("/pay/getAll")
    @Operation(summary = "查看所有流水",description = "支付流水查看所有流水方法")
    public ResultData<?> getPay(){
        List<Pay> pays = payService.selectAll();
        return ResultData.sussess(pays);
    }





    @GetMapping("/pay/get/version")
    public String getAtguiguVersion(@Value("${server.port}") String atguiguVersion) throws InterruptedException {
        TimeUnit.SECONDS.sleep(6);
        return atguiguVersion;
    }
}
