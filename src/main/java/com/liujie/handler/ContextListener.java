package com.liujie.handler;

import com.liujie.model.SmbmsRole;
import com.liujie.service.SmbmsRoleService;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.*;

public class ContextListener implements ServletContextListener {


//    @Resource
//    DicService service;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {



        ServletContext application = servletContextEvent.getServletContext();
        SmbmsRoleService smbmsRoleService = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext()).getBean(SmbmsRoleService.class);

        List<SmbmsRole> smbmsRoles = smbmsRoleService.queryList();

        application.setAttribute("roleList", smbmsRoles);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
