package com.rimi.Hospitals.serice;

import com.rimi.Hospitals.common.Page;
import com.rimi.Hospitals.entity.drug;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/28 1:25
 */
public interface drugSerice {

    /**
     * 查询所有的药品信息
     * @return
     */
    List<drug> selectGrup();


    /**
     * 查询哪一条到哪里
     * @return
     */
    List<drug> selectListServlce(Integer currentPage, Integer pageSize);



    /**
     * 分页查询
     *
     * @param page 分页
     * @return 分页后的信息,这个针对的是book书对象的借阅信息
     */
    Page<drug> findPagedBooks(Page page);

    /**
     * 传入药品的唯一国字号
     * 删除这条数据
     * @param in
     * @return
     */
    int deleteGrup(String in);

    /**
     * 添加数据到数据库
     * @param params
     */
    void addGrup(Map<String, String[]> params);

    /**
     * 更新数据
     * @param parameterMap
     */
    void updateGrup(Map<String, String[]> parameterMap);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    drug selectGrupId(String id);

}
