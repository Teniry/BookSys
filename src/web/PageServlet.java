package web;

import pojo.Book;
import pojo.Page;
import service.impl.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageServlet extends BaseServlet{
    private BookService bs=new BookServiceImpl();
    //分页
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数pageNo,pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //调用bookService.page生成page对象
        Page<Book> page=bs.page(pageNo,pageSize);
        page.setUrl("pageServlet?action=page");
        //保存到request域中
        req.getSession().setAttribute("page",page);
        //跳转页面
       resp.sendRedirect("pages/rd/login_success.jsp");

    }
    //根据bkName，ISBN查图书
    protected void pageByBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数pageNo,pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        String bkName=req.getParameter("bkName");
        String bkISBN=req.getParameter("bkISBN");
        //调用bookService.page生成page对象
        Page<Book> page=bs.pageByBook(pageNo,pageSize,bkName,bkISBN);
        //生成page的路径
        StringBuilder sb=new StringBuilder("pageServlet?action=pageByBook");
        if(req.getParameter("bkName")!=null){
            sb.append("&bkName=").append(req.getParameter("bkName"));
        }
        if(req.getParameter("bkISBN")!=null){
            sb.append("&bkISBN=").append(req.getParameter("bkISBN"));
        }
        page.setUrl(sb.toString());
        //保存到session域中
        req.getSession().setAttribute("bkpage",page);
        //跳转页面
        resp.sendRedirect("pages/rd/login_success.jsp");
    }

}
