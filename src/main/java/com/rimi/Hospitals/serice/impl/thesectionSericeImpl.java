package com.rimi.Hospitals.serice.impl;

import com.rimi.Hospitals.common.Page;
import com.rimi.Hospitals.dao.impl.thesectionDaoImpl;
import com.rimi.Hospitals.dao.thesectionDao;
import com.rimi.Hospitals.entity.nurse;
import com.rimi.Hospitals.entity.thesectiontable;
import com.rimi.Hospitals.serice.thesectionSerice;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/28 13:39
 */
public class thesectionSericeImpl implements thesectionSerice {
    private thesectionDao these = new thesectionDaoImpl();

    /**
     * 查询所有的科室信息
     *
     * @return
     */
    @Override
    public List<thesectiontable> selectThesection() {
        List<thesectiontable> doctors=these.selectThesectionTable();
        if (doctors!=null && doctors.size() >0) {
            return doctors;
        }
        return null;
    }

    /**
     * 查询哪一条到哪里
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public List<thesectiontable> selectListServlce(Integer currentPage, Integer pageSize) {
        //1.直接执行dao层方法获取到数据
        List<thesectiontable> doctors=these.selectLin(currentPage,pageSize);
        //2.检查数据是否为空
        if (doctors!=null && doctors.size() >0) {
            return doctors;
        }
        return null;
    }

    /**
     * 分页查询
     *
     * @param page 分页
     * @return 分页后的信息, 这个针对的是book书对象的借阅信息
     */
    @Override
    public Page<thesectiontable> findPagedBooks(Page page) {
        //1.分页查询
        //2.获取分页的条件
        Integer currentPage = page.getCurrentPage();
        Integer pageSize = page.getPageSize();
        if (currentPage > 0) {
            currentPage -= 1;
        } else {
            currentPage = 0;
        }
        //3.通过查询获取总条数
        Integer count = these.count();
        page.setTotalCount(count);
        //4.判断分页开始的位置是否大于总条数
        int currentSize = currentPage * pageSize;
        if (currentSize > count){
            currentSize = (page.getPageCount() - 1) * pageSize;
        }
        //5.通过分页条件查询,并获取结果列表
        List<thesectiontable> booksList = these.selectLin(currentSize,pageSize);
        //6.把结果存放到page对象中
        page.setPageData(booksList);
        return page;
    }

    /**
     * 传入科室的唯一名
     * 删除这条数据
     *
     * @param in
     * @return
     */
    @Override
    public int deleteThesection(String in) {
        int i = these.deleteThesection(in);
        return i;
    }

    /**
     * 添加数据到数据库
     *
     * @param params
     */
    @Override
    public void addThesection(Map<String, String[]> params) {
        //1.添加数据
        these.addThesection(params);
    }

    /**
     * 更新数据
     *
     * @param parameterMap
     */
    @Override
    public void updateThesection(Map<String, String[]> parameterMap) {
        //1.更新数据
        these.updateThesection(parameterMap);
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public thesectiontable selectThesectionId(String id) {
        thesectiontable nurse = these.selectThesectionId(id);
        if (nurse!=null) {
            return nurse;
        }
        return null;
    }
}
