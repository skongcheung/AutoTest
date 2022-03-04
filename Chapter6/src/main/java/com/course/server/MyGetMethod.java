package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/")
public class MyGetMethod {

    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获得cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){

        //HttpServletRequest装请求信息的类
        //HttpServletResponse装返回信息的类
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies成功";

    }

    /**
     * 要求客户端携带Cookies访问
     * 这是一个需要携带Cookies才能访问的get请求
     */
    @RequestMapping(value = "/getWithCooikes", method = RequestMethod.GET)
    @ApiOperation(value = "要求携带Cookies信息访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){

        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return "你没有携带Cookies信息来";
        }
        for (Cookie cookie : cookies){
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "恭喜你已经携带Cookies信息访问成功";
            }
        }
        return "你必须携带Cookies信息来";
    }

    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种实现方式 url:key=value&key=value
     * 我们来模拟获取商品列表
     */
    @RequestMapping(value = "/getWithParam", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的的请求的第一种实现",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end){

        Map<String,Integer> myList = new HashMap<>();
        myList.put("衣服",100);
        myList.put("鞋子",300);
        myList.put("裤子",200);

        return myList;
    }

    /**
     * 第二种需要携带参数访问的get请求
     * url:ip:port/getWithParam/10/20
     */

    @RequestMapping(value = "/getWithParam/{start}/{end}")
    @ApiOperation(value = "需要携带参数才能访问的的请求的第二种实现",httpMethod = "GET")
    public Map<String, Integer> myGetList(@PathVariable Integer start,
                                          @PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("衣服",100);
        myList.put("鞋子",300);
        myList.put("裤子",200);

        return myList;

    }

}