package com.liujie.web.webcontroller;

import com.liujie.exception.LoginExcetion;
import com.liujie.model.SmbmsUser;
import com.liujie.service.SmbmsBillService;
import com.liujie.service.SmbmsUserService;
import com.liujie.utils.DateTimeUtil;
import com.liujie.vo.Page;
import com.liujie.vo.PaginationVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    SmbmsBillService smbmsBillService;

    @Resource
    SmbmsUserService userService;

    @RequestMapping(value = "/pageList.do")
    @ResponseBody
    public PaginationVo pageList(Page page) {

//        System.out.println("list.do");
        /* System.out.println(page);*/
        int skipCount = (page.getPageNo() - 1) * page.getPageSize();
        page.setSkipCount(skipCount);

        PaginationVo vo = userService.pageList(page);

        System.out.println(vo);
        return vo;
    }

    @RequestMapping(value = "/delUser.do")
    @ResponseBody
    public Map<String, Object> delUser(String id) {
        Map<String,Object> map = userService.deleteById(id);

        return map;
    }

    @RequestMapping(value = "/addUser.do")
    @ResponseBody
    public Map<String, Object> addUser(SmbmsUser user, HttpServletRequest request) {

        System.out.println(user);
        HttpSession session = request.getSession();

        SmbmsUser curUser = (SmbmsUser)session.getAttribute("user");

        user.setCreationDate(DateTimeUtil.getSysTime());

        user.setCreatedBy(curUser.getId());


        Map<String, Object> map = userService.addUser(user);

        return map;

    }

    @RequestMapping(value = "userInfo.do")
    @ResponseBody
    public SmbmsUser userInfo(Integer id) {
        SmbmsUser user = userService.queryById(id);
        return user;
    }

    @RequestMapping(value = "/updateUser.do")
    @ResponseBody
    public Map<String, Object> updateUser(SmbmsUser user) {

        System.out.println(user);
        Map<String, Object> map = userService.update(user);

        return map;
    }
}
