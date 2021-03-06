package com.liujie.dao;

import com.liujie.model.SmbmsRole;

import java.util.List;

public interface SmbmsRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmbmsRole record);

    int insertSelective(SmbmsRole record);

    SmbmsRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmbmsRole record);

    int updateByPrimaryKey(SmbmsRole record);

    List<SmbmsRole> queryList();
}