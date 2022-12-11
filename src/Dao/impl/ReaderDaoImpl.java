package Dao.impl;

import pojo.Reader;
import pojo.ReaderType;

public class ReaderDaoImpl extends BaseDao implements ReaderDao {

    //判断ID是否可用
    @Override
    public Reader querybyname(String rdID) {
        String sql="select rdName from reader where rdName=?";
        return query(Reader.class,sql,rdID);
    }

    @Override
    public Reader querybyID(String rdID) {
        String sql="select * from reader where rdID=?";
        return query(Reader.class,sql,rdID);
    }

    @Override
    public Reader queryRight(String rdID, String password) {
        String sql="select rdID,rdName,rdPwd from reader where rdID=? and rdPwd=?";
        return query(Reader.class,sql,rdID,password);
    }

    @Override
    public Reader loginRight(String rdID, String password) {
       String sql=" select rdID,rdName,rdPwd from reader where rdID=? and rdPwd=?";
       return query(Reader.class,sql,rdID,password);
    }

    @Override
    public int save(Reader reader) {
        String sql="insert into reader(rdID,rdName,rdSex,rdDept,rdPhone,rdEmail,rdDateReg,rdBorrow,rdPwd) " +
                "values(?,?,?,?,?,?,?,?,?)";

        return update(sql,reader.getRdID(),reader.getRdName(),reader.getRdSex(),reader.getRdDept(),reader.getRdPhone(),reader.getRdEmail(),
                reader.getRdDateReg(),reader.getRdBorrow(),reader.getRdPwd());
    }

    @Override
    public int rdUpdatePwd(Reader reader) {
        String sql="update reader set rdPwd=? where rdID=?" ;

        return update(sql,reader.getRdPwd(),reader.getRdID());
    }

    @Override
    public int queryIDByrdType(String rdID) {
        String sql="select rdType from reader where rdID=?";
        Reader query = query(Reader.class, sql, rdID);
        return query.getRdType();
    }


}
