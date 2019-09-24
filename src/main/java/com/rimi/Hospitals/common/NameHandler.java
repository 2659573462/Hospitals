package com.rimi.Hospitals.common;

/**
 * 名称处理器，可以使类和表名相互转换
 *
 * @author shangzf
 * @date 2019/9/19 9:59 下午
 */
public interface NameHandler {



    /**
     * 根据实体名获取表名
     *
     * @param entityName 实体名称
     * @return 表名
     */
    default String getTableName(String entityName){
        return "";
    }

    /**
     * 根据表名获取主键名称
     *
     * @param entityName 实体名称
     * @return 主键名称
     */
    default String getPrimaryName(String entityName){
        return "";
    }

    /**
     * 根据属性名获取列名
     *
     * @param fieldName 实体名称
     * @return 列名
     */
    default String getColumnName(String fieldName){
        return "";
    }
}
