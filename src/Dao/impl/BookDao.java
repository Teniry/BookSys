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
}
