package com.rimi.Hospitals.common;

import com.rimi.Hospitals.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 用于servlet继承的
 *
 * @author chenjin
 * @date 2019/9/22 19:29
 */
public class BaseServlet extends HttpServlet {
    private static final String NUMBER_L="transmits";
    private static final String NUMBER_M="redirect";
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //设置编码
     req.setCharacterEncoding("utf-8");
     //获取
        String parameter = req.getParameter(NUMBER_L);
     //判断这个数据是否为空
        if (StringUtils.isNotEmpty(parameter)) {
            //获取类型
            Class<? extends BaseServlet> aClass = this.getClass();
            //调用方法
            try {
                Method method = aClass.getMethod(parameter, HttpServletRequest.class, HttpServletResponse.class);
                //执行方法
                Object invoke = method.invoke(this, req, resp);
                //判断返回的结果
                if (invoke instanceof String) {
                    //转型
                    String s= (String)invoke;
                    //判断是否包含
                    if (s.startsWith(NUMBER_M)) {
                        //截取字符串
                        String substring = s.substring(NUMBER_M.length()+1);
                        //重定向
                        resp.sendRedirect(substring);
                    }else{
                        //请求转发
                        req.getRequestDispatcher(s).forward(req,resp);;
                    }
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }

    }
}
