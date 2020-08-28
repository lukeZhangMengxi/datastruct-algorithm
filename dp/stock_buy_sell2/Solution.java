package dp.stock_buy_sell2;

import java.util.HashMap;
import java.util.Map;

interface Solution {
    int maxProfit(int[] prices);
}

class Memoization implements Solution {

    String encode(int day, int boughtPrice) {
        return day + "#" + boughtPrice;
    }

    int dfs(int[] prices, int day, int boughtPrice, Map<String, Integer> dp) {
        if (day == prices.length) return 0;
        String key = encode(day, boughtPrice);
        if (dp.containsKey(key)) return dp.get(key);

        int rst = 0;
        if (boughtPrice == -1) {
            // Try buy
            rst = dfs(prices, day+1, prices[day], dp) - prices[day];
        } else {
            // Try sell
            rst = dfs(prices, day+1, -1, dp) + prices[day];
        }

        // Also try skip
        dp.put(key, Math.max(rst, dfs(prices, day+1, boughtPrice, dp)));

        return dp.get(key);
    }

    @Override
    public int maxProfit(int[] prices) {
        return dfs(prices, 0, -1, new HashMap<String, Integer>());
    }

}

class BruteForceDFS implements Solution {

    int dfs(int[] prices, int day, int boughtPrice) {
        if (day == prices.length) return 0;

        int rst = 0;
        if (boughtPrice == -1) {
            // Try buy
            rst = dfs(prices, day+1, prices[day]) - prices[day];
        } else {
            // Try sell
            rst = dfs(prices, day+1, -1) + prices[day];
        }

        // Also try skip
        return Math.max(rst, dfs(prices, day+1, boughtPrice));
    }

    @Override
    public int maxProfit(int[] prices) {
        return dfs(prices, 0, -1);
    }

}
