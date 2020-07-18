package dp.knapsack;

import java.util.Arrays;

interface Solution {
    
    public int maxProfit(int[] weights, int[] prices, int capacity);

}

class Recursion implements Solution {

    private boolean selected[];

    private int maxP(int[] weights, int[] prices, int capacity, int cumulativeProfit, int i) {
        if (i == weights.length || capacity == 0) return cumulativeProfit;

        int selectThisProfit = 0, notSelectThisProfit = 0;
        if (!selected[i] && weights[i] <= capacity) {
            selected[i] = true;
            selectThisProfit = maxP(weights, prices, capacity-weights[i], cumulativeProfit+prices[i], i+1);
            selected[i] = false;
        }
        notSelectThisProfit = maxP(weights, prices, capacity, cumulativeProfit, i+1);

        return Math.max(selectThisProfit, notSelectThisProfit);
    }

    @Override
    public int maxProfit(int[] weights, int[] prices, int capacity) {
        selected = new boolean[weights.length];
        return maxP(weights, prices, capacity, 0, 0);
    }

}

class Memoization implements Solution {

    private int[][] profitBySelectAndCapacity;
    private boolean selected[];

    private int maxP(int[] weights, int[] prices, int capacity, int cumulativeProfit, int i) {
        if (i == weights.length || capacity == 0) return cumulativeProfit;
        if (profitBySelectAndCapacity[i][capacity] != -1) return profitBySelectAndCapacity[i][capacity];

        int selectThisProfit = 0, notSelectThisProfit = 0;
        if (!selected[i] && weights[i] <= capacity) {
            selected[i] = true;
            selectThisProfit = maxP(weights, prices, capacity-weights[i], cumulativeProfit+prices[i], i+1);
            selected[i] = false;
        }
        notSelectThisProfit = maxP(weights, prices, capacity, cumulativeProfit, i+1);

        profitBySelectAndCapacity[i][capacity] = Math.max(selectThisProfit, notSelectThisProfit);
        return profitBySelectAndCapacity[i][capacity];
    }

    @Override
    public int maxProfit(int[] weights, int[] prices, int capacity) {
        selected = new boolean[weights.length];
        profitBySelectAndCapacity = new int[weights.length][capacity+1];
        for (int[] r: profitBySelectAndCapacity)
            Arrays.fill(r, -1);
        return maxP(weights, prices, capacity, 0, 0);
    }

}
