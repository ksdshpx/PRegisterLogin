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
import java.util.HashMap;
import java.util.Map;

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
        //2.表单校验
        String username = form.getUsername();
        String password = form.getPassword();
        String verifyCode = form.getVerifyCode();
        String sessionVerifyCode = (String) request.getSession().getAttribute("session_vcode");
        Map<String, String> errors = new HashMap<>();
        if (username == null || username.trim().isEmpty()) {
            errors.put("username", "用户名不能为空!");
        } else if (username.length() < 3 || username.length() > 15) {
            errors.put("username", "用户名长度应在3~15位之间！");
        }
        if (password == null || password.trim().isEmpty()) {
            errors.put("password", "密码不能为空!");
        } else if (password.length() < 3 || password.length() > 15) {
            errors.put("password", "密码长度应在3~15位之间！");
        }
        if (verifyCode == null || verifyCode.trim().isEmpty()) {
            errors.put("verifyCode", "验证码不能为空!");
        } else if (verifyCode.length() != 4) {
            errors.put("verifyCode", "验证码长度应为4位！");
        } else if (sessionVerifyCode == null || !sessionVerifyCode.equalsIgnoreCase(verifyCode)) {
            errors.put("verifyCode", "验证码错误!");
        }
        if (errors != null && errors.size() > 0) {
            request.setAttribute("user", form);//用于表单回显
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/user/register.jsp").forward(request, response);
            return;
        }
        //3.调用service#register()
        try {
            userService.register(form);
            response.getWriter().print("注册成功！");
        } catch (UserException e) {
            //获取异常信息，保存到request域中，转发到register.jsp
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("user", form);//用于表单回显
            request.getRequestDispatcher("/user/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
