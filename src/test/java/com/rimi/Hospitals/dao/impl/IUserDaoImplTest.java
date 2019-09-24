package com.rimi.Hospitals.dao.impl;

import com.rimi.Hospitals.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @author chenjin
 * @date 2019/9/23 14:21
 */
public class IUserDaoImplTest {
    @Test
    public void selectByUsernameAndPassword() {
        IUserDaoImpl iUserDao = new IUserDaoImpl();
        //原始两个账号和密码abc 和123
        User abc = iUserDao.selectByUsernameAndPassword("abc", "123");
        System.out.println(abc);
    }
}
