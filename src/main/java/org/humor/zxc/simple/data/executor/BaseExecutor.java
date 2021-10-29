package org.humor.zxc.simple.data.executor;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Date: 2021/1/26
 * Time: 5:51 下午
 *
 * @author xuzz
 */
public abstract class BaseExecutor {

    protected Statement statement;

    public void init() {

        String url = "jdbc:mysql://rm-bp1hddend5q83p03g674.mysql.rds.aliyuncs.com:3306/zm_ai_user_course?useUnicode=true&autoReconnect=true&rewriteBatchedStatements=TRUE&zeroDateTimeBehavior=convertToNull&useTimezone=true&serverTimezone=GMT%2B8";
        String username = "ai_group";
        String password = "fL00zxyDd9DZ1Pzu";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            this.statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public abstract int update(String sql);

    public abstract Object query(String sql, Map<String, String> columnMap);

}
