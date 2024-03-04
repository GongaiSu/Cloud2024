//package com.atguigu.cloud.error;
//
//
//import com.atguigu.cloud.resp.ResultData;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//@Slf4j
//public class GlobalExceptionHandler {
//
//
//    @ExceptionHandler(Exception.class)
//    public ResultData<?> handlerException(Exception e){
//        log.error("其他错误:{}",e.getMessage(),e);
//        return ResultData.fail("500",e.getMessage());
//    }
//}
