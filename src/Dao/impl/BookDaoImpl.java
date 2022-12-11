package Dao.impl;

import pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao{
    @Override
    public Book bookByID(Integer ID) {
        String sql="select * from  book where bkID=?";
        return query(Book.class,sql,ID);
    }

    @Override
    public List<Book> bookALl() {
        String sql="select * from book";
        return querylist(Book.class,sql);
    }

    @Override
    public Integer queryPageCount() {
        String sql="select count(*) from book";
        Number count=(Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryPageItems(int begin, int pageSize) {
        String sql="select * from book limit ?,?";
        return querylist(Book.class,sql,begin,pageSize);
    }
}
