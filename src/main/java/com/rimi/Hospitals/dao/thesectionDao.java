package com.rimi.Hospitals.dao;

import com.rimi.Hospitals.entity.nurse;
import com.rimi.Hospitals.entity.thesectiontable;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/28 13:41
 */
public interface thesectionDao {

    /**
     * 查询所有的数据
     * @return
     */
    List<thesectiontable> selectThesectionTable();

    /**
     * 查询数据多少到多少
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<thesectiontable> selectLin(Integer currentPage, Integer pageSize);

    /**
     * 查询数据的总数
     * @return
     */
    Integer count();

    /**
     * 删除科室数据更具科室名
     * @param in
     * @return
     */
    int deleteThesection(String in);

    /**
     * 添加科室数据
     * @param params
     */
    void addThesection(Map<String, String[]> params);

    /**
     * 更新科室数据
     * @param parameterMap
     */
    void updateThesection(Map<String, String[]> parameterMap);

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    thesectiontable selectThesectionId(String id);
}
