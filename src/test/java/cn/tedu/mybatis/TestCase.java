package cn.tedu.mybatis;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author LeafDust
 * @create 2019-10-08 15:24
 */
public class TestCase {
    ClassPathXmlApplicationContext context;
    UserMapper userMapper;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        userMapper = context.getBean("userMapper", UserMapper.class);
    }

    @Test
    public void getConnection() throws SQLException {
        BasicDataSource basicDataSource = context.getBean("basicDataSource", BasicDataSource.class);
        Connection connection = basicDataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("Assassin");
        user.setPassword("1234");
        user.setAge(18);
        user.setPhone("13895472136");
        user.setEmail("assassin@foxmail.com");
        user.setIsDelete(0);
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
        System.out.println(user);
    }

    @Test
    public void deleteById() {
        Integer id = 13;
        Integer rows = userMapper.deleteById(id);
        System.out.println("rows=" + rows);
    }

    @Test
    public void update() {
        Integer rows = userMapper.updatePassword("1234567");
        System.out.println(rows);
    }

    @Test
    public void deleteByIds() {
       Integer[] ids={1,2,3};
        Integer rows=userMapper.deleteByIds(ids);
        System.out.println(rows);
    }
    @Test
    public void find(){
        List<User> users=new ArrayList<>();
        String where=null;
        String orderBy="age DESC";
        Integer offset=0;
        Integer count=null;
        users=userMapper.find(where,orderBy,offset,count);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @After
    public void close() {
        context.close();
    }
}
