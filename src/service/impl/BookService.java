package service.impl;

import pojo.Book;
import pojo.page;

import java.util.List;

public interface BookService {
    //根据bkID查询book的信息
    public Book bookByID(Integer ID);
    //查询所有图书
    public List<Book> bookAll();
    //当前页数据
    public page<Book> page(int pageNo, int pageSize);
}
