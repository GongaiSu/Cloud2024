package com.atguigu.cloud.api;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "cloud-gateway")
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

    @GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/bulkhead/{id}")
    public String myBulkhead(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/ratelimit/{id}")
    public String myRatelimit(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例01
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例02
     * @return
     */
    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo();
}
