package Dao.impl;

import pojo.Reader;

public interface ReaderDao {
    //根据用户名查询用户信息
    public Reader querybyname(String name);
    //根据rdID查询用户信息
    public Reader querybyID(String rdID);
   // 根据用户rdID和密码查询用户信息
    public  Reader queryRight(String rdID,String password);
    // 根据用户rdID和密码查询用户信息
    public  Reader loginRight(String rdID,String password);
    //保存用户信息(返回-1，表示操作失败)
    public int save(Reader reader);
    //修改用户信息
    public int rdUpdatePwd(Reader reader);
    //通过rdID查询rdType
    public int queryIDByrdType(String rdID);

}
