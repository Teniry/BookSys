package service.impl;

import Dao.impl.ReaderDao;
import Dao.impl.ReaderDaoImpl;
import pojo.Reader;

public class ReaderServiceImpl implements ReaderService {
    ReaderDao reader=new ReaderDaoImpl();

    @Override
    public void regist(Reader rd) {

    }

    @Override
    public Reader login(Reader rd) {
            Reader r = reader.queryRight(rd.getRdID(), rd.getRdPwd());
            return r;
    }

    @Override
    public boolean exist(String rdID) {
        if(reader.querybyname(rdID)==null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean rdRight(String rdID, String rdPwd) {
        if(reader.queryRight(rdID,rdPwd)==null){
            return false;
        }else return true;
    }

    @Override
    public int updatePwd(Reader re) {

        return reader.rdUpdatePwd(re);
    }

    @Override
    public Reader readerbyID(String ID) {
        return reader.querybyID(ID);

    }

    @Override
    public Reader updateStatusByID(String rdID, String status) {
        reader.updateStatusByID(rdID,status);
        Reader reader1 = reader.querybyID(rdID);
        return reader1;
    }

    @Override
    public void delByID(String ID) {
        reader.delByID(ID);
    }
}
