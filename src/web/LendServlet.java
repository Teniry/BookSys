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
import java.util.stream.Collectors;



public class LendServlet extends BaseServlet {
    private Map< Integer,Book> items=new LinkedHashMap<Integer,Book>();
    BookService bookService=new BookServiceImpl();
<<<<<<< HEAD
    Map<String, Object> result=new HashMap<String,Object>();
    Gson gson=new Gson();
    int msg;
    int count=0;
=======
    int count=0;
    int i=0;
>>>>>>> dd5d906178c93ef3a7fd7dd6fa655da8975e6d3e
    /**
     * 添加借的书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //借的书的数量
<<<<<<< HEAD
        ReaderType reqaertype = (ReaderType) req.getSession().getAttribute("readerType");
        int canLend=reqaertype.getCanLendCount();
        int id= WebUtils.parseInt(req.getParameter("id"),0);
        //通过id获取图书的信息
        Book book=bookService.bookByID(id);
        //获得lendcart
         List<Book> lendcart= (List<Book>) req.getSession().getAttribute("lendcart");
        if(lendcart==null){
           lendcart=new ArrayList<Book>();
//            req.getSession().setAttribute("lendcart",lendcart);

        }

        //获取借书的数目
        count=lendcart.size();
        Reader reader = (Reader) req.getSession().getAttribute("reader");
        if(count<canLend){
            //修改借的书的状态(没改数据库里的状态)
            Page page = (Page) req.getSession().getAttribute("page");
            //创建索引
            int i=0;
            List<Book> item = page.getItems();
            for (Book book1 : item) {
                if(book1.getBkName().equals(book.getBkName())){
                    book1.setBkStatus("已借出");
                    item.set(i,book1);
                }
                i++;
            }
            System.out.println(item);

            //将书放入Map里方便删除根据书的ID删
            items.put(id,book);
            lendcart.add(book);
            //更改读者借书的数目(没改数据库)
            count=lendcart.size();
            reader.setRdBorrow(count);
            req.getSession().setAttribute("lendcart",lendcart);

            //获取当前借书的时间
            Date date=new Date();
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            String format = formatter.format(date);

            req.getSession().setAttribute("lendDate",format);
        }
=======

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
>>>>>>> dd5d906178c93ef3a7fd7dd6fa655da8975e6d3e
        //重定向返回商品列表页面
        resp.sendRedirect("pages/rd/login_success.jsp");

    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取商品编号
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        //获取商品对象
        List<Book> cart = (List<Book>) req.getSession().getAttribute("lendcart");
        if(cart!=null){
            Reader reader = (Reader) req.getSession().getAttribute("reader");
            Book book=bookService.bookByID(id);
            //将归还书从lendcart移除
            items.remove(id);
            cart=  items.values().stream().collect(Collectors.toList());
            //更改读者借书的数目(没改数据库)
            count=cart.size();
            reader.setRdBorrow(count);
            req.getSession().setAttribute("lendcart",cart);
            //修改借的书的状态(改了数据库里的状态)
            Page page = (Page) req.getSession().getAttribute("page");
            //创建索引
            int i=0;
            List<Book> item = page.getItems();
            for (Book book1 : item) {
                if(book1.getBkName().equals(book.getBkName())){
                    Book b = bookService.statusByID(id, "已借出");
                    item.set(i,b);
                }
                i++;
            }
            resp.sendRedirect("pages/rd/login_success.jsp");
        }
    }


    protected void ajaxAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //借的书的数量
        ReaderType reqaertype = (ReaderType) req.getSession().getAttribute("readerType");
        int canLend=reqaertype.getCanLendCount();
        int id= WebUtils.parseInt(req.getParameter("id"),0);

        //获得lendcart
        List<Book> lendcart= (List<Book>) req.getSession().getAttribute("lendcart");
        if(lendcart==null){
            lendcart=new ArrayList<Book>();
//            req.getSession().setAttribute("lendcart",lendcart);

        }
<<<<<<< HEAD
=======
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
>>>>>>> dd5d906178c93ef3a7fd7dd6fa655da8975e6d3e

        //获取借书的数目
        count=lendcart.size();
        Reader reader = (Reader) req.getSession().getAttribute("reader");
        if(count<canLend){
            msg=1;
            //通过id获取图书的信息,修改借的书的状态(改了数据库里的状态)
            Book book=bookService.statusByID(id,"已借出");

<<<<<<< HEAD
            Page page = (Page) req.getSession().getAttribute("page");
            //创建索引
            int i=0;
            List<Book> item = page.getItems();
            for (Book book1 : item) {
                if(book1.getBkName().equals(book.getBkName())){
                    item.set(i,book);
                }
                i++;
            }
            System.out.println(item);
=======
        result.put("cart",cart);
>>>>>>> dd5d906178c93ef3a7fd7dd6fa655da8975e6d3e

            //将书放入Map里方便删除根据书的ID删
            items.put(id,book);
            lendcart.add(book);
            //更改读者借书的数目(没改数据库)
            count=lendcart.size();
            reader.setRdBorrow(count);
            req.getSession().setAttribute("lendcart",lendcart);

            //获取当前借书的时间
            Date date=new Date();
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            String format = formatter.format(date);
            req.getSession().setAttribute("lendDate",format);
        }else{
            msg=0;
        }
        //传回msg判断是否借书超出数额
        result.put("msg",msg);
        String resultString=gson.toJson(result);
        resp.getWriter().write(resultString);


    }


    protected void ajaxDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        //获取商品对象
        List<Book> cart = (List<Book>) req.getSession().getAttribute("lendcart");
        if(cart!=null){
            Reader reader = (Reader) req.getSession().getAttribute("reader");
            Book book=bookService.statusByID(id,"在馆");
            //将归还书从lendcart移除
            items.remove(id);
            cart=  items.values().stream().collect(Collectors.toList());
            //更改读者借书的数目(没改数据库)
            count=cart.size();
            reader.setRdBorrow(count);
            req.getSession().setAttribute("lendcart",cart);
            //修改借的书的状态(没改数据库里的状态)
            Page page = (Page) req.getSession().getAttribute("page");
            //创建索引
            int i=0;
            List<Book> item = page.getItems();
            for (Book book1 : item) {
                if(book1.getBkName().equals(book.getBkName())){
                    item.set(i,book);
                }
                i++;
            }
            String del="您确定要还书吗？";
            result.put("del",del);
            String resultString=gson.toJson(result);
            resp.getWriter().write(resultString);
        }
    }
}
