package Test;

import org.junit.Test;
import utils.JdbcUtils;

import static org.junit.Assert.*;

public class JdbcUtilsTest {
@Test
public void getconnTest(){
    System.out.println(JdbcUtils.getcon());
}
}