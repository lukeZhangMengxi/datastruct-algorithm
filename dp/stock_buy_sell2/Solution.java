package dp.stock_buy_sell2;

import java.util.HashMap;
import java.util.Map;

interface Solution {
    int maxProfit(int[] prices);
}


class Tabulation implements Solution {

    @Override
    public int maxProfit(int[] prices) {
        Map<Integer, Integer> today = new HashMap<>();
        Map<Integer, Integer> lastday = new HashMap<>();

        for (int day=0; day<prices.length; day++) {
            today.clear();

            if (lastday.isEmpty()) {
                today.put(-1, 0);     // Not buy
                today.put(prices[day], 0);    // Buy
            } else {
                for (Map.Entry<Integer, Integer> e: lastday.entrySet()) {
                    int boughtPrice = e.getKey();
                    int total = e.getValue();

                    if (boughtPrice == -1) {
                        // Not buy
                        today.put(-1, Math.max( 
                            total,
                            today.getOrDefault(-1, Integer.MIN_VALUE)
                        ));

                        // Buy
                        today.put(prices[day], Math.max(
                            total,
                            today.getOrDefault(prices[day], Integer.MIN_VALUE)
                        ));
                    } else {
                        // Not sell
                        today.put(boughtPrice, Math.max( 
                            total,
                            today.getOrDefault(boughtPrice, Integer.MIN_VALUE)
                        ));

                        // Sell
                        if (prices[day] - boughtPrice > 0) {    // If making money
                            today.put(-1, Math.max(
                                total + prices[day] - boughtPrice,
                                today.getOrDefault(-1, Integer.MIN_VALUE)
                            ));  
                        }
                            
                    }
                }
            }
            Map<Integer, Integer> swap = lastday;
            lastday = today;
            today = swap;
        }

        int total = 0;
        for (int v : lastday.values()) {
            total = Math.max(total, v);
        }
        return total;
    }

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
