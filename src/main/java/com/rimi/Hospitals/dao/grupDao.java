package com.rimi.Hospitals.dao;

import com.rimi.Hospitals.entity.drug;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/28 1:29
 */
public interface grupDao {
    /**
     * 查询所有的数据
     * @return
     */
    List<drug> selectGrupTable();

    /**
     * 查询数据多少到多少
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<drug> selectLin(Integer currentPage, Integer pageSize);

    /**
     * 查询数据的总数
     * @return
     */
    Integer count();

    /**
     * 删除药品根据国字号
     * @param in
     * @return
     */
    int deleteGrup(String in);

    /**
     * 添加药品数据
     * @param params
     */
    void addGrup(Map<String, String[]> params);

    /**
     * 更新药品数据
     * @param parameterMap
     */
    void updateGrup(Map<String, String[]> parameterMap);

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    drug selectGrupId(String id);
}
