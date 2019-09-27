package com.rimi.Hospitals.serice;

import com.rimi.Hospitals.common.Page;
import com.rimi.Hospitals.entity.Patients;
import com.rimi.Hospitals.entity.nurse;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/27 20:38
 */
public interface patientsSerice {
    /**
     * 查询所有的患者信息
     * @return
     */
    List<Patients> selectPatients();


    /**
     * 查询患者信息哪一条到哪里
     * @return
     */
    List<Patients> selectListServlce(Integer currentPage, Integer pageSize);



    /**
     * 分页查询
     *
     * @param page 分页
     * @return 分页后的信息,这个针对的是book书对象的借阅信息
     */
    Page<Patients> findPagedBooks(Page page);

    /**
     * 传入患者的唯一遍历号
     * 删除这条数据
     * @param in
     * @return
     */
    int deletePatients(String in);

    /**
     * 添加数据到患者数据库
     * @param params
     */
    void addPatients(Map<String, String[]> params);

    /**
     * 更新患者数据
     * @param parameterMap
     */
    void updatePatients(Map<String, String[]> parameterMap);

    /**
     * 根据id查询患者信息
     * @param id
     * @return
     */
    Patients selectId(String id);
}
