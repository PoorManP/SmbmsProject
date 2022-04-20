package com.liujie.dao;

import com.liujie.model.SmbmsBill;
import com.liujie.model.SmbmsProviderModel;

import java.util.List;
import java.util.Map;

public interface SmbmsBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmbmsBill record);

    int insertSelective(SmbmsBill record);

    SmbmsBill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmbmsBill record);

    int updateByPrimaryKey(SmbmsBill record);

    List<SmbmsBill> selectByProviderInfo(Map map);


    List<SmbmsBill> test(String productName);
}