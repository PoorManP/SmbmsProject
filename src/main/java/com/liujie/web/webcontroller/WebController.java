package com.liujie.web.webcontroller;

import com.liujie.exception.LoginExcetion;
import com.liujie.model.SmbmsUser;
import com.liujie.service.SmbmsBillService;
import com.liujie.service.SmbmsUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WebController {

    @Resource
    SmbmsBillService smbmsBillService;


    @Resource
    SmbmsUserService userService;

    @RequestMapping("/get/{name}")
    public String getInfo(Model model, @PathVariable String name) {

        System.out.println(name);

        model.addAttribute("name", name);

        return "success";
    }

    @RequestMapping("/del.do")
    @ResponseBody
    public Map<String, Object> del(String name, Integer age) {
        Map<String, Object> map = new HashMap<>();

        map.put("success", true);

        map.put("name", name);
        map.put("age", age);
        return map;
    }

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, SmbmsUser user) throws LoginExcetion {

        System.out.println(user);
        SmbmsUser loginUser = userService.login(user);
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        request.getSession().setAttribute("user", loginUser);
        objectObjectHashMap.put("success", true);
        return objectObjectHashMap;
    }

}
