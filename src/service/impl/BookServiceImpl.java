package service.impl;

import Dao.impl.BookDao;
import Dao.impl.BookDaoImpl;
import pojo.Book;
import pojo.Page;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService{
    BookDao bookDao=new BookDaoImpl();

    @Override
    public Book bookByID(Integer ID) {
        return bookDao.bookByID(ID);
    }

    @Override
    public List<Book> bookAll() {
        return bookDao.bookALl();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page=new Page<Book>();
        //设置当前页码
        /*  page.setPageNo(pageNo);*/
        //设置页码显示数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=bookDao.queryPageCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal=pageTotalCount/pageSize;
        if((pageTotalCount%pageSize)>0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        int begin=(page.getPageNo()-1)*pageSize;
        //求当前页数据
        List<Book> items=bookDao.queryPageItems(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByBook(int pageNo, int pageSize, String name, String isbn) {
        Page<Book> page=new Page<Book>();
        List<Book> items=new ArrayList<Book>();
        //设置页码显示数量
        page.setPageSize(pageSize);
        //因为此书库每本书只有一本，只需要一面便可以展示，设置总记录数为1即可
        Integer pageTotalCount=1;
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal=pageTotalCount/pageSize;
        if((pageTotalCount%pageSize)>0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        //求当前页数据
        if(name!=""&&isbn!=""){
             items=bookDao.bookByNameISBN(name,isbn);
        }
        if(name!=""&&isbn==""){
            items=bookDao.bookByName(name);
        }
        if(name==""&&isbn!=""){
             items=bookDao.bookByISBN(isbn);
        }

        page.setItems(items);
        return page;
    }

    @Override
    public Book statusByID(Integer id, String status) {
        bookDao.statusByID(id,status);
        Book book = bookDao.bookByID(id);
        return book;
    }
}
