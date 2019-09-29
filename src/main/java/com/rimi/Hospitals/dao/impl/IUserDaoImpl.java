package com.rimi.Hospitals.dao.impl;

import com.rimi.Hospitals.common.DefaultNameHandle;
import com.rimi.Hospitals.common.SQLContext;
import com.rimi.Hospitals.dao.IUserDao;
import com.rimi.Hospitals.entity.User;
import com.rimi.Hospitals.util.JDBCUtils;
import com.rimi.Hospitals.util.PwdUtils;
import com.rimi.Hospitals.util.SQLUtils;
import com.sun.deploy.util.StringUtils;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @author chenjin
 * @date 2019/9/23 13:04
 */
public class IUserDaoImpl implements IUserDao {
    @Override
    public User selectByUsernameAndPassword(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        DefaultNameHandle defaultNameHandle = new DefaultNameHandle();
        SQLContext sqlContext = SQLUtils.buildQuerySQL(user, defaultNameHandle);
        StringBuilder sql = sqlContext.getSql();
        String s = sql.toString();
        List<User> users = JDBCUtils.executeQuery(User.class, s, PwdUtils.getPwd(password),PwdUtils.getPwd(username));
        if (users!=null&&users.size()>0) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public int updatePaw(String password,String username) {
        String pwd = PwdUtils.getPwd(password);
        String use = PwdUtils.getPwd(username);
        String sql = "update _user set password = ? where username = ?";
        int i = JDBCUtils.executeUpdate(sql, pwd,use);
        return i;

    }
}
