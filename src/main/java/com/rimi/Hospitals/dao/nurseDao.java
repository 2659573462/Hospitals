package com.rimi.Hospitals.dao;

import com.rimi.Hospitals.entity.Doctortable;
import com.rimi.Hospitals.entity.nurse;

import java.util.List;
import java.util.Map;

/**
 * 查询护士的Dao层
 *
 * @author chenjin
 * @date 2019/9/27 14:23
 */
public interface nurseDao {
    /**
     * 查询所有的数据
     * @return
     */
    List<nurse> selectNurseTable();

    /**
     * 查询数据多少到多少
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<nurse> selectLin(Integer currentPage, Integer pageSize);

    /**
     * 查询数据的总数
     * @return
     */
    Integer count();

    /**
     * 删除医生数据更具医生的工号
     * @param in
     * @return
     */
    int deleteNurse(String in);

    /**
     * 添加医生数据
     * @param params
     */
    void addNurse(Map<String, String[]> params);

    /**
     * 更新医生数据
     * @param parameterMap
     */
    void updateNurse(Map<String, String[]> parameterMap);

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    nurse selectId(String id);
}
