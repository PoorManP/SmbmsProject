package com.liujie.dao;

import com.liujie.model.SmbmsProviderModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//dao这个包是对数据库进行操作的

//一个接口参应一个数据库表  对应一张的增删改查
public interface SmbmsProvider {
//    在接口当中，我们不需要对接口入进行实现，我们只需要抽象定义好接口方法就好，由外部来进行实现

//   查询所有供应商
    List<SmbmsProviderModel> queryFrist();

//如果传入的参数是一个的话我们可以在mapper.xml接口映射文件#{形参名}  @Param("")

//    传入一个对象 如果传入的是一个对象的 #{属性名}
//    @Param("id") String id;
//    map  也是一样的  #{key}
//    按id来查供应商
    SmbmsProviderModel queryById(String id);


    int updateById(SmbmsProviderModel providerModel);


    int insertProvider(SmbmsProviderModel providerModel);


    int deleteById(String id);


    List<SmbmsProviderModel> getProviderLimit(Map<String,String[]> map);


}
