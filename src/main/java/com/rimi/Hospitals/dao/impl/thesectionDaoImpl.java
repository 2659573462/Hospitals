package com.rimi.Hospitals.dao.impl;

import com.rimi.Hospitals.dao.thesectionDao;
import com.rimi.Hospitals.entity.nurse;
import com.rimi.Hospitals.entity.thesectiontable;
import com.rimi.Hospitals.util.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/28 13:45
 */
public class thesectionDaoImpl implements thesectionDao {
    /**
     * 查询所有的数据
     *
     * @return
     */
    @Override
    public List<thesectiontable> selectThesectionTable() {
        String sql = "select * from _thesectiontable ";
        List<thesectiontable> nurseTable = JDBCUtils.executeQuery(thesectiontable.class, sql);
        //判断对象是否是空的
        if (nurseTable!=null && nurseTable.size() >0) {
            return nurseTable;
        }
        return null;
    }

    /**
     * 查询数据多少到多少
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public List<thesectiontable> selectLin(Integer currentPage, Integer pageSize) {
        String sql = "select * from _thesectiontable  limit ?,?";
        List<thesectiontable> doctortables = JDBCUtils.executeQuery(thesectiontable.class, sql,currentPage,pageSize);
        //判断对象是否是空的
        if (doctortables!=null && doctortables.size() >0) {
            return doctortables;
        }
        return null;
    }

    /**
     * 查询数据的总数
     *
     * @return
     */
    @Override
    public Integer count() {
        // 定义sql
        String sql = "select count(1) from _thesectiontable";
        // 执行
        return JDBCUtils.executeQueryForCount(sql);
    }

    /**
     * 删除科室数据更具科室名
     *
     * @param in
     * @return
     */
    @Override
    public int deleteThesection(String in) {
        //定义sql
        String sql = "delete  from  _thesectiontable where departmentOf=?";
        int i = JDBCUtils.executeUpdate(sql,in);
        return i;
    }

    /**
     * 添加科室数据
     *
     * @param params
     */
    @Override
    public void addThesection(Map<String, String[]> params) {
        String sql = "insert into  _thesectiontable  values(?,?,?,?)";
        int i = JDBCUtils.executeUpdate(sql,
                params.get("departmentOf")[0],
                params.get("phone")[0],
                params.get("sectionOfficeAddress")[0],
                params.get("officesDirector")[0]);

    }

    /**
     * 更新科室数据
     *
     * @param parameterMap
     */
    @Override
    public void updateThesection(Map<String, String[]> parameterMap) {
        String sql = "update _thesectiontable set  departmentOf =? , phone=?, sectionOfficeAddress=?, officesDirector=? where departmentOf=?";
        int i = JDBCUtils.executeUpdate(sql,
                parameterMap.get("departmentOf")[0],
                parameterMap.get("phone")[0],
                parameterMap.get("sectionOfficeAddress")[0],
                parameterMap.get("officesDirector")[0],
                parameterMap.get("departmentOf")[0]);

    }

    /**
     * 根据id获取数据
     *
     * @param id
     * @return
     */
    @Override
    public thesectiontable selectThesectionId(String id) {
        String sql = "select * from _thesectiontable where departmentOf=?";
        List<thesectiontable> doctortables = JDBCUtils.executeQuery(thesectiontable.class, sql, id);
        if (doctortables!=null) {
            return doctortables.get(0);
        }
        return null;
    }
}
