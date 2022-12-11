package Test;

import Dao.impl.*;
import org.junit.Test;
import pojo.Reader;
import pojo.ReaderType;
import service.impl.*;

public class ReaderServiceTest {
    ReaderService rs=new ReaderServiceImpl();
    @Test
    public void login() {

//        Reader reader=new Reader("202200001","张三","男",null,"物联1001",null,null,null,null,null,null,"123456",0);
        Reader r=new Reader("202200001",null);
        System.out.println(rs.login(r));
    }
    @Test
    public void update(){
        int i = rs.updatePwd(new Reader("202200001", "12345"));
        System.out.println(i);
    }
    @Test
    public  void queryRight(){
        ReaderDao readerDao=new ReaderDaoImpl();
        System.out.println(readerDao.queryRight(null,null));
    }

    @Test
    public void  query(){
        ReaderService readerService=new ReaderServiceImpl();
        Reader reader = readerService.readerbyID("202200001");
        System.out.println(reader.getRdType());
        ReaderTypeService readerTypeService=new ReaderTypeServiceImpl();
        ReaderType readerType = readerTypeService.queryByrdType(Integer.valueOf(reader.getRdType()));
        System.out.println(readerType);


    }


}