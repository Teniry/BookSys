package web;

import com.google.gson.Gson;
import pojo.Book;
import pojo.Reader;
import service.impl.ReaderService;
import service.impl.ReaderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CerServlet extends BaseServlet{
    ReaderService readerService=new ReaderServiceImpl();
    List<Reader> lossReader=new ArrayList<Reader>();
    List<Reader> wreader=new ArrayList<Reader>();
    String status=null;
    String withdraw=null;
    Map<String, Object> result=new HashMap<String,Object>();
    Gson gson=new Gson();

    protected void ajaxLoss(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取reader信息
        Reader reader = (Reader) req.getSession().getAttribute("reader");
        //修改rdStatus
        status="挂失";
        String rdID = reader.getRdID();
        reader.setRdStatus(status);
        Reader reader1 = readerService.updateStatusByID(rdID, status);
        lossReader.add(reader1);
        if(wreader==null){
            wreader= (List<Reader>) req.getSession().getAttribute("w_reader");
        }
        wreader.add(reader1);
        req.getSession().setAttribute("w_reader",wreader);
        req.getSession().setAttribute("lossReader",reader1);
        System.out.println(lossReader);
        result.put("status",status);
        String resultString=gson.toJson(result);
        resp.getWriter().write(resultString);

    }
    //挂失
    protected void ajaxWithdraw(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户信息
        Reader reader = (Reader) req.getSession().getAttribute("reader");
        //获取借书信息
        List<Book> lendcart = (List<Book>) req.getSession().getAttribute("lendcart");
        //如果还有借书信息不予注销
        if(lendcart.size()>0){
            withdraw="请先将书归还";
        }else{
            withdraw="t";
            //删除用户
            readerService.delByID(reader.getRdID());
            //销毁Session
            req.getSession().invalidate();
        }
        result.put("withdraw",withdraw);
        String resultString=gson.toJson(result);
        resp.getWriter().write(resultString);
    }
}
