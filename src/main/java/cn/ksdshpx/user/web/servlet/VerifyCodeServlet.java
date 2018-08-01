package cn.ksdshpx.user.web.servlet;

import cn.itcast.vcode.utils.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/1
 * Time: 16:56
 * Description:图片验证码Servlet
 */
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建图片验证码类
        VerifyCode verifyCode = new VerifyCode();
        //2.获取验证码图片
        BufferedImage image = verifyCode.getImage();
        //3.往session中保存图片验证码上的值
        request.getSession().setAttribute("session_vcode", verifyCode.getText());
        //4.将图片验证码写回到客户端流中
        VerifyCode.output(image, response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
