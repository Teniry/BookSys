package web;


import com.google.gson.Gson;
import pojo.*;
import service.impl.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LendServlet extends BaseServlet {
    BookService bookService=new BookServiceImpl();
    int count=0;
    int i=0;
    /**
     * 添加借的书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //借的书的数量

        int id= WebUtils.parseInt(req.getParameter("id"),0);
        //通过id获取图书的信息
        Book book=bookService.bookByID(id);
        //添加商品项
         List<Book> lendcart= (List<Book>) req.getSession().getAttribute("lendcart");
        if(lendcart==null){
           lendcart=new ArrayList<Book>();
            req.getSession().setAttribute("lendcart",lendcart);

        }
        lendcart.add(book);
        count++;

        //更改读者借书的数目(没改数据库)
        Reader reader = (Reader) req.getSession().getAttribute("reader");
        if(count==i+1){
            reader.setRdBorrow(count);
            i++;
        }
        req.getSession().setAttribute("reader",reader);
        //获取当前借书的时间
        Date date=new Date();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        String format = formatter.format(date);

        req.getSession().setAttribute("lendDate",format);
        //重定向返回商品列表页面
       resp.sendRedirect("pages/rd/login_success.jsp");

    }

    protected void ajaxAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id=WebUtils.parseInt(req.getParameter("id"),0);
        //通过id获取图书的信息
        Book book=bookService.bookByID(id);
        //把图书转化为cartItem项
        //CartItem cartItem=new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //添加商品项
        List<Book> cart= (List<Book>) req.getSession().getAttribute("cart");
        if(cart==null){
            cart=new ArrayList<Book>();
            req.getSession().setAttribute("cart",cart);
        }
        cart.add(book);
        System.out.println(cart);
        //最后一个添加商品的名称
       // req.getSession().setAttribute("lastName",cartItem.getName());
        //获取当前借书的时间
        Date date=new Date();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        String format = formatter.format(date);
        req.getSession().setAttribute("lendDate",format);
        System.out.println(format);

        Map<String, Object> result=new HashMap<String,Object>();

        result.put("cart",cart);


        Gson gson=new Gson();
        String resultString=gson.toJson(result);
        resp.getWriter().write(resultString);
    }
}
