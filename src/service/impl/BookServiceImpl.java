package service.impl;

import Dao.impl.BookDao;
import Dao.impl.BookDaoImpl;
import pojo.Book;
import pojo.page;

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
    public page<Book> page(int pageNo, int pageSize) {
        page<Book> page=new page<Book>();
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
}
