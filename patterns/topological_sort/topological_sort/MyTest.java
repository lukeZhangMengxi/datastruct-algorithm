package patterns.topological_sort.topological_sort;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    Solution[] solutions;

    private boolean isOrdered(List<Integer> target, int[][] constraints) {
        for (int[] c: constraints) {
            if (target.indexOf(c[0]) > target.indexOf(c[1])) return false;
        }
        return true;
    }

    @Before
    public void init() {
        solutions = new Solution[] {
            new TopoSort()
        };
    }

    @Test
    public void simple() {
        int numVertices = 4;
        int[][] edges = new int[][] {
            new int[] {3, 2},
            new int[] {3, 0},
            new int[] {2, 0},
            new int[] {2, 1}
        };

        for (Solution s: solutions) {
            assert(
                isOrdered(
                    s.sort(numVertices, edges),
                    edges
                )
            );
        }
    }

    @Test
    public void simple2() {
        int numVertices = 5;
        int[][] edges = new int[][] {
            new int[] {4, 2},
            new int[] {4, 3},
            new int[] {2, 0},
            new int[] {2, 1},
            new int[] {3, 1}
        };

        for (Solution s: solutions) {
            assert(
                isOrdered(
                    s.sort(numVertices, edges),
                    edges
                )
            );
        }
    }

    @Test
    public void cycle() {
        int numVertices = 3;
        int[][] edges = new int[][] {
            new int[] {0, 1},
            new int[] {1, 2},
            new int[] {2, 0}
        };

        for (Solution s: solutions) {
            assert(
                isOrdered(
                    s.sort(numVertices, edges),
                    edges
                )
            );
        }
    }

}
