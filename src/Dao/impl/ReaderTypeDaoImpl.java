package Dao.impl;

import pojo.ReaderType;

public class ReaderTypeDaoImpl extends BaseDao implements ReaderTypeDao {

    @Override
    public ReaderType queryByrdType(Integer rdType) {
        String sql="select * from readertype where rdType=?";
        return query(ReaderType.class,sql,rdType);
    }
}
