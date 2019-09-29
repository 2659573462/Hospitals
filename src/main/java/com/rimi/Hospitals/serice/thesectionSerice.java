package com.rimi.Hospitals.serice;

import com.rimi.Hospitals.common.Page;
import com.rimi.Hospitals.entity.nurse;
import com.rimi.Hospitals.entity.thesectiontable;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/28 13:16
 */
public interface thesectionSerice {

    /**
     * 查询所有的科室信息
     * @return
     */
    List<thesectiontable> selectThesection();


    /**
     * 查询哪一条到哪里
     * @return
     */
    List<thesectiontable> selectListServlce(Integer currentPage, Integer pageSize);



    /**
     * 分页查询
     *
     * @param page 分页
     * @return 分页后的信息,这个针对的是book书对象的借阅信息
     */
    Page<thesectiontable> findPagedBooks(Page page);

    /**
     * 传入科室的唯一名
     * 删除这条数据
     * @param in
     * @return
     */
    int deleteThesection(String in);

    /**
     * 添加数据到数据库
     * @param params
     */
    void addThesection(Map<String, String[]> params);

    /**
     * 更新数据
     * @param parameterMap
     */
    void updateThesection(Map<String, String[]> parameterMap);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    thesectiontable selectThesectionId(String id);

}
