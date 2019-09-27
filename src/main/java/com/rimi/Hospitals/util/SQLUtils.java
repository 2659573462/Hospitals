package com.rimi.Hospitals.util;

import com.rimi.Hospitals.common.NameHandler;
import com.rimi.Hospitals.common.SQLContext;
import java.beans.BeanInfo;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态拼接SQL
 *
 * @author shangzf
 * @date 2019/9/19 9:52 下午
 */
public class SQLUtils {

    private SQLUtils() {
    }

    /**
     * 构建insert语句
     *
     * @param entity      实体映射对象
     * @param nameHandler 名称转换处理器
     * @return SQLContext对象
     */
    public static SQLContext buildInsertSQL(Object entity, NameHandler nameHandler) {
        Class<?> clazz = entity.getClass();
        String tableName = nameHandler.getTableName(clazz.getSimpleName());
        StringBuilder sql = new StringBuilder("insert into ");
        List<Object> params = new ArrayList<Object>();
        sql.append(tableName);
        //获取属性信息
        BeanInfo beanInfo = ClassUtils.getSelfBeanInfo(clazz);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        sql.append("(");
        StringBuilder args = new StringBuilder();
        args.append("(");
        for (PropertyDescriptor pd : pds) {
            Object value = getReadMethodValue(pd.getReadMethod(), entity);
            if (value == null) {
                continue;
            }
            sql.append(nameHandler.getColumnName(pd.getName()));
            args.append("?");
            params.add(value);
            sql.append(",");
            args.append(",");
        }
        sql.deleteCharAt(sql.length() - 1);
        args.deleteCharAt(args.length() - 1);
        args.append(")");
        sql.append(")");
        sql.append(" values ");
        sql.append(args);
        return SQLContext.of(sql, params);
    }

    /**
     * 构建更新sql
     *
     * @param entity      实体映射对象
     * @param nameHandler 名称转换处理器
     * @return SQLContext对象
     */ 
    public static SQLContext buildUpdateSQL(Object entity, NameHandler nameHandler) {
        Class<?> clazz = entity.getClass();
        StringBuilder sql = new StringBuilder();
        List<Object> params = new ArrayList<Object>();
        String tableName = nameHandler.getTableName(clazz.getSimpleName());
        String primaryName = nameHandler.getPrimaryName(clazz.getSimpleName());
        //获取属性信息
        BeanInfo beanInfo = ClassUtils.getSelfBeanInfo(clazz);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        sql.append("update ");
        sql.append(tableName);
        sql.append(" set ");
        Object primaryValue = null;
        for (PropertyDescriptor pd : pds) {
            Object value = getReadMethodValue(pd.getReadMethod(), entity);
            if (value == null) {
                continue;
            }
            String columnName = nameHandler.getColumnName(pd.getName());
            if (primaryName.equalsIgnoreCase(columnName)) {
                primaryValue = value;
            }
            sql.append(columnName);
            sql.append(" = ");
            sql.append("?");
            params.add(value);
            sql.append(",");
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" where ");
        sql.append(primaryName);
        sql.append(" = ?");
        params.add(primaryValue);
        return SQLContext.of(sql, params);
    }

    /**
     * 构建查询条件
     *
     * @param entity      实体映射对象
     * @param nameHandler 名称转换处理器
     * @return SQLContext对象
     */

    public static SQLContext buildQuerySQL(Object entity, NameHandler nameHandler) {
        Class<?> clazz = entity.getClass();
        //获取属性信息
        BeanInfo beanInfo = ClassUtils.getSelfBeanInfo(entity.getClass());
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        StringBuilder sql = new StringBuilder("select * from ");
        String tableName = nameHandler.getTableName(clazz.getSimpleName());
        sql.append(tableName);
        sql.append(" where ");
        List<Object> params = new ArrayList<Object>();
        int count = 0;
        for (PropertyDescriptor pd : pds) {
            Object value = getReadMethodValue(pd.getReadMethod(), entity);
            if (value == null) {
                continue;
            }
            if (count > 0) {
                sql.append(" and ");
            }
            sql.append(nameHandler.getColumnName(pd.getName()));
            sql.append(" = ?");
            params.add(value);
            count++;
        }
        return SQLContext.of(sql, params);
    }

    /**
     * 获取属性值
     *
     * @param readMethod 读取的方法
     * @param entity     实体
     * @return 属性值
     */
    private static Object getReadMethodValue(Method readMethod, Object entity) {
        if (readMethod == null) {
            return null;
        }
        try {
            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                readMethod.setAccessible(true);
            }
            return readMethod.invoke(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
