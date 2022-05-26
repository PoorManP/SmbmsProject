package com.liujie.web.webcontroller;

import com.liujie.exception.LoginExcetion;
import com.liujie.model.SmbmsUser;
import com.liujie.service.SmbmsUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WebController {

    @Resource
    SmbmsUserService userService;

    @RequestMapping("/login.do")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, SmbmsUser user) throws LoginExcetion {

        System.out.println(user);
        SmbmsUser loginUser = userService.login(user);
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        request.getSession().setAttribute("user", loginUser);
        objectObjectHashMap.put("success", true);
        return objectObjectHashMap;
    }

    @RequestMapping(value = "/logout.do")
    public String logout(HttpServletRequest request) {
        request.getSession().setAttribute("user", null);

        return "redirect:index.jsp";
    }


}
