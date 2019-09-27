package com.rimi.Hospitals.dao;

import com.rimi.Hospitals.entity.Patients;
import com.rimi.Hospitals.entity.nurse;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/27 20:45
 */
public interface patientsDao {
    /**
     * 查询所有的数据
     * @return
     */
    List<Patients> selectNurseTable();

    /**
     * 查询数据多少到多少
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Patients> selectLin(Integer currentPage, Integer pageSize);

    /**
     * 查询数据的总数
     * @return
     */
    Integer count();

    /**
     * 删除患者数据更具医生的工号
     * @param in
     * @return
     */
    int deleteNurse(String in);

    /**
     * 添加患者数据
     * @param params
     */
    void addNurse(Map<String, String[]> params);

    /**
     * 更新患者数据
     * @param parameterMap
     */
    void updateNurse(Map<String, String[]> parameterMap);

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    Patients selectId(String id);

}
