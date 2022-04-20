package com.liujie.dao;

import com.liujie.model.SmbmsUser;

import java.util.List;

public interface SmbmsUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmbmsUser record);

    int insertSelective(SmbmsUser record);

    SmbmsUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmbmsUser record);

    int updateByPrimaryKey(SmbmsUser record);

    SmbmsUser selectAddressById(Integer id);

    List<SmbmsUser> selectByIds(String[] id);
}