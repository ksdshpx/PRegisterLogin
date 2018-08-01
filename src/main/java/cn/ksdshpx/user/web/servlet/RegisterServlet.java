package cn.ksdshpx.user.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.ksdshpx.user.domain.User;
import cn.ksdshpx.user.exception.UserException;
import cn.ksdshpx.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/31
 * Time: 10:33
 * Description:处理注册业务的RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=\"UTF-8\"");
        UserService userService = new UserService();
        //1.封装表单数据到User对象
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        //2.调用service#register()
        try {
            userService.register(form);
            response.getWriter().print("注册成功！");
        } catch (UserException e) {
            //获取异常信息，保存到request域中，转发到register.jsp
            request.setAttribute("msg",e.getMessage());
            request.setAttribute("user",form);//用于表单回显
            request.getRequestDispatcher("/user/register.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
