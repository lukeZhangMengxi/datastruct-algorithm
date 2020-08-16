package structure.one_d.stream.product_array_except_self;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            new TwoSideDP(),
            new TwoPassCumulativeProduct()
        };
    }

    @Test
    public void simpleTestCase() {

        int[] inputs = new int[] {1, 2, -3, 4, 5};
        int[] expected = new int[] {-120, -60, 40, -30, -24};

        for (Solution method : methods) {
            int[] output = method.productExceptSelf(Arrays.copyOf(inputs, inputs.length));

            for (int i=0; i<inputs.length; i++) {
                assertEquals(expected[i], output[i]);
            }
            
        }

    }
}
