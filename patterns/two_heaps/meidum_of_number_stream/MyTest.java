package patterns.two_heaps.meidum_of_number_stream;

import org.junit.Before;
import org.junit.Test;


public class MyTest {

    private Solution[] objects;

    @Before
    public void init() {
        objects = new Solution[] {
            new BruteForce(),
            new TwoHeaps()
        };
    }

    @Test
    public void simpleTestCase() {
        for (Solution object: objects) {
            object.insertNum(3);
            object.insertNum(1);
            assert(object.findMedian() == 2.0);
            object.insertNum(5);
            assert(object.findMedian() == 3.0);
            object.insertNum(4);
            assert(object.findMedian() == 3.5);
        }

    }
}
