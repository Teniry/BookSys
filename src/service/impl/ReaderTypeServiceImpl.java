package service.impl;

import Dao.impl.ReaderTypeDao;
import Dao.impl.ReaderTypeDaoImpl;
import pojo.ReaderType;

public class ReaderTypeServiceImpl implements ReaderTypeService{
    ReaderTypeDao readerTypeDao=new ReaderTypeDaoImpl();
    @Override
    public ReaderType queryByrdType(Integer rdType) {
         return readerTypeDao.queryByrdType(rdType);
    }
}
