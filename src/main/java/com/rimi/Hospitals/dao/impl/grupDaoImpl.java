package com.rimi.Hospitals.dao.impl;

import com.rimi.Hospitals.dao.grupDao;
import com.rimi.Hospitals.entity.drug;
import com.rimi.Hospitals.entity.nurse;
import com.rimi.Hospitals.util.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/28 1:35
 */
public class grupDaoImpl implements grupDao {
    /**
     * 查询所有的数据
     *
     * @return
     */
    @Override
    public List<drug> selectGrupTable() {
        String sql = "select * from _drug ";
        List<drug> nurseTable = JDBCUtils.executeQuery(drug.class, sql);
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
    public List<drug> selectLin(Integer currentPage, Integer pageSize) {
        String sql = "select * from _drug  limit ?,?";
        List<drug> doctortables = JDBCUtils.executeQuery(drug.class, sql,currentPage,pageSize);
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
        String sql = "select count(1) from _drug";
        // 执行
        return JDBCUtils.executeQueryForCount(sql);
    }

    /**
     * 删除药品根据国字号
     *
     * @param in
     * @return
     */
    @Override
    public int deleteGrup(String in) {
        System.out.println("阐述"+in);
        //定义sql
        String sql = "delete  from  _drug where approvalnumber=?";
        int i = JDBCUtils.executeUpdate(sql,in);
        return i;
    }

    /**
     * 添加药品数据
     *
     * @param params
     */
    @Override
    public void addGrup(Map<String, String[]> params) {
        String sql = "insert into _drug  values(?,?,?,?,?,?)";
        int i = JDBCUtils.executeUpdate(sql,
                params.get("approvalnumber")[0],
                params.get("drugname")[0],
                params.get("instruction")[0],
                params.get("directionsforuse")[0],
                params.get("manufacturingenterprise")[0],
                params.get("periodofvalidity")[0]);
    }

    /**
     * 更新药品数据
     *
     * @param parameterMap
     */
    @Override
    public void updateGrup(Map<String, String[]> parameterMap) {
        String sql = "update _drug set  approvalnumber=?, drugname=?, " +
                " instruction=?,  directionsforuse=?, manufacturingenterprise=?," +
                "periodofvalidity=?  where approvalnumber=?";
        int i = JDBCUtils.executeUpdate(sql,
                parameterMap.get("approvalnumber")[0],
                parameterMap.get("drugname")[0],
                parameterMap.get("instruction")[0],
                parameterMap.get("directionsforuse")[0],
                parameterMap.get("manufacturingenterprise")[0],
                parameterMap.get("periodofvalidity")[0],
                parameterMap.get("approvalnumber")[0]);
    }

    /**
     * 根据id获取数据
     *
     * @param id
     * @return
     */
    @Override
    public drug selectGrupId(String id) {
        String sql = "select * from _drug where approvalnumber=?";
        List<drug> doctortables = JDBCUtils.executeQuery(drug.class, sql, id);
        if (doctortables!=null) {
            return doctortables.get(0);
        }
        return null;
    }
}
