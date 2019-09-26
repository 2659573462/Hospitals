package com.rimi.Hospitals.serice.impl;

import com.rimi.Hospitals.common.Page;
import com.rimi.Hospitals.dao.DoctortableDao;
import com.rimi.Hospitals.dao.IUserDao;
import com.rimi.Hospitals.dao.impl.DoctortableDaoImpl;
import com.rimi.Hospitals.dao.impl.IUserDaoImpl;
import com.rimi.Hospitals.entity.Doctortable;
import com.rimi.Hospitals.serice.IndexService;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/25 17:19
 */
public class IndexServiceImpl implements IndexService {
    private DoctortableDao userDao = new DoctortableDaoImpl();


    /**
     * 查询所有的医生信息
     *
     * @return
     */
    @Override
    public List<Doctortable> selectDoctortable() {
        List<Doctortable> doctors=userDao.selectDoctortables();
        if (doctors!=null && doctors.size() >0) {
            return doctors;
        }
        return null;
    }

    /**
     * 查询数据从好多到好多
     * @param currentPage 开始位置
     * @param pageSize 结束位置
     * @return 返回数据集合
     */
    @Override
    public List<Doctortable> selectListServlce(Integer currentPage, Integer pageSize) {
        List<Doctortable> doctors=userDao.selectLin(currentPage,pageSize);
        if (doctors!=null && doctors.size() >0) {
            return doctors;
        }
        return null;
    }

    @Override
    public Page<Doctortable> findPagedBooks(Page page) {
        // 分页查询
        // 0. 获取分页的条件
        Integer currentPage = page.getCurrentPage();
        Integer pageSize = page.getPageSize();
        if (currentPage > 0) {
            currentPage -= 1;
        } else {
            currentPage = 0;
        }
        // 1. 通过查询获取总条数
        Integer count = userDao.count();
        page.setTotalCount(count);
        // 判断分页开始的位置是否大于总条数
        int currentSize = currentPage * pageSize;
        if (currentSize > count){
            // (5-1)*10   38
            // 获取总分页数
            currentSize = (page.getPageCount() - 1) * pageSize;
        }
        // 2. 通过分页条件查询,并获取结果列表
        List<Doctortable> booksList = userDao.selectLin(currentSize,pageSize);
        // 把结果存放到page对象中
        page.setPageData(booksList);
        return page;
    }

    @Override
    public int deleteHosp(String in) {
        DoctortableDaoImpl doctortableDao = new DoctortableDaoImpl();
        int i = doctortableDao.deleteHosp(in);
        return i;
    }

    @Override
    public void addHospitals(Map<String, String[]> params) {
        //构建实例对象
        DoctortableDaoImpl doctortableDao = new DoctortableDaoImpl();
        //调用添加数据
        doctortableDao.addHospitals(params);
    }


}
