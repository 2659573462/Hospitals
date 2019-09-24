package com.rimi.Hospitals.common;


import com.rimi.Hospitals.util.StringUtils;

/**
 * 默认的名称处理器
 *
 * @author shangzf
 * @date 2019/9/19 10:02 下午
 */
public class DefaultNameHandle implements NameHandler {

    /**
     * 主键后缀
     */
    private static final String PRI_SUFFIX = "_id";

    @Override
    public String getTableName(String entityName) {
        //Java属性的骆驼命名法转换回数据库下划线“_”分隔的格式
        return StringUtils.humpToUnderline(entityName);
    }

    @Override
    public String getPrimaryName(String entityName) {
        String underlineName = StringUtils.humpToUnderline(entityName);
        return underlineName + PRI_SUFFIX;
    }

    @Override
    public String getColumnName(String fieldName) {
        return StringUtils.humpToUnderline(fieldName);
    }
}
