package com.liujie.service.impl;

import com.liujie.dao.SmbmsRoleMapper;
import com.liujie.model.SmbmsRole;
import com.liujie.service.SmbmsRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SmbmsRoleServiceImpl implements SmbmsRoleService {
    @Resource
    private SmbmsRoleMapper roleMapper;
    @Override
    public List<SmbmsRole> queryList() {
        List<SmbmsRole> list = roleMapper.queryList();

        if (list == null) {
            return null;
        }

        return list;
    }
}
