package utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    public static <T>T  copy(Map value, T bean){


        try {
            System.out.println("注入之前"+bean);
            /**
             * 把所有請求參數注入到user對象中
             */

            BeanUtils.populate(bean,value);
            System.out.println("注入之后"+bean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return bean;
    }

    public static int parseInt(String str ,int deint ){
        try {


            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deint;
    }
}
