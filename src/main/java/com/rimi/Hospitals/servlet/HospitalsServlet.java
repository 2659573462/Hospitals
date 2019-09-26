package com.rimi.Hospitals.servlet;

import com.alibaba.fastjson.JSONObject;
import com.rimi.Hospitals.common.BaseServlet;
import com.rimi.Hospitals.common.LoginConstant;
import com.rimi.Hospitals.common.Page;
import com.rimi.Hospitals.entity.Doctortable;
import com.rimi.Hospitals.serice.ILoginService;
import com.rimi.Hospitals.serice.IndexService;
import com.rimi.Hospitals.serice.impl.ILoginServiceImpl;
import com.rimi.Hospitals.serice.impl.IndexServiceImpl;
import com.rimi.Hospitals.util.CookieUtils;
import com.rimi.Hospitals.util.PwdUtils;
import com.rimi.Hospitals.util.StringUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Servlet
 *
 * @author chenjin
 * @date 2019/9/22 19:55
 */
@WebServlet("/HospitalsServlet")
public class HospitalsServlet  extends BaseServlet {
    private ILoginService loginService = new ILoginServiceImpl();
    private IndexService deletehop=new IndexServiceImpl();

    /**
     * 判断登陆
     * @param request
     * @param response
     * @return
     */
    public String LoginRequest(HttpServletRequest request, HttpServletResponse response) {
        // 1.获取form表单提交的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        boolean login=loginService.login(username,password,remember);
        if(login){
            //密码正确以后创建session对象
            request.getSession().setAttribute("username", username);
            //判断是否设置免密功能
            if(request.getParameter("remember")!=null){
                CookieUtils.setCookie(LoginConstant.LOGIN_USERNAME, username, 7 * 24 * 60 * 60, response);
                CookieUtils.setCookie(LoginConstant.LOGIN_PASSWORD, password, 7 * 24 * 60 * 60, response);
            }
            //进去首页页面
            return "/WEB-INF/Logins/logins.jsp";
        }else{
            //返回登陆界面错误页面
            request.setAttribute("error","账号或者密码错误");
            return "index.jsp";
        }
    }

    /**
     * 查询医生信息
     * @param request
     * @param response
     * @return
     */
    public  String indexHospitaltaffS(HttpServletRequest request, HttpServletResponse response){
        ////响应数据
        //response.setContentType("text/html;charset=utf-8");
        ////获取json核心对象
        //JSONObject jsonObject = new JSONObject();
        ////添加相应的数据
        //IndexServiceImpl indexService = new IndexServiceImpl();
        //List<Doctortable> doctortables = indexService.selectListServlce(1,13 );
        ////将数据搞出去
        //request.setAttribute("cards",doctortables);
        //System.out.println(doctortables);
        //获取当前请求的页数
        String currentPage = request.getParameter("p");
        if (StringUtils.isEmpty(currentPage)){
            currentPage = "1";
        }
        Page page = Page.of(Integer.valueOf(currentPage));
        IndexServiceImpl indexService = new IndexServiceImpl();
        Page<Doctortable> booksPage = indexService.findPagedBooks(page);
        request.setAttribute("cards",booksPage);
        return "/WEB-INF/Logins/type.jsp";
    }


    /**
     * 删除医生信息
     * @param request
     * @param response
     * @throws IOException
     */
    public  void deleteHospitals(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        //删除医生数据
        int i = deletehop.deleteHosp(id);
        JSONObject json = new JSONObject();

        if(i>0){
            json.put("i",true);
        }else{
            json.put("i",false);
        }
        response.getWriter().print(json.toString());
        //response.getWriter().print(JSONObject.toJSONString(i));
    }

    public String addHospitals(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        // 1. 获取参数
        Map<String, String[]> params = request.getParameterMap();
        deletehop.addHospitals(params);
        System.out.println("它拿着数据来了");

        return "/HospitalsServlet?transmits=indexHospitaltaffS";
    };
}
