package web;

import com.google.gson.Gson;
import pojo.Book;
import pojo.Reader;
import pojo.ReaderType;
import pojo.page;
import service.impl.*;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReaderServlet extends BaseServlet {
    ReaderService readerService=new ReaderServiceImpl();
    BookService bookService=new BookServiceImpl();
    ReaderTypeService readerTypeService=new ReaderTypeServiceImpl();


    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1、获取请求的参数
        String rdID = req.getParameter("rdID");
        String rdPwd = req.getParameter("rdPwd");
        Reader reader = readerService.readerbyID(rdID);
        // 调用 readerService.login()登录处理业务
       Reader loginReader = readerService.login(new Reader(rdID, rdPwd));
        // 如果等于 null,说明登录 失败!
        if (loginReader == null) {
            // 跳回登录页面

            req.setAttribute("msg","用户名或密码错误");
            req.getSession().setAttribute("rdID",rdID);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            // 登录 成功跳到成功页面 login_success
            req.getSession().setAttribute("rdID",rdID);
            req.getSession().setAttribute("reader",reader);
            //查询所有图书保存到session中
            List<Book> books = bookService.bookAll();
            req.getSession().setAttribute("books",books);
            //通过Reader里rdType查询readerType的rdType的信息名
            ReaderType readerType = readerTypeService.queryByrdType(Integer.valueOf(reader.getRdType()));
            req.getSession().setAttribute("readerType",readerType);

//            resp.sendRedirect("pages/rd/login_success.jsp");
            //跳转到PageServlet处理分页业务
             req.getRequestDispatcher("/pageServlet?action=page").forward(req,resp);

        }

    }


    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁Session
        req.getSession().invalidate();
        //重定向
        resp.sendRedirect(req.getContextPath());
    }



    protected void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rdID= (String) req.getSession().getAttribute("rdID");
        String rdPwd= req.getParameter("rdPwd");
        String password = req.getParameter("password");
        String rePwd = req.getParameter("rePwd");
        Reader reader=new Reader(rdID,password);
        //判断用户名和密码是否存在
        if(readerService.rdRight(rdID,rdPwd)){
            if(password.equals(rdPwd)==true){
                req.getSession().setAttribute("login_msg","新密码不能与旧密码相同");
                resp.sendRedirect("pages/rd/login_success.jsp");
            }else if(password.equals(rePwd)==false){
                req.getSession().setAttribute("login_msg","两次密码不一样");
                resp.sendRedirect("pages/rd/login_success.jsp");
            }else{
                int i = readerService.updatePwd(reader);
                System.out.println(i);
//                req.getSession().setAttribute("login_msg","修改成功");
                //销毁Session
                req.getSession().invalidate();
                resp.sendRedirect("index.jsp");
            }
        }else{
            req.getSession().setAttribute("login_msg","密码输入错误");
            resp.sendRedirect("pages/rd/login_success.jsp");
        }
    }

    protected void ajaxModify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rdID= (String) req.getSession().getAttribute("rdID");
        String rdPwd= req.getParameter("rdPwd");
        boolean exist=readerService.rdRight(rdID,rdPwd);
        Map<String,Object> result=new HashMap<>();
        result.put("exist",exist);
        Gson gson=new Gson();
        String json = gson.toJson(result);
        resp.getWriter().write(json);
    }


}
