package dp.knapsack;

import java.util.Arrays;

interface Solution {
    
    public int maxProfit(int[] weights, int[] prices, int capacity);

}

class Recursion implements Solution {

    private int maxP(int[] weights, int[] prices, int capacity, int cumulativeProfit, int i) {
        if (i == weights.length || capacity == 0) return cumulativeProfit;

        int selectThisProfit = 0, notSelectThisProfit = 0;
        if (weights[i] <= capacity) {
            selectThisProfit = maxP(weights, prices, capacity-weights[i], cumulativeProfit+prices[i], i+1);
        }
        notSelectThisProfit = maxP(weights, prices, capacity, cumulativeProfit, i+1);

        return Math.max(selectThisProfit, notSelectThisProfit);
    }

    @Override
    public int maxProfit(int[] weights, int[] prices, int capacity) {
        return maxP(weights, prices, capacity, 0, 0);
    }

}

class Memoization implements Solution {

    private int[][] profitBySelectAndCapacity;

    private int maxP(int[] weights, int[] prices, int capacity, int i) {
        if (i == weights.length || capacity == 0) return 0;
        if (profitBySelectAndCapacity[i][capacity] != -1) return profitBySelectAndCapacity[i][capacity];

        int selectThisProfit = 0, notSelectThisProfit = 0;
        if (weights[i] <= capacity) {
            selectThisProfit = maxP(weights, prices, capacity-weights[i], i+1) + prices[i];
        }
        notSelectThisProfit = maxP(weights, prices, capacity, i+1);

        profitBySelectAndCapacity[i][capacity] = Math.max(selectThisProfit, notSelectThisProfit);
        return profitBySelectAndCapacity[i][capacity];
    }

    @Override
    public int maxProfit(int[] weights, int[] prices, int capacity) {
        profitBySelectAndCapacity = new int[weights.length][capacity+1];
        for (int[] r: profitBySelectAndCapacity)
            Arrays.fill(r, -1);
        return maxP(weights, prices, capacity, 0);
    }

}

class Tabulation implements Solution {

    @Override
    public int maxProfit(int[] weights, int[] prices, int capacity) {
        int[][] profitByIndexAndCapacity = new int[weights.length][capacity+1];
        
        // When capacity is zero, profit is also zero
        for (int i=0; i<weights.length; i++) profitByIndexAndCapacity[i][0] = 0;

        // When index is 0, the max profit we could get is weights[i]
        for (int i=0; i<capacity+1; i++)
            if (i >= weights[0]) profitByIndexAndCapacity[0][i] = prices[0];
        
        for (int i=1; i<weights.length; i++) {
            for (int cap=1; cap<capacity+1; cap++) {
                int profit1 = profitByIndexAndCapacity[i-1][cap];
                int profit2 = (cap - weights[i] >= 0) ? prices[i] + profitByIndexAndCapacity[i-1][cap - weights[i]] : 0;
                profitByIndexAndCapacity[i][cap] = Math.max(profit1, profit2);
            }
        }

        return profitByIndexAndCapacity[weights.length-1][capacity];
    }

}

class SpaceReducedTabulation implements Solution {

    @Override
    public int maxProfit(int[] weights, int[] prices, int capacity) {
        int[] last = new int[capacity+1];
        int[] dp = new int[capacity+1];

        for (int i=0; i<capacity+1; i++)
            if (i >= weights[0]) last[i] = prices[0];
        
        for (int i=1; i<weights.length; i++) {
            for (int cap=1; cap<capacity+1; cap++) {
                int profit1 = last[cap];
                int profit2 = (cap - weights[i] >= 0) ? prices[i] + last[cap - weights[i]] : 0;
                dp[cap] = Math.max(profit1, profit2);
            }

            System.arraycopy(dp, 0, last, 0, dp.length);
        }

        return dp[capacity];
    }

}
