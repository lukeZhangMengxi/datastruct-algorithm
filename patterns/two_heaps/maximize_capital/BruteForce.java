package patterns.two_heaps.maximize_capital;

public class BruteForce extends Solution {

    boolean[] selected;

    @Override
    public int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) throws Exception {
        isValid(capital, profits, numberOfProjects, initialCapital);

        selected = new boolean[capital.length];     // Default to false

        int rst = -1;
        for (int i=0; i<capital.length; i++) {
            if (capital[i] <= initialCapital && !selected[i]) {
                selected[i] = true;
                rst = Math.max(rst, dfs(capital, profits, numberOfProjects-1, initialCapital+profits[i]));
                selected[i] = false;
            }
        }

        return rst;
    }

    private int dfs(int[] capital, int[] profits, int numLimit, int totalCapital) {
        if (numLimit == 0) return totalCapital;

        int rst = 0;
        for (int i=0; i<capital.length; i++) {
            if (capital[i] <= totalCapital && !selected[i]) {
                selected[i] = true;
                rst = Math.max(rst, dfs(capital, profits, numLimit-1, totalCapital+profits[i]));
                selected[i] = false;
            }
        }
        return rst;
    }
    
}