package com.liujie.handler;

import com.liujie.exception.LoginExcetion;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserExceptionHandller {


    @ExceptionHandler(LoginExcetion.class)
    @ResponseBody
    public Map loginz(Exception exception) {
        Map<String, Object> map = new HashMap<>();

        map.put("success", false);
        map.put("msg", exception.getMessage());

        System.out.println(exception.getMessage());
        return map;
    }
}
