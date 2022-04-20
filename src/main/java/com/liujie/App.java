package com.liujie;

import com.liujie.dao.SmbmsBillMapper;
import com.liujie.dao.SmbmsProvider;
import com.liujie.dao.SmbmsUserMapper;
import com.liujie.model.SmbmsBill;
import com.liujie.model.SmbmsProviderModel;
import com.liujie.model.SmbmsUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
//        读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis.xml");

//        构建sqlsessionFactorybuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        调用builder对象的build方法
        SqlSessionFactory factory = builder.build(in);

//        得到会话对象
//        在打开会话的时候，factory对象.opensession()里面有个参数 boolean 如果true事务提交的 ,默认是flase不提交事件
        SqlSession session = factory.openSession(true);


        SmbmsUserMapper mapper = session.getMapper(SmbmsUserMapper.class);


        String[] ids = new String[]{"1","2","3"};


        List<SmbmsUser> smbmsUsers = mapper.selectByIds(ids);


        for (SmbmsUser smbmsUser : smbmsUsers) {
            System.out.println(smbmsUser);
        }
//
//        List<SmbmsBill> list = mapper.test("油");

//        System.out.println(list);
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("productName","可");
//        map.put("id",2);
//        map.put("isPay", 2);
//        List<SmbmsBill> list = mapper.selectByProviderInfo(map);
//
//        list.forEach(l-> System.out.println(l));

//        SmbmsUser smbmsUser = mapper.selectAddressById(1);
//
//        System.out.println(smbmsUser);
//
//        System.out.println(smbmsUser.getListAddress());


//        session坐话了 就可以操作数据库了
//
//        SmbmsProvider mapper = session.getMapper(SmbmsProvider.class);
//        List<SmbmsProviderModel> smbmsProviderModels = mapper.queryFrist();
//
////        mapper.insertProvider()
//
////       getMapper(Interaface.class)
//        smbmsProviderModels.forEach(l-> System.out.println(l));
//        SmbmsProviderModel p = new SmbmsProviderModel();
//
//        p.setProPhone("2111");
//        p.setProCode("1009");
//        p.setCreatedBy("12312");
//        p.setProName("lj");
//
//        int insert = session.insert("com.liujie.dao.SmbmsProvider.insertProvider", p);
//
//        System.out.println(insert);

//        提交事务 （增删改）Committing JDBC Connection [com.mysql.jdbc.JDBC4Connection@7494e528]
//        session.commit();




    }
}
