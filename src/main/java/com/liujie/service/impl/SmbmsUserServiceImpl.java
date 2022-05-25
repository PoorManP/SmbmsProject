package com.liujie.service.impl;

import com.liujie.dao.SmbmsUserMapper;
import com.liujie.exception.LoginExcetion;
import com.liujie.model.SmbmsUser;
import com.liujie.service.SmbmsUserService;
import com.liujie.utils.DateTimeUtil;
import com.liujie.vo.Page;
import com.liujie.vo.PaginationVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SmbmsUserServiceImpl implements SmbmsUserService {

    @Resource
    SmbmsUserMapper userMapper;
    @Override
    public SmbmsUser login(SmbmsUser user) throws LoginExcetion {
        SmbmsUser user1 = userMapper.login(user);
        System.out.println(user1);
        if(user1==null){
            throw new LoginExcetion("账号或密码错误");
        }

        return user1;

    }

    @Override
    public PaginationVo pageList(Page page) {
        List<SmbmsUser> list = userMapper.pageList(page);
        Date date = new Date();
        list.forEach(l->{
            l.setAge(Integer.parseInt(DateTimeUtil.getSysTime().substring(0,4))-Integer.parseInt(l.getBirthDay().substring(0,4)));
        });
        PaginationVo<SmbmsUser> smbmsUserPaginationVo = new PaginationVo<>();

        int count = userMapper.totalCount();

        smbmsUserPaginationVo.setDataList(list);

        smbmsUserPaginationVo.setTotal(count);

        return smbmsUserPaginationVo;
    }

    @Override
    public Map<String, Object> deleteById(String id) {
        int count = userMapper.deleteByPrimaryKey(Long.parseLong(id));
        HashMap<String,Object> map = new HashMap<>();

        if(count!=1){
            map.put("success", false);
        }else {
            map.put("success", true);
        }

        return map;



    }

    @Override
    public Map<String, Object> addUser(SmbmsUser user) {
        int count = userMapper.insert(user);


        Map<String, Object> map = new HashMap<>();



        if (count != 1) {
            map.put("success", false);
        }else {
            map.put("success", true);
        }

        return map;





    }
}
