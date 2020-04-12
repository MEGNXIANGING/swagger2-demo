package com.example.demo.controller;

import com.example.demo.swagger.annos.ApiJsonObject;
import com.example.demo.swagger.annos.ApiJsonProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: apple
 * @Description: 测试
 * @Date: 2020/2/15 上午10:56
 */
@Api(value = "测试Controller" , tags = "测试类")
@RequestMapping("/swagger")
@RestController
public class helloController {
//    @ApiOperation("你好接口")
//    @RequestMapping(value = "/hello",method = RequestMethod.GET)
//    public String hello(){
//        return "hello world";
//    }
//    @ApiOperation("测试接口")
//    @PostMapping(value = "/hello/test")
//    public String helloTest(@ApiParam("消息") @RequestBody String message){
//        return message;
//    }

    @ApiOperation("测试map接口")
    @ApiJsonObject(name = "params", value = {
            @ApiJsonProperty(type = Integer.class,key = "mobile", example = "18614242538", description = "user mobile"),
            @ApiJsonProperty(type = Integer.class,key = "password", example = "123456", description = "user password"),
            @ApiJsonProperty(type = String.class,key = "name", example = "", description = "user 姓名")
    })
    @PostMapping(value = "/hello/test/map")
    public String helloTestMap(@RequestBody Map<String,Object> params){
        return "aaa";
    }

    @ApiOperation("测试map接口")
    @ApiJsonObject(name = "params", value = {
            @ApiJsonProperty(type = Integer.class,key = "mobile", example = "18614242538", description = "user mobile"),
            @ApiJsonProperty(type = Integer.class,key = "password", example = "123456", description = "user password")
    })
    @PostMapping(value = "/hello/map")
    public String helloMap(@RequestBody Map<String,Object> params){
        return "bbb";
    }

    @PostMapping("/selectIndentNumberByPrimaryIdAndName")
    @ApiJsonObject(name = "params", value = {
            @ApiJsonProperty(type = Integer.class,key = "mobile", example = "18614242538", description = "user mobile"),
            @ApiJsonProperty(type = Integer.class,key = "password", example = "123456", description = "user password"),
            @ApiJsonProperty(type = String.class,key = "name", example = "", description = "user 姓名"),
            @ApiJsonProperty(type = Integer.class,key = "page", example = "", description = "当前页"),
            @ApiJsonProperty(type = Integer.class,key = "rows", example = "15", description = "行数"),
            @ApiJsonProperty(type = Integer.class,key = "info", example = "关于", description = "..",required = false)
    })
    @ApiOperation(value = "视频回放", notes = "courseLessonId 课时编号 不能为空")
    public String selectIndentNumberByPrimaryIdAndName(@RequestBody Map<String,Object> params){

        return "ssssssssss";
    }


}
