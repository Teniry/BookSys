package web;

import com.google.gson.Gson;
import pojo.Book;
import pojo.Reader;
import service.impl.BookService;
import service.impl.BookServiceImpl;
import service.impl.ReaderService;
import service.impl.ReaderServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ManagerServlet extends BaseServlet{
    private Map< Integer,Book> items=new LinkedHashMap<Integer,Book>();
    private Map< String,Reader> regists=new LinkedHashMap<String,Reader>();
    BookService bookService=new BookServiceImpl();
    ReaderService readerService=new ReaderServiceImpl();
    List<Book> list;
    List<Reader> regist;
    List<Reader> wreader;
    Map<String, Object> result=new HashMap<String,Object>();
    Gson gson=new Gson();


    protected void form(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.bookByID(id);
        result.put("bkname",book.getBkName());
        result.put("bkauthor",book.getBkAuthor());
        result.put("bkprice",book.getBkPrice());
        result.put("bkpress",book.getBkPress());
        result.put("bkisbn",book.getBkISBN());
        result.put("bkpages",book.getBkPages());
        result.put("bkstatus",book.getBkStatus());
        result.put("bkbrief",book.getBkBrief());
        String resultString=gson.toJson(result);
        resp.getWriter().write(resultString);
    }

    //通过isbn编辑图书
    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取修改的数据
        String bkName = req.getParameter("bkName");
        String bkAuthor = req.getParameter("bkAuthor");
        String bkPress = req.getParameter("bkPress");
        int bkPrice = WebUtils.parseInt(req.getParameter("bkPrice"),0);
        int bkPages = WebUtils.parseInt(req.getParameter("bkPages"),0);
        String bkStatus = req.getParameter("bkStatus");
        String bkBrief = req.getParameter("bkBrief");
        //获取需要编辑的图书
        String bkISBN = req.getParameter("bkISBN");
        list= (List<Book>) req.getSession().getAttribute("mcart");
        bookService.updateByISBN(bkName, bkAuthor, bkPress,  bkPages, BigDecimal.valueOf(bkPrice), bkBrief,  bkStatus,  bkISBN);
        list=bookService.bookAll();
        for (Book book : list) {
            items.put(book.getBkID(),book);
        }
       req.getSession().setAttribute("mcart",list);
        resp.sendRedirect("pages/manager/controlBook.jsp");

    }

    //删除图书
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要删除书的id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        bookService.delByID(id);
        System.out.println(list);
        list= (List<Book>) req.getSession().getAttribute("mcart");
        System.out.println(list);
        for (Book book : list) {
                items.put(book.getBkID(),book);
            }

        System.out.println(list);
         items.remove(id);
        list=  items.values().stream().collect(Collectors.toList());
        req.getSession().setAttribute("mcart",list);


        System.out.println(list);
        String del="删除成功！";
        result.put("del",del);
        String resultString=gson.toJson(result);
        resp.getWriter().write(resultString);
    }

    //添加图书
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取添加的参数
        String bkName = req.getParameter("bkName");
        String bkAuthor = req.getParameter("bkAuthor");
        String bkPress = req.getParameter("bkPress");
        int bkPrice = WebUtils.parseInt(req.getParameter("bkPrice"),0);
        int bkPages = WebUtils.parseInt(req.getParameter("bkPages"),0);
        String bkStatus = req.getParameter("bkStatus");
        String bkBrief = req.getParameter("bkBrief");
        String bkISBN = req.getParameter("bkISBN");
        //添加图书
        bookService.add(bkName, bkAuthor, bkPress,  bkPages, BigDecimal.valueOf(bkPrice), bkBrief,  bkStatus,  bkISBN);
        Book book = bookService.bookByISBN(bkISBN);
        list= (List<Book>) req.getSession().getAttribute("mcart");
        list.add(book);
        for (Book book1 : list) {
            items.put(book1.getBkID(),book);
        }
        resp.sendRedirect("pages/manager/controlBook.jsp");
    }


    //申请通过
    protected void agree(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
         regist = (List<Reader>) req.getSession().getAttribute("regist");

        Reader reader = (Reader) req.getSession().getAttribute("r_reader");
        for (Reader reader1 : regist) {
            regists.put(reader1.getRdID(),reader1);
        }
        //申请通过保存到数据库中
        readerService.regist(reader);
        regists.remove(id);
        regist=regists.values().stream().collect(Collectors.toList());
        req.getSession().setAttribute("regist",regist);
        String pass="申请通过！";
        result.put("pass",pass);
        String resultString=gson.toJson(result);
        resp.getWriter().write(resultString);
    }

    //拒绝申请
    protected void reject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        regist = (List<Reader>) req.getSession().getAttribute("regist");
        for (Reader reader1 : regist) {
            regists.put(reader1.getRdID(),reader1);
        }
        regists.remove(id);
        regist=regists.values().stream().collect(Collectors.toList());
        req.getSession().setAttribute("regist",regist);
        String reject="拒绝成功！";
        result.put("reject",reject);
        String resultString=gson.toJson(result);
        resp.getWriter().write(resultString);
    }

    //取消挂失

    protected void cancelLoss(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        wreader= (List<Reader>) req.getSession().getAttribute("w_reader");
        Map< String,Reader> wreaders=new LinkedHashMap<String,Reader>();
        for (Reader reader1 : wreader) {
            wreaders.put(reader1.getRdID(),reader1);
        }
        //修改读者状态
        Reader reader = readerService.updateStatusByID(id, "有效");
        System.out.println(reader);
        Reader reader2 = (Reader) req.getSession().getAttribute("lossReader");
        reader2.setRdStatus("有效");
        wreaders.remove(id);
        wreader=wreaders.values().stream().collect(Collectors.toList());
        req.getSession().setAttribute("w_reader",wreader);
        String cancel="取消挂失成功！";
        result.put("cancel",cancel);
        String resultString=gson.toJson(result);
        resp.getWriter().write(resultString);
    }
}
