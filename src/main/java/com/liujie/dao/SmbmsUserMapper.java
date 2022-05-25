package com.liujie.dao;

import com.liujie.model.SmbmsUser;
import com.liujie.vo.Page;

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

    SmbmsUser login(SmbmsUser user);

    List<SmbmsUser> pageList(Page page);

    int totalCount();

    /**
     * <select id="listProduct" resultType="Product">
     * SELECT * FROM product_
     * <where>
     * <choose>
     * <when test="name != null">
     * and name like concat('%',#{name},'%')
     * </when>
     * <when test="price !=null and price != 0">
     * and price > #{price}
     * </when>
     * <otherwise>
     * and id >1
     * </otherwise>
     * </choose>
     * </where>
     * </select>
     */
}