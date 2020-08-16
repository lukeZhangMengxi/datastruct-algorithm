package structure.two_d.graph.network_delay_time;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            new DFS(),
            new Dijkstra(),
            new DijkstraOptimized()
        };
    }

    @Test
    public void simpleTestCase() {

        int[][] NodesTravelTime = new int[][] {
            {2, 1, 1}, {2, 3, 1}, {3, 4, 2}, {1, 4, 3}
        };
        int N = 4, K = 2;
        int expected = 3;

        for (Solution method : methods) {
            int output = method.networkDelayTime(NodesTravelTime, N, K);

            assertEquals(expected, output);
        }

    }
}
