package com.rimi.Hospitals.servlet;

import com.rimi.Hospitals.common.BaseServlet;
import com.rimi.Hospitals.common.LoginConstant;
import com.rimi.Hospitals.serice.ILoginService;
import com.rimi.Hospitals.serice.impl.ILoginServiceImpl;
import com.rimi.Hospitals.util.CookieUtils;
import com.rimi.Hospitals.util.PwdUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet
 *
 * @author chenjin
 * @date 2019/9/22 19:55
 */
@WebServlet("/HospitalsServlet")
public class HospitalsServlet  extends BaseServlet {
    private ILoginService loginService = new ILoginServiceImpl();


    public String LoginRequest(HttpServletRequest request, HttpServletResponse response) {
        // 1.获取form表单提交的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        System.out.println("账号"+username);
        System.out.println("密码"+password);
        System.out.println("记住"+remember);
        boolean login=loginService.login(username,password,remember);
        if(login){
            //密码正确以后创建session对象
            request.getSession().setAttribute("username", username);
            //判断是否设置免密功能
            if(request.getParameter("remember")!=null){
                System.out.println("以设置cookie");
                CookieUtils.setCookie(LoginConstant.LOGIN_USERNAME, username, 7 * 24 * 60 * 60, response);
                CookieUtils.setCookie(LoginConstant.LOGIN_PASSWORD, password, 7 * 24 * 60 * 60, response);
            }
            //进去首页页面
            return "/web/WEB-INF/Logins/logins.jsp";
        }
        //返回登陆界面错误页面
        request.setAttribute("error","账号或者密码错误");
        return "/error/404.jsp";
    }

    public  String indexHospitaltaffS(HttpServletRequest request, HttpServletResponse response){


        return null;
    }


}
