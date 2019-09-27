package com.rimi.Hospitals.servlet;

import com.alibaba.fastjson.JSONObject;
import com.rimi.Hospitals.common.BaseServlet;
import com.rimi.Hospitals.common.LoginConstant;
import com.rimi.Hospitals.common.Page;
import com.rimi.Hospitals.entity.Doctortable;
import com.rimi.Hospitals.entity.Patients;
import com.rimi.Hospitals.entity.nurse;
import com.rimi.Hospitals.serice.ILoginService;
import com.rimi.Hospitals.serice.IndexService;
import com.rimi.Hospitals.serice.impl.ILoginServiceImpl;
import com.rimi.Hospitals.serice.impl.IndexServiceImpl;
import com.rimi.Hospitals.serice.impl.nurseSericeImpl;
import com.rimi.Hospitals.serice.impl.patientsSericeImpl;
import com.rimi.Hospitals.serice.nurseSerice;
import com.rimi.Hospitals.serice.patientsSerice;
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
    private nurseSerice nurseSerices=new nurseSericeImpl();
    private patientsSerice pati = new patientsSericeImpl();

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
     * 查询遍历出所有的医生数据医生信息
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
        //1.删除医生数据
        int i = deletehop.deleteHosp(id);
        //2.响应出数据
        response.getWriter().print(i>0);
    }

    /**
     * 添加医生数据
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    public String addHospitals(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //1.设置请求的数据编码
        request.setCharacterEncoding("UTF-8");
        //2. 获取参数
        Map<String, String[]> params = request.getParameterMap();
        //3..保存数据
        deletehop.addHospitals(params);
        return "/HospitalsServlet?transmits=indexHospitaltaffS";
    }

    /**
     * 修改医数据
     * @param request
     * @param response
     */
    public  String updateHospitals(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //1.设置请求编码
        request.setCharacterEncoding("UTF-8");
        //2.获取请求的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //3.去serice更新数据
        deletehop.updateHospitals(parameterMap);
        //4.返回页面
        return "/HospitalsServlet?transmits=indexHospitaltaffS";
    }

    /**
     * 异步加载根据id查询医生的数据数据
     * @param request
     * @param response
     * @throws IOException
     */
    public void selectId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.设置请求的编码
        response.setContentType("text/html;charset=utf-8");
        //2.获取请求参数
        String id = request.getParameter("id");
        //3.serice查询数据
        Doctortable hospital=deletehop.selectId(id);
        //获取json核心对象
        JSONObject jsonObject = new JSONObject();
        //将要传出的值加入
        jsonObject.put("hosp", hospital);

        response.getWriter().print(JSONObject.toJSONString(hospital));

    }




    /*----------------------------------------查询护士的servlet------------------------------------------------查询护士的servlet--------------------------------------------------------------------------------------------------------------------------------**/



    /**
     * 查询遍历出所有的护士数据
     * @param request
     * @param response
     * @return
     */
    public String selectNurse(HttpServletRequest request, HttpServletResponse response){
        //1.获取请求的参数
        String currentPage = request.getParameter("p");
        if (StringUtils.isEmpty(currentPage)){
            currentPage = "1";
        }
        Page page = Page.of(Integer.valueOf(currentPage));
        nurseSericeImpl nurseSerice = new nurseSericeImpl();
        Page<nurse> pagedBooks = nurseSerice.findPagedBooks(page);
        request.setAttribute("cards",pagedBooks);
        return "/WEB-INF/Logins/nurse.jsp";
    }

    /**
     * 添加护士对象
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    public String addNurse(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //1.设置请求的数据编码
        request.setCharacterEncoding("UTF-8");
        //2. 获取参数
        Map<String, String[]> params = request.getParameterMap();
        //3..保存数据
        nurseSerices.addHospitals(params);
        System.out.println("进来就没");
        return "/HospitalsServlet?transmits=selectNurse";
    }

    /**
     * ajax加载查询的护士数据
     * @param request
     * @param response
     * @throws IOException
     */
    public void selectNurseId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.设置请求的编码
        response.setContentType("text/html;charset=utf-8");
        //2.获取请求参数
        String id = request.getParameter("id");
        //3.serice查询数据
        nurse nurse = nurseSerices.selectId(id);
        //获取json核心对象
        JSONObject jsonObject = new JSONObject();
        //将要传出的值加入
        jsonObject.put("nurses", nurse);

        response.getWriter().print(JSONObject.toJSONString(nurse));
    }

    /**
     * 更新数据
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    public  String updateNurse(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //1.设置请求编码
        request.setCharacterEncoding("UTF-8");
        //2.获取请求的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //3.去serice更新数据
        nurseSerices.updateHospitals(parameterMap);
        //4.返回页面
       return "/HospitalsServlet?transmits=selectNurse";
    }

    /**
     * 删除医生信息
     * @param request
     * @param response
     * @throws IOException
     */
    public  void deleteNurse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        //1.删除医生数据
        int i = nurseSerices.deleteHosp(id);
        //2.响应出数据
        response.getWriter().print(i>0);
    }


    /*----------------------------------------查询病人数据的的servlet------------------------------------------------查询护士的servlet--------------------------------------------------------------------------------------------------------------------------------**/


    /**
     * 查询遍历出所有的医生数据医生信息
     * @param request
     * @param response
     * @return
     */
    public  String indexPatients(HttpServletRequest request, HttpServletResponse response){
        String currentPage = request.getParameter("p");
        if (StringUtils.isEmpty(currentPage)){
            currentPage = "1";
        }
        Page page = Page.of(Integer.valueOf(currentPage));
        Page<Patients> booksPage = pati.findPagedBooks(page);
        request.setAttribute("cards",booksPage);
        return "/WEB-INF/Logins/Patients.jsp";
    }


    /**
     * 删除医生信息
     * @param request
     * @param response
     * @throws IOException
     */
    public  void deletePatients(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        //1.删除医生数据
        int i = pati.deletePatients(id);
        //2.响应出数据
        response.getWriter().print(i>0);
    }

    /**
     * 添加医生数据
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    public String addPatients(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //1.设置请求的数据编码
        request.setCharacterEncoding("UTF-8");
        //2. 获取参数
        Map<String, String[]> params = request.getParameterMap();
        //3..保存数据
        pati.addPatients(params);
        return "/HospitalsServlet?transmits=indexPatients";
    }

    /**
     * 修改医数据
     * @param request
     * @param response
     */
    public  String updatePatients(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //1.设置请求编码
        request.setCharacterEncoding("UTF-8");
        //2.获取请求的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //3.去serice更新数据
        pati.updatePatients(parameterMap);
        //4.返回页面
        return "/HospitalsServlet?transmits=indexPatients";
    }

    /**
     * 异步加载根据id查询医生的数据数据
     * @param request
     * @param response
     * @throws IOException
     */
    public void selectPatientsId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.设置请求的编码
        response.setContentType("text/html;charset=utf-8");
        //2.获取请求参数
        String id = request.getParameter("id");
        //3.serice查询数据
        Patients patients = pati.selectId(id);
        //获取json核心对象
        JSONObject jsonObject = new JSONObject();
        //将要传出的值加入
        jsonObject.put("hosp", patients);
        response.getWriter().print(JSONObject.toJSONString(patients));

    }




}
