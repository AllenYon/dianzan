package com.alin;

import com.alin.dal.UserDal;
import com.alin.model.Twitter;
import com.alin.model.User;
import com.alin.service.TwitterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

//	public SqlSessionFactory getSqlSessionFactory() throws IOException {
//		// mybatis配置文件
//		String resource = "SqlMapConfig.xml";
//		// 得到配置文件流
//		InputStream inputStream = Resources.getResourceAsStream(resource);
//		// 创建会话工厂，传入mybatis的配置文件信息
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		return sqlSessionFactory;
//	}


    @Test
    public void contextLoads() {
    }


    @Autowired
    UserDal userDal;

    @Autowired
    TwitterService twitterService;

    @Test
    public void findAll() {
        List<User> all = userDal.findAll();
        System.out.println(all);

    }

    @Test
    public void like() {
        twitterService.like(1l, 1l);
        List<Twitter> all = twitterService.findAll();
        System.out.println(all);

    }

}
