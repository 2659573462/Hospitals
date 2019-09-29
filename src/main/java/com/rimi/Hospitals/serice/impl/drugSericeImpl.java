package com.rimi.Hospitals.serice.impl;

import com.rimi.Hospitals.common.Page;
import com.rimi.Hospitals.dao.grupDao;
import com.rimi.Hospitals.dao.impl.grupDaoImpl;
import com.rimi.Hospitals.entity.drug;
import com.rimi.Hospitals.serice.drugSerice;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/28 1:28
 */
public class drugSericeImpl implements drugSerice {
    private grupDao grupdao=new grupDaoImpl();
    /**
     * 查询所有的药品信息
     *
     * @return
     */
    @Override
    public List<drug> selectGrup() {
        List<drug> drugs = grupdao.selectGrupTable();
        if (drugs!=null && drugs.size() >0) {
            return drugs;
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
    public List<drug> selectListServlce(Integer currentPage, Integer pageSize) {
        //1.直接执行dao层方法获取到数据
        List<drug> doctors=grupdao.selectLin(currentPage,pageSize);
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
    public Page<drug> findPagedBooks(Page page) {
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
        Integer count = grupdao.count();
        page.setTotalCount(count);
        //4.判断分页开始的位置是否大于总条数
        int currentSize = currentPage * pageSize;
        if (currentSize > count){
            currentSize = (page.getPageCount() - 1) * pageSize;
        }
        //5.通过分页条件查询,并获取结果列表
        List<drug> booksList = grupdao.selectLin(currentSize,pageSize);
        //6.把结果存放到page对象中
        page.setPageData(booksList);
        return page;
    }

    /**
     * 传入药品的唯一国字号
     * 删除这条数据
     *
     * @param in
     * @return
     */
    @Override
    public int deleteGrup(String in) {
        int i = grupdao.deleteGrup(in);
        return i;
    }

    /**
     * 添加数据到数据库
     *
     * @param params
     */
    @Override
    public void addGrup(Map<String, String[]> params) {
        //1.添加数据
        grupdao.addGrup(params);
    }

    /**
     * 更新数据
     *
     * @param parameterMap
     */
    @Override
    public void updateGrup(Map<String, String[]> parameterMap) {
        //1.更新数据
        grupdao.updateGrup(parameterMap);
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public drug selectGrupId(String id) {
        drug nurse = grupdao.selectGrupId(id);
        if (nurse!=null) {
            return nurse;
        }
        return null;
    }
}
