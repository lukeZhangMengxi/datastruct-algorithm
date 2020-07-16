package test.three;

import org.junit.Test;

public class MyTest {
    
    @Test
    public void simpleTestCase() {
        Solution method = new SolutionImpl();

        assert(method.getLarger("4 4 4 4-joker JOKER").compareTo("joker JOKER") == 0);
    }

}