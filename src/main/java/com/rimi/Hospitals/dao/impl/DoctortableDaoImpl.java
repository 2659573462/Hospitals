package com.rimi.Hospitals.dao.impl;

import com.rimi.Hospitals.common.DefaultNameHandle;
import com.rimi.Hospitals.common.SQLContext;
import com.rimi.Hospitals.dao.DoctortableDao;
import com.rimi.Hospitals.entity.Doctortable;
import com.rimi.Hospitals.util.JDBCUtils;
import com.rimi.Hospitals.util.SQLUtils;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/25 17:24
 */
public class DoctortableDaoImpl implements DoctortableDao {
    private static Doctortable doctortable = new Doctortable();
    /**
     * 查询所有的医生数据
     * @return
     */
    @Override
    public List<Doctortable> selectDoctortables() {
        String sql = "select * from _doctortable ";
        List<Doctortable> doctortables = JDBCUtils.executeQuery(Doctortable.class, sql);
        //判断对象是否是空的
        if (doctortables!=null && doctortables.size() >0) {
            return doctortables;
        }
        return null;
    }

    @Override
    public List<Doctortable> selectLin(Integer currentPage, Integer pageSize) {
        String sql = "select * from _doctortable  limit ?,?";
        List<Doctortable> doctortables = JDBCUtils.executeQuery(Doctortable.class, sql,currentPage,pageSize);
        //判断对象是否是空的
        if (doctortables!=null && doctortables.size() >0) {
            return doctortables;
        }
        return null;
    }

    @Override
    public Integer count() {
        // 定义sql
        String sql = "select count(1) from _doctortable";
        // 执行
        return JDBCUtils.executeQueryForCount(sql);
    }

    /**
     * 删除对应工号的医生
     * @param in
     * @return
     */
    @Override
    public int deleteHosp(String in) {
        //定义sql
        String sql = "delete  from  _doctortable where employeescard="+in;
        int i = JDBCUtils.executeUpdate(sql);
        return i;
    }

    /**
     * 添加医生数据
     * @param params
     */
    @Override
    public void addHospitals(Map<String, String[]> params) {
        String sql = "insert into _doctortable  values(?,?,?,?,?,?)";
        int i = JDBCUtils.executeUpdate(sql,
                params.get("employeescard")[0],
                params.get("doctorname")[0],
                params.get("gender")[0],
                params.get("age")[0],
                params.get("subordinatedepartments")[0],
                params.get("educationbackground")[0]);
    }

    /**
     * 更细数据
     * @param parameterMap
     */
    @Override
    public void updateHospitals(Map<String, String[]> parameterMap) {
        //1.定义sql
        String sql ="update _doctortable set employeescard=?,  doctorname=? , gender=?, age=?, subordinatedepartments=? , educationbackground= ?  where employeescard =?";
        //2.执行sql语句
        int i = JDBCUtils.executeUpdate(sql,
                parameterMap.get("employeescard")[0],
                parameterMap.get("doctorname")[0],
                parameterMap.get("gender")[0],
                parameterMap.get("age")[0],
                parameterMap.get("subordinatedepartments")[0],
                parameterMap.get("educationbackground")[0],
                parameterMap.get("employeescard")[0]);
    }

    @Override
    public Doctortable selectId(String id) {
       String sql = "select * from _doctortable where employeescard=?";
        List<Doctortable> doctortables = JDBCUtils.executeQuery(Doctortable.class, sql, id);
        if (doctortables!=null) {
            return doctortables.get(0);
        }
        return null;
    }

}
