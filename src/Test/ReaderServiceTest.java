package Test;

import Dao.impl.*;
import org.junit.Test;
import pojo.Book;
import pojo.Reader;
import pojo.ReaderType;
import service.impl.*;

import java.math.BigDecimal;

public class ReaderServiceTest {
    ReaderService rs=new ReaderServiceImpl();
    @Test
    public void login() {

//        Reader reader=new Reader("202200001","张三","男",null,"物联1001",null,null,null,null,null,null,"123456",0);
        Reader r=new Reader("202200001",null);
        System.out.println(rs.login(r));
    }
    @Test
    public void update(){
        int i = rs.updatePwd(new Reader("202200001", "12345"));
        System.out.println(i);
    }
    @Test
    public  void queryRight(){
        ReaderDao readerDao=new ReaderDaoImpl();
        System.out.println(readerDao.queryRight(null,null));
    }

    @Test
    public void  query(){
        ReaderService readerService=new ReaderServiceImpl();
        Reader reader = readerService.readerbyID("202200001");
        System.out.println(reader.getRdType());
        ReaderTypeService readerTypeService=new ReaderTypeServiceImpl();
        ReaderType readerType = readerTypeService.queryByrdType(Integer.valueOf(reader.getRdType()));
        System.out.println(readerType);


    }

    @Test
    public void pageBYBook(){
        BookDao bookDao=new BookDaoImpl();
        System.out.println(bookDao.bookByName("516"));
        System.out.println(bookDao.bookByISBN("703071363"));
        System.out.println(bookDao.bookByNameISBN("概率论与数理统计","703071363"));
    }

    @Test
    public  void statusByID(){
       BookService bookService=new BookServiceImpl();
        System.out.println(bookService.statusByID(2,"在馆"));
    }

    @Test
    public void rdStatusByID(){
        ReaderService readerService=new ReaderServiceImpl();
        System.out.println(readerService.updateStatusByID("201801001","挂失"));
    }

    @Test
    public void delByID(){
       BookService bookService=new BookServiceImpl();
       bookService.add("6sf","485","844622",551, BigDecimal.valueOf(8446),null,null,null);
    }

    @Test
    public void bookByISBN(){
        BookService bookService=new BookServiceImpl();
        bookService.updateByISBN(null, null, null,  111111, null, null,  null,  "703071363");
        Book book = bookService.bookByISBN("703071363");
        System.out.println(book);
    }

    @Test
    public void type(){

        ReaderTypeService readerTypeService=new ReaderTypeServiceImpl();
        ReaderType readerType = readerTypeService.queryByrdType(2);
        System.out.println(readerType);
    }

}