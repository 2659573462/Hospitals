package com.rimi.Hospitals.common;

import java.util.List;

/**
 * Sql帮助类
 *
 * @author shangzf
 * @date 2019/9/19 9:53 下午
 */
public class SQLContext {
    /**
     * 执行的sql
     */
    private StringBuilder sql;

    /**
     * 参数，对应sql中的?号
     */
    private List<Object> params;

    private SQLContext(StringBuilder sql, List<Object> params) {
        this.sql = sql;
        this.params = params;
    }

    /**
     * 获取SQLContext帮助类对象
     *
     * @param sql    SQL语句
     * @param params 参数
     * @return SQLContext帮助类对象
     */
    public static SQLContext of(StringBuilder sql, List<Object> params) {
        return new SQLContext(sql, params);
    }


    public StringBuilder getSql() {
        return sql;
    }

    public List<Object> getParams() {
        return params;
    }
}
