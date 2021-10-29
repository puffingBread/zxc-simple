package org.humor.zxc.simple.data.executor;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2021/1/27
 * Time: 4:00 下午
 *
 * @author xuzz
 */
@Component
public class SimpleExecutor extends BaseExecutor {

    @Override
    public int update(String sql) {

        boolean result;
        try {
            result = statement.execute(sql);
        } catch (SQLException ignored) {
            result = false;
        }
        return result ? 1 : 0;
    }

    @Override
    public Object query(String sql, Map<String, String> columnMap) {

        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql);
            Map<String, Object> resultMap = new HashMap<>(2);
            while (resultSet.next()) {
                resultMap.put("id", resultSet.getLong("id"));
                resultMap.put("plan_id", resultSet.getLong("plan_id"));
            }
            return resultMap;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
