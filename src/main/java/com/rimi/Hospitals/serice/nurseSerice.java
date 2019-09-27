package com.rimi.Hospitals.serice;

import com.rimi.Hospitals.common.Page;
import com.rimi.Hospitals.entity.Doctortable;
import com.rimi.Hospitals.entity.nurse;

import java.util.List;
import java.util.Map;

/**
 * 护士的数据的交互
 *
 * @author chenjin
 * @date 2019/9/27 14:14
 */
public interface nurseSerice {
    /**
     * 查询所有的护士信息
     * @return
     */
    List<nurse> selectNurse();


    /**
     * 查询哪一条到哪里
     * @return
     */
    List<nurse> selectListServlce(Integer currentPage, Integer pageSize);



    /**
     * 分页查询
     *
     * @param page 分页
     * @return 分页后的信息,这个针对的是book书对象的借阅信息
     */
    Page<nurse> findPagedBooks(Page page);

    /**
     * 传入护士的唯一工作号
     * 删除这条数据
     * @param in
     * @return
     */
    int deleteHosp(String in);

    /**
     * 添加数据到数据库
     * @param params
     */
    void addHospitals(Map<String, String[]> params);

    /**
     * 更新数据
     * @param parameterMap
     */
    void updateHospitals(Map<String, String[]> parameterMap);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    nurse selectId(String id);

}
