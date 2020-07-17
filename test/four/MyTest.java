package test.four;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class MyTest {
    
    @Test
    public void simpleTestCase() {
        Solution m = new SolutionImpl();

        m.addString("abc");
        m.addString("123456789");

        List<String> rst = m.getResult();

        assertEquals(3, rst.size());
        assertEquals(0, rst.get(0).compareTo("abc00000"));
        assertEquals(0, rst.get(1).compareTo("12345678"));
        assertEquals(0, rst.get(2).compareTo("90000000"));
    }

}