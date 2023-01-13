package service.impl;

import pojo.Book;
import pojo.Page;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    //根据bkID查询book的信息
    public Book bookByID(Integer ID);
    //查询所有图书
    public List<Book> bookAll();
    //当前页数据
    public Page<Book> page(int pageNo, int pageSize);
    //根据书名，ISBN查图书
    public Page<Book> pageByBook(int pageNo, int pageSize, String name, String isbn);
    //根据idgau书的状态
    public Book statusByID(Integer id,String status);
    //根据ISBN找书
    public Book bookByISBN(String isbn);
    //根据ISBN更新图书
    public void updateByISBN(String bkName, String bkAuthor, String bkPress, Integer bkPages, BigDecimal bkPrice, String bkBrief, String bkStatus, String bkISBN);
    //根据ID删图书
    public void delByID(Integer id);
    //添加图书
    public void add(String bkName, String bkAuthor, String bkPress, Integer bkPages, BigDecimal bkPrice, String bkBrief, String bkStatus, String bkISBN);
}
