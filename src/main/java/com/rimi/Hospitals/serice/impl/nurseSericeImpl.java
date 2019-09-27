package com.rimi.Hospitals.serice.impl;

import com.rimi.Hospitals.common.Page;
import com.rimi.Hospitals.dao.impl.DoctortableDaoImpl;
import com.rimi.Hospitals.dao.impl.nurseDaoImpl;
import com.rimi.Hospitals.dao.nurseDao;
import com.rimi.Hospitals.entity.Doctortable;
import com.rimi.Hospitals.entity.nurse;
import com.rimi.Hospitals.serice.nurseSerice;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/27 14:22
 */
public class nurseSericeImpl implements nurseSerice {
    private nurseDao nurseD = new nurseDaoImpl();
    /**
     * 查询所有的护士信息
     *
     * @return
     */
    @Override
    public List<nurse> selectNurse() {
        List<nurse> doctors=nurseD.selectNurseTable();
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
    public List<nurse> selectListServlce(Integer currentPage, Integer pageSize) {
        //1.直接执行dao层方法获取到数据
        List<nurse> doctors=nurseD.selectLin(currentPage,pageSize);
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
    public Page<nurse> findPagedBooks(Page page) {
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
        Integer count = nurseD.count();
        page.setTotalCount(count);
        //4.判断分页开始的位置是否大于总条数
        int currentSize = currentPage * pageSize;
        if (currentSize > count){
            currentSize = (page.getPageCount() - 1) * pageSize;
        }
        //5.通过分页条件查询,并获取结果列表
        List<nurse> booksList = nurseD.selectLin(currentSize,pageSize);
        //6.把结果存放到page对象中
        page.setPageData(booksList);
        return page;
    }

    /**
     * 传入护士的唯一工作号
     *
     * @param in
     * @return
     */
    @Override
    public int deleteHosp(String in) {
        int i = nurseD.deleteNurse(in);
        return i;
    }

    /**
     * 添加数据到数据库
     *
     * @param params
     */
    @Override
    public void addHospitals(Map<String, String[]> params) {
        //1.添加数据
        nurseD.addNurse(params);
    }

    /**
     * 更新数据
     *
     * @param parameterMap
     */
    @Override
    public void updateHospitals(Map<String, String[]> parameterMap) {
        //1.更新数据
        nurseD.updateNurse(parameterMap);
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public nurse selectId(String id) {
        nurse nurse = nurseD.selectId(id);
        if (nurse!=null) {
            return nurse;
        }
        return null;
    }
}
