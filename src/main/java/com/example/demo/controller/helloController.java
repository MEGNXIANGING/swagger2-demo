package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: apple
 * @Description: 测试
 * @Date: 2020/2/15 上午10:56
 */
@Api(value = "测试Controller" , tags = "测试类")
@RestController
public class helloController {
    @ApiOperation("你好接口")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello world";
    }
    @ApiOperation("测试接口")
    @RequestMapping(value = "/hello/test",method = RequestMethod.POST)
    public String helloTest(@ApiParam("消息") @RequestBody String message){
        return message;
    }

    @ApiOperation("测试map接口")
    @RequestMapping(value = "/hello/test/map",method = RequestMethod.POST)
    public Map helloTestMap(@ApiParam(value = "userId,用户名称") @RequestBody Map params){
        return params;
    }


}
