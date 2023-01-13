package Dao.impl;

import pojo.Book;

import java.math.BigDecimal;
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

    @Override
    public List<Book> bookByName(String name) {
        String sql="select * from book where bkName=?";
        return querylist(Book.class,sql,name);
    }

    @Override
    public List<Book> bookByISBN(String isbn) {
        String sql="select * from book where bkISBN=?";
        return querylist(Book.class,sql,isbn);
    }

    @Override
    public List<Book> bookByNameISBN(String name, String isbn) {
        String sql="select * from book where bkName=? and bkISBN=?";
        return querylist(Book.class,sql,name,isbn);
    }

    @Override
    public void statusByID(Integer id,String status) {
        String sql="update book set bkStatus=? where bkID=? ";
         update(sql,status,id);
    }

    @Override
    public void update(String bkName, String bkAuthor, String bkPress, Integer bkPages, BigDecimal bkPrice, String bkBrief, String bkStatus, String bkISBN) {
        String sql="update book set  bkName=?, bkAuthor=?, bkPress=?, bkPages=?, bkPrice=?,bkBrief=?, bkStatus=? where bkISBN=? ";
        update(sql,bkName, bkAuthor, bkPress,  bkPages, bkPrice, bkBrief,  bkStatus,  bkISBN);
    }

    @Override
    public void delByID(Integer id) {
        String sql="delete from book where bkID=?";
        update(sql,id);
    }

    @Override
    public void add(String bkName, String bkAuthor, String bkPress, Integer bkPages, BigDecimal bkPrice, String bkBrief, String bkStatus, String bkISBN) {
        String sql="insert into book(bkName, bkAuthor, bkPress,  bkPages, bkPrice, bkBrief,  bkStatus,  bkISBN)" +
                "values(?,?,?,?,?,?,?,?)";
        update(sql,bkName, bkAuthor, bkPress,  bkPages, bkPrice, bkBrief,  bkStatus,  bkISBN);
    }
}
