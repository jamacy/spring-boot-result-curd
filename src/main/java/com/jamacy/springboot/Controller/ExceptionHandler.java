package com.jamacy.springboot.Controller;

import exception.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {
//    @ResponseBody
//    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        // 传入我们的错误代码 4xx，5xx 否则就不会进入定制的错误代码解析流程
        Map<String,Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",404);
        map.put("code","user.notexist");
        map.put("message",e.getMessage());

        return "forward:/error";
    }
}
