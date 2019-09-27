package com.rimi.Hospitals.dao.impl;

import com.rimi.Hospitals.dao.nurseDao;
import com.rimi.Hospitals.entity.Doctortable;
import com.rimi.Hospitals.entity.nurse;
import com.rimi.Hospitals.util.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @author chenjin
 * @date 2019/9/27 14:26
 */
public class nurseDaoImpl implements nurseDao {
    /**
     * 查询所有护士的数据
     *
     * @return
     */
    @Override
    public List<nurse> selectNurseTable() {
        String sql = "select * from _nursetable ";
        List<nurse> nurseTable = JDBCUtils.executeQuery(nurse.class, sql);
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
    public List<nurse> selectLin(Integer currentPage, Integer pageSize) {
        String sql = "select * from _nursetable  limit ?,?";
        List<nurse> doctortables = JDBCUtils.executeQuery(nurse.class, sql,currentPage,pageSize);
        //判断对象是否是空的
        if (doctortables!=null && doctortables.size() >0) {
            return doctortables;
        }
        return null;
    }

    /**
     * 查询护士总共的人数
     *
     * @return
     */
    @Override
    public Integer count() {
        // 定义sql
        String sql = "select count(1) from _nursetable";
        // 执行
        return JDBCUtils.executeQueryForCount(sql);
    }

    /**
     * 删除护士
     * 根据护士的唯一编号
     *
     * @param in
     * @return
     */
    @Override
    public int deleteNurse(String in) {
        //定义sql
        String sql = "delete  from  _nursetable where nurseNumber="+in;
        int i = JDBCUtils.executeUpdate(sql);
        return i;
    }

    /**
     * 添加护士数据
     *
     * @param params
     */
    @Override
    public void addNurse(Map<String, String[]> params) {
        String sql = "insert into _nursetable  values(?,?,?,?)";
        int i = JDBCUtils.executeUpdate(sql,
                params.get("nurseNumber")[0],
                params.get("patientsName")[0],
                params.get("gender")[0],
                params.get("age")[0]);
    }

    /**
     * 更新护士数据
     *
     * @param parameterMap
     */
    @Override
    public void updateNurse(Map<String, String[]> parameterMap) {
        //1.定义sql
        String sql ="update _nursetable set nurseNumber=?,  patientsName=? , gender=?, age=?  where nurseNumber =?";
        //2.执行sql语句
        int i = JDBCUtils.executeUpdate(sql,
                parameterMap.get("nurseNumber")[0],
                parameterMap.get("patientsName")[0],
                parameterMap.get("gender")[0],
                parameterMap.get("age")[0],
                parameterMap.get("nurseNumber")[0]);
    }

    /**
     * 根据id获取数据
     *
     * @param id
     * @return
     */
    @Override
    public nurse selectId(String id) {
        String sql = "select * from _nursetable where nurseNumber=?";
        List<nurse> doctortables = JDBCUtils.executeQuery(nurse.class, sql, id);
        if (doctortables!=null) {
            return doctortables.get(0);
        }
        return null;
    }
}
