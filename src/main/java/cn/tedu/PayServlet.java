package cn.tedu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PayServlet", urlPatterns = "/PayServlet")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //----------------------------------------------------------
        //1.获取一个session对象(获取之前的session)
        HttpSession session = request.getSession();
       /* //设置session的超时时间(s)
        session.setMaxInactiveInterval(30);*/
        String prod = (String) session.getAttribute("cart");
        //3.模拟支付，做出响应
        if(prod==null){
            out.write("没有添加任何商品");
        }else {
            out.write("成功为"+prod+"完成支付");
        }
    }
}
