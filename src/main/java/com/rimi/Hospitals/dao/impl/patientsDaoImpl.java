package com.rimi.Hospitals.dao.impl;

import com.rimi.Hospitals.dao.patientsDao;
import com.rimi.Hospitals.entity.Patients;
import com.rimi.Hospitals.entity.nurse;
import com.rimi.Hospitals.util.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/27 20:47
 */
public class patientsDaoImpl implements patientsDao {
    /**
     * 查询所有的数据
     *
     * @return
     */
    @Override
    public List<Patients> selectNurseTable() {
        String sql = "select * from _patientstable ";
        List<Patients> nurseTable = JDBCUtils.executeQuery(Patients.class, sql);
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
    public List<Patients> selectLin(Integer currentPage, Integer pageSize) {
        String sql = "select * from _patientstable  limit ?,?";
        List<Patients> doctortables = JDBCUtils.executeQuery(Patients.class, sql,currentPage,pageSize);
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
        String sql = "select count(1) from _patientstable";
        // 执行
        return JDBCUtils.executeQueryForCount(sql);
    }

    /**
     * 删除患者数据更具医生的工号
     *
     * @param in
     * @return
     */
    @Override
    public int deleteNurse(String in) {
        //定义sql
        String sql = "delete  from  _patientstable where medicalRecord=?";
        int i = JDBCUtils.executeUpdate(sql,in);
        return i;
    }

    /**
     * 添加患者数据
     *
     * @param params
     */
    @Override
    public void addNurse(Map<String, String[]> params) {
        //1.定义sql
        String sql = "insert into _patientstable values(?,?,?,?,?,?,?,?,?)";
        int i = JDBCUtils.executeUpdate(sql,
                params.get("medicalRecord")[0],
                params.get("patientsName")[0],
                params.get("gender")[0],
                params.get("age")[0],
                params.get("bloodType")[0],
                params.get("diagnose")[0],
                params.get("doctorName")[0],
                params.get("room")[0],
                params.get("subordinateDepartments")[0]);


    }

    /**
     * 更新患者数据
     *
     * @param parameterMap
     */
    @Override
    public void updateNurse(Map<String, String[]> parameterMap) {
    //1.定义sql
        String sql = "update _patientstable set medicalRecord=?, patientsName=?, gender=?, age=?, " +
                "bloodType=?, diagnose=?, doctorName=?, room=?, subordinateDepartments=?  where medicalRecord=?";
    //2.执行sql语句
    JDBCUtils.executeUpdate(sql,
            parameterMap.get("medicalRecord")[0],
            parameterMap.get("patientsName")[0],
            parameterMap.get("gender")[0],
            parameterMap.get("age")[0],
            parameterMap.get("bloodType")[0],
            parameterMap.get("diagnose")[0],
            parameterMap.get("doctorName")[0],
            parameterMap.get("room")[0],
            parameterMap.get("subordinateDepartments")[0],
            parameterMap.get("medicalRecord")[0]);
    }

    /**
     * 根据id获取数据
     *
     * @param id
     * @return
     */
    @Override
    public Patients selectId(String id) {
        String sql = "select * from _patientstable where medicalRecord=?";
        List<Patients> doctortables = JDBCUtils.executeQuery(Patients.class, sql, id);
        if (doctortables!=null) {
            return doctortables.get(0);
        }
        return null;
    }
}
