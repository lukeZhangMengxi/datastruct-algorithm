package patterns.topological_sort.dependent_tasks_scheduling;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    
    private Solution[] solutions;

    private boolean isOrdered(List<Integer> target, int[][] constraints) {
        for (int[] c: constraints) {
            if (target.indexOf(c[0]) > target.indexOf(c[1])) return false;
        }
        return true;
    }

    @Before
    public void init() {
        solutions = new Solution[] {
            new GreedyDFS()
        };
    }

    @Test
    public void simple() {
        int numVertices = 6;
        int[][] edges = new int[][] {
            new int[] {2, 5},
            new int[] {0, 5},
            new int[] {0, 4},
            new int[] {1, 4},
            new int[] {3, 2},
            new int[] {1, 3}
        };

        for (Solution s: solutions) {
            assert(
                isOrdered(
                    s.getOrderedTasks(numVertices, edges),
                    edges
                )
            );
        }
    }

}