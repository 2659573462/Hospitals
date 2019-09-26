package com.rimi.Hospitals.serice;

import com.rimi.Hospitals.common.Page;
import com.rimi.Hospitals.entity.Doctortable;

import java.util.List;
import java.util.Map;

/**
 * 查询医生的serice
 *
 * @author chenjin
 * @date 2019/9/25 17:15
 */
public interface IndexService {
    /**
     * 查询所有的医生信息
     * @return
     */
    List<Doctortable> selectDoctortable();

    /**
     * 查询哪一条到哪里
     * @return
     */
    List<Doctortable> selectListServlce(Integer currentPage, Integer pageSize);



    /**
     * 分页查询
     *
     * @param page 分页
     * @return 分页后的信息,这个针对的是book书对象的借阅信息
     */
    Page<Doctortable> findPagedBooks(Page page);

    /**
     * 传入医生的唯一工作号
     * @param in
     * @return
     */
    int deleteHosp(String in);

    /**
     * 添加数据到数据库
     * @param params
     */
    void addHospitals(Map<String, String[]> params);
}
