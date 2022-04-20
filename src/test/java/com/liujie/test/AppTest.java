package com.liujie.test;

import static org.junit.Assert.assertTrue;

import com.liujie.dao.SmbmsUserMapper;
import com.liujie.model.SmbmsUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    public static SqlSession getSqlSeesion() {
        //        读取配置文件
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

//        构建sqlsessionFactorybuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        调用builder对象的build方法
        SqlSessionFactory factory = builder.build(in);

//        得到会话对象
//        在打开会话的时候，factory对象.opensession()里面有个参数 boolean 如果true事务提交的 ,默认是flase不提交事件
        SqlSession session = factory.openSession(true);
        return session;
    }

    @Test
    public void insertUser() {

        SqlSession sqlSeesion = getSqlSeesion();

        SmbmsUserMapper mapper = sqlSeesion.getMapper(SmbmsUserMapper.class);

        SmbmsUser smbmsUser = mapper.selectByPrimaryKey(1l);

        System.out.println(smbmsUser);
    }
}
