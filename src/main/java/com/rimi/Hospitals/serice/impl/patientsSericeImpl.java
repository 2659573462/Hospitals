package com.rimi.Hospitals.serice.impl;

import com.rimi.Hospitals.common.Page;
import com.rimi.Hospitals.dao.impl.nurseDaoImpl;
import com.rimi.Hospitals.dao.impl.patientsDaoImpl;
import com.rimi.Hospitals.dao.nurseDao;
import com.rimi.Hospitals.dao.patientsDao;
import com.rimi.Hospitals.entity.Patients;
import com.rimi.Hospitals.entity.nurse;
import com.rimi.Hospitals.serice.patientsSerice;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/27 20:41
 */
public class patientsSericeImpl implements patientsSerice {
    private patientsDao nurseD = new patientsDaoImpl();
    /**
     * 查询所有的患者信息
     *
     * @return
     */
    @Override
    public List<Patients> selectPatients() {
        List<Patients> doctors=nurseD.selectNurseTable();
        if (doctors!=null && doctors.size() >0) {
            return doctors;
        }
        return null;
    }

    /**
     * 查询患者信息哪一条到哪里
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public List<Patients> selectListServlce(Integer currentPage, Integer pageSize) {
        //1.直接执行dao层方法获取到数据
        List<Patients> doctors=nurseD.selectLin(currentPage,pageSize);
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
    public Page<Patients> findPagedBooks(Page page) {
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
        List<Patients> booksList = nurseD.selectLin(currentSize,pageSize);
        //6.把结果存放到page对象中
        page.setPageData(booksList);
        return page;
    }

    /**
     * 传入患者的唯一遍历号
     * 删除这条数据
     *
     * @param in
     * @return
     */
    @Override
    public int deletePatients(String in) {
        int i = nurseD.deleteNurse(in);
        return i;
    }

    /**
     * 添加数据到患者数据库
     *
     * @param params
     */
    @Override
    public void addPatients(Map<String, String[]> params) {
        //1.添加数据
        nurseD.addNurse(params);
    }

    /**
     * 更新患者数据
     *
     * @param parameterMap
     */
    @Override
    public void updatePatients(Map<String, String[]> parameterMap) {
        //1.更新数据
        nurseD.updateNurse(parameterMap);
    }

    /**
     * 根据id查询患者信息
     *
     * @param id
     * @return
     */
    @Override
    public Patients selectId(String id) {
        Patients nurse = nurseD.selectId(id);
        if (nurse!=null) {
            return nurse;
        }
        return null;
    }
}
