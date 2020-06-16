package cn.tedu;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "CartServlet", urlPatterns = "/CartServlet")
public class CartServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //----------------------------------------------------------
        //1.获取一个session对象
        String prod = request.getParameter("prod");
        //2.获取一个session对象，将商品信息保存在session中
        HttpSession session = request.getSession();
        //创建一个名称为JSESSIONID的cookie，值为session的id
        Cookie c = new Cookie("JSESSIONID", session.getId());
        //设置cookie的存活时间为1天
        c.setMaxAge(60*24*60);
        //将cookie定下来
        response.addCookie(c);
        session.setAttribute("cart",prod);
        //3.做出响应
        out.write("成功将"+prod+"加入购物车");
    }
}
