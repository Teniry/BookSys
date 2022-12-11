package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class JdbcUtils {
private static DataSource druid;
    static {
        try {

            Properties pro=new Properties();
           // InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pro.load(is);
             druid = DruidDataSourceFactory.createDataSource(pro);


        } catch (Exception e) {
           e.printStackTrace();
        }
    }




    public  static Connection getcon(){
        Connection conn=null;
        try {
            conn=druid.getConnection();
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static  void close(Connection conn){
        if(conn!=null){
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }}



}
