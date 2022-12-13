package Dao.impl;

import pojo.Book;

import java.util.List;

public interface BookDao {
    //根据bkID查询book信息
    public Book bookByID(Integer ID);
    //查询所有图书
    public List<Book> bookALl();
    //查询图书生成的总页数
    public Integer queryPageCount();
    //查询每页的图书
    public List<Book> queryPageItems(int begin, int pageSize);
    //根据bkName查询图书
    public List<Book> bookByName(String name);
    //根据bkISBN查询图书
    public List<Book> bookByISBN(String isbn);
    //根据bkName和bkISBN查书
    public List<Book> bookByNameISBN(String name,String isbn);
    //根据id改状态
    public void statusByID(Integer id,String status);
}
