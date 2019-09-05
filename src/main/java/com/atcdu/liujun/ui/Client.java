package com.atcdu.liujun.ui;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
public class Client {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc.xml");
        DataSource dataSource=ac.getBean(DataSource.class);
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        JdbcTemplate jdbcTemplate= (JdbcTemplate) ac.getBean("jdbcTemplate");
        String sql="update userinfo set user_email=? where user_id=?";
        jdbcTemplate.update(sql, "1812@qq.com",1);
        connection.close();

    }
}
