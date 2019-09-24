package com.rimi.Hospitals.common;

/**
 * 登陆的常量类
 * 1.使用 final 修饰类,表明该类不能被继承
 * 2.构造方法(构造器) 进行私有化操作,表明该类不能够创建该类型的实例对象
 * 好处: 避免了其他人对该类进行扩展以及错误的使用方式
 *
 * @author shangzf
 * @date 2019/9/9 10:21
 */
public final class LoginConstant {
    // 私有化
    private LoginConstant() {
    }

    /**
     * 登陆的用户名字段
     */
    public static final String LOGIN_USERNAME = "username";

    /**
     * 登陆的密码字段
     */
    public static final String LOGIN_PASSWORD = "password";

    /**
     * 登陆的记住我字段
     */
    public static final String LOGIN_REMEMBER = "remember";

    /**
     * 登陆的错误信息字段
     */
    public static final String LOGIN_ERROR = "error";

}
