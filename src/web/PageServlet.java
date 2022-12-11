package web;

import pojo.Book;
import pojo.page;
import service.impl.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageServlet extends BaseServlet{
    private BookService bs=new BookServiceImpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数pageNo,pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), page.PAGE_SIZE);
        //调用bookService.page生成page对象
        page<Book> page=bs.page(pageNo,pageSize);
        page.setUrl("pageServlet?action=page");
        //保存到request域中
        req.getSession().setAttribute("page",page);
        //跳转页面
       resp.sendRedirect("pages/rd/login_success.jsp");

    }


}
