package com.atguigu.cloud.api;

import com.atguigu.cloud.enums.ReturnCodeEnum;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.stereotype.Component;

/**
 * @auther zzyy
 * @create 2023-11-30 20:22
 */
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi
{
    @Override
    public ResultData getPayByOrderNo(String orderNo)
    {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),"对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}