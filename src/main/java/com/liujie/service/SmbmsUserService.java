package com.liujie.service;

import com.liujie.exception.LoginExcetion;
import com.liujie.model.SmbmsUser;
import com.liujie.vo.Page;
import com.liujie.vo.PaginationVo;

import java.util.Map;

public interface SmbmsUserService {
    SmbmsUser login(SmbmsUser user) throws LoginExcetion;

    PaginationVo pageList(Page page);

    Map<String, Object> deleteById(String id);

    Map<String, Object> addUser(SmbmsUser user);
}
