package Dao.impl;


import utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
   private QueryRunner qr=new QueryRunner();

   public int update(String sql,Object...args){
    Connection conn= JdbcUtils.getcon();
    try {
     qr.update(conn,sql,args);
    } catch (SQLException e) {
     e.printStackTrace();
    }finally {
     JdbcUtils.close(conn);
    }
     return -1;
   }

   public <T>T query(Class<T> clazz,String sql,Object...args){
       Connection conn=JdbcUtils.getcon();
       try {
           return qr.query(conn,sql,new BeanHandler<T>(clazz),args);
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           JdbcUtils.close(conn);
       }
       return null;
   }

    public <T> List<T> querylist(Class<T> clazz, String sql, Object...args){
        Connection conn=JdbcUtils.getcon();
        ArrayList list=new ArrayList<>();
        try {

           return qr.query(conn,sql,new BeanListHandler<T>(clazz),args);

        } catch (SQLException e) {
            try {
                e.printStackTrace();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            } finally {
            }
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    public Object queryForSingleValue(String sql, Object... args){

        Connection conn = JdbcUtils.getcon();

        try {
            return qr.query(conn, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;

    }
}
