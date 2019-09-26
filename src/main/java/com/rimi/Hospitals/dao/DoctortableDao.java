package com.rimi.Hospitals.dao;

import com.rimi.Hospitals.entity.Doctortable;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/25 17:22
 */
public interface DoctortableDao {
    /**
     * 查询所有的数据
     * @return
     */
    List<Doctortable> selectDoctortables();

    /**
     * 查询数据多少到多少
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Doctortable> selectLin(Integer currentPage, Integer pageSize);

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
    int deleteHosp(String in);

    /**
     * 添加医生数据
     * @param params
     */
    void addHospitals(Map<String, String[]> params);
}
