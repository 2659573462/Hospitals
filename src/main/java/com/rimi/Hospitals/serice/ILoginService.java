package com.rimi.Hospitals.serice;

/**
 * @author chenjin
 * @date 2019/9/23 12:53
 */
public interface ILoginService {

    boolean login(String username, String password, String remember);
}
