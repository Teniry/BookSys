package service.impl;

import pojo.Reader;

public interface ReaderService {
    /**
     * 注册
     */
    public void regist(Reader rd);
    /**
     * 登录
     */
    public  Reader login(Reader rd);
    /**
     * 判断编号是否可用
     */
    public  boolean exist(String rdID);
    /**
     * 判断用户名和密码是否正确
     */
    public boolean rdRight(String rdID,String rdPwd);
    /**
     * 修改密码
     */
    public int updatePwd(Reader reader);
    /**
     * 查询用户信息
     */
    public Reader readerbyID(String ID);
    /**
     * 根据rdID改rdStatus
     */
    public  Reader updateStatusByID(String rdID,String status);
    /**
     * 根据ID注销用户
     */
    public void delByID(String ID);
}
