package com.liujie.service;

import com.liujie.exception.LoginExcetion;
import com.liujie.model.SmbmsUser;

import java.util.Map;

public interface SmbmsUserService {
    SmbmsUser login(SmbmsUser user) throws LoginExcetion;
}
