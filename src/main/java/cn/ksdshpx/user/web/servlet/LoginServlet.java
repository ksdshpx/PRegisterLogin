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
 * Time: 10:24
 * Description:处理登录请求的LoginServlet
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=\"UTF-8\"");
        UserService userService = new UserService();
        //1.封装数据到User对象
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        //2.调用UserService#login()方法
        try {
            User user = userService.login(form);
            request.getSession().setAttribute("sessionUser", user);
            response.sendRedirect(request.getContextPath() + "/user/welcome.jsp");
        } catch (UserException e) {
            request.setAttribute("user", form);
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
