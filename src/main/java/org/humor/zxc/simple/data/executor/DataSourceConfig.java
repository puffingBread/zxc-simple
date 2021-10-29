package org.humor.zxc.simple.data.executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Date: 2021/1/28
 * Time: 11:07 上午
 *
 * @author xuzz
 */
@Configuration
public class DataSourceConfig {

//    @Bean
//    public BaseExecutor build() {
//
//
//        String url = "jdbc:mysql://rm-bp1hddend5q83p03g674.mysql.rds.aliyuncs.com:3306/zm_ai_user_course?useUnicode=true&autoReconnect=true&rewriteBatchedStatements=TRUE&zeroDateTimeBehavior=convertToNull&useTimezone=true&serverTimezone=GMT%2B8";
//        String username = "ai_group";
//        String password = "fL00zxyDd9DZ1Pzu";
//        Connection connection;
//        try {
//            connection = DriverManager.getConnection(url, username, password);
//            return connection.createStatement();
//        } catch (SQLException ignored) {
//
//        }
//        return null;
//    }
}
