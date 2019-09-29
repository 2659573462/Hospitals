package com.rimi.Hospitals.dao;

import com.rimi.Hospitals.entity.User;

/**
 * @author chenjin
 * @date 2019/9/23 12:59
 */
public interface IUserDao {
    User selectByUsernameAndPassword(String username, String password);

    int updatePaw(String password,String username);
}
