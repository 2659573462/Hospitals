package com.rimi.Hospitals.serice.impl;

import com.rimi.Hospitals.dao.IUserDao;
import com.rimi.Hospitals.dao.impl.IUserDaoImpl;
import com.rimi.Hospitals.entity.User;
import com.rimi.Hospitals.serice.ILoginService;
import com.rimi.Hospitals.util.StringUtils;

/**
 * @author chenjin
 * @date 2019/9/23 12:54
 */
public class ILoginServiceImpl implements ILoginService {
    private IUserDao userDao = new IUserDaoImpl();
    @Override
    public boolean login(String username, String password, String remember) {
        if (StringUtils.isNotEmpty(username) &&  StringUtils.isNotEmpty(password)) {
            User user=userDao.selectByUsernameAndPassword(username,password);
            if (user!=null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int updatePaw(String password ,String username) {
        int i = userDao.updatePaw(password,username);
        return i;
    }
}
