package com.rimi.Hospitals.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.rimi.Hospitals.exception.RecordNotUniqueException;

import javax.sql.DataSource;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * 数据连接工具
 * 该工具类的使用方法:
 * insert update delete语句调用executeUpdate方法
 * 例如:
 * String sql = "insert into table values(?)";
 * int count = JDBCUtils.executeUpdate(sql,"value");
 * select语句调用executeQuery方法
 * 例如:
 * String sql = "select * form table";
 * List<T> list = JDBCUtils.executeUpdate(T.class,sql);
 * 其中T为具体的实体类
 * 需要注意的:
 * 1.实体类型中字段名称和数据库表中的列名要保持一致,否则会出现null
 * 2.在使用数字类型时,如果数据库表中的列的类型为decimal类型,则转换成Java的类型为BigDecimal
 * 3.在使用日期类型时,如果数据库表中的列的类型为time/date/timestamp类型,则转换成Java的类型为date
 *
 * @author shangzf
 * @date 2019/8/28 16:13
 */
public class JDBCUtils {

    private static DataSource ds;

    static {
        try {
            // 初始化数据连接池
            InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 加载资源文件
            Properties props = new Properties();
            props.load(in);
            // druid使用资源文件创建数据连接池
            ds = DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 构造方法私有化,不能直接创建对象
     */
    private JDBCUtils() {
    }

    /**
     * 获取数据连接对象
     *
     * @return 数据连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 关闭并释放资源
     *
     * @param rs   ResultSet
     * @param stmt Statement
     * @param conn Connection
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭并释放资源
     *
     * @param stmt Statement
     * @param conn Connection
     */
    public static void close(Statement stmt, Connection conn) {
        close(null, stmt, conn);
    }

    /**
     * 如果执行的sql语句是"insert into user(name,password) values(?,?)",那么参数 sql = "insert into user(name) values(?)"
     * 执行sql 是 "delete from user"
     * Object... params 为可变参数,即该参数可以是一个,可以是2个,也可以没有
     * 使用的时候可以是这样子:
     * (1) String sql = "insert into user(username,password) values (?,?)";
     * String username = "张三";
     * String password = "123456";
     * int count = executeUpdate(sql,username,password);
     * (2) String sql = "delete from user where id = ?";
     * int id = 1;
     * int count = executeUpdate(sql,id);
     * (3) String sql = "update user set password = '123456'";
     * int count = executeUpdate(sql);
     * 可以执行 insert update delete 语句
     *
     * @param sql    执行的sql语句
     * @param params sql语句中的需要传递的参数
     * @return int 受影响行数
     */
    public static int executeUpdate(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 获取连接
            conn = getConnection();
            // 获取执行sql语句的对象
            ps = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    // 设置参数
                    ps.setObject(i + 1, params[i]);
                }
            }
            // 执行sql语句
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放
            close(ps, conn);
        }
        return -1;
    }
    // ResultSet rs = executeQuery(sql);

    /**
     * 执行查询方法
     *
     * @param aClass 指定需要返回数据的具体的类型
     * @param sql    执行查询的SQL语句
     * @param params 查询的条件
     */
    public static <T> List<T> executeQuery(Class<T> aClass, String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = null;
        try {
            // 获取连接
            conn = getConnection();
            // 获取执行sql语句的预编译对象
            ps = conn.prepareStatement(sql);
            // 设置参数
            // 判断参数是否为空,
            // 如果为空,则表明当前sql语句中没有参数需要设置
            if (params != null) {
                // 遍历参数
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            // 执行sql
            rs = ps.executeQuery();
            // 对集合进行初始化
            list = new ArrayList<>();
            while (rs.next()) {
                // 获取指定的类型的实例对象,相当于:User user = new User();
                T obj = aClass.newInstance();
                // 获取返回结果集的元数据集合,在这个集合中,可以获取到结果集有多少列
                // 元数据集合
                ResultSetMetaData metaData = rs.getMetaData();
                // 获取集合中的列
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    // 获取列的名称
                    String columnName = metaData.getColumnName(i);
                    // 把结果集中列和实例对象中的属性做对应
                    // 属性描述器,描述一个属性,
                    // 方法有:
                    // getPropertyType():获取属性的类型
                    // getReadMethod():  获取读取属性方法
                    // getWriteMethod():  获取写入属性方法

                    // TODO 把列名转换为驼峰命名的字段名
                    String fieldName = StringUtils.underLineToHump(columnName);
                    try {
                        PropertyDescriptor pd = new PropertyDescriptor(fieldName, aClass);
                        // 获取写入属性的方法
                        Method writeMethod = pd.getWriteMethod();
                        // 获取该列多对应的值
                        Object value = rs.getObject(columnName);
                        if (value instanceof Date){
                            value =new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
                        }
                        // 调用写入属性的方法,把属性设置到该对象中
                        writeMethod.invoke(obj, value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放
            close(rs, ps, conn);
        }
        return list;
    }

    /**
     * 查询一条记录
     *
     * @param aClass
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public static <T> T executeQueryForOne(Class<T> aClass, String sql, Object... params) {
        List<T> list = executeQuery(aClass, sql, params);
        // TODO 如果记录数大于1时,应该返回一个异常,没有时返回null
        if (list != null && list.size() > 0) {
            if (list.size() > 1) {
                // 抛出异常
                throw new RecordNotUniqueException("记录数大于1");
            }
            return list.get(0);
        }
        return null;
    }

    public static Integer executeQueryForCount(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = getConnection();
            // 获取执行sql语句的预编译对象
            ps = conn.prepareStatement(sql);
            // 设置参数
            // 判断参数是否为空,
            // 如果为空,则表明当前sql语句中没有参数需要设置
            if (params != null) {
                // 遍历参数
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            // 执行sql
            rs = ps.executeQuery();
            // 判断是否有结果
            if (rs.next()){
                // 获取数据
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放
            close(rs, ps, conn);
        }
        return null;
    }
}
