package service.impl;

import pojo.Book;
import pojo.Page;

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
}
