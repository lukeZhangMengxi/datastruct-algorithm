package dp.shopping_combination;

import java.util.HashMap;
import java.util.Map;

interface Solution {

    public int getMaxWeightedValue(int[][] items, int budget);

}

class Recursion implements Solution {

    private boolean[] selected;

    private int recursion(int[][] items, int budget, int curMaxWeightedValue) {
        if (budget == 0) return curMaxWeightedValue;

        int maxWeightedValue = curMaxWeightedValue;
        for (int i=0; i<items.length; i++) {
            if (!selected[i] && budget - items[i][0] >= 0) {
                if (items[i][2] == 0 || selected[items[i][2]-1]) {
                    selected[i] = true;
                    maxWeightedValue = Math.max(
                        recursion(items, budget - items[i][0], curMaxWeightedValue + items[i][0]*items[i][1]),
                        maxWeightedValue
                    );
                    selected[i] = false;
                }
            }
        }

        return maxWeightedValue;
    }

    @Override
    public int getMaxWeightedValue(int[][] items, int budget) {
        selected = new boolean[items.length];
        return recursion(items, budget, 0);
    }

}

class Memoization implements Solution {

    private boolean[] selected;

    private String encodeKey(boolean[] selected, int budget) {
        StringBuilder buf = new StringBuilder();
        for (boolean v: selected) {
            buf.append(v?"s":"n");
        }
        buf.append(budget);
        return buf.toString();
    }

    private int recursion(int[][] items, int budget, int curMaxWeightedValue, Map<String, Integer> dp) {
        if (budget == 0) return curMaxWeightedValue;
        String contextKey = encodeKey(selected, budget);
        if (dp.containsKey(contextKey)) return curMaxWeightedValue + dp.get(contextKey);

        int maxWeightedValue = curMaxWeightedValue;
        for (int i=0; i<items.length; i++) {
            if (!selected[i] && budget - items[i][0] >= 0) {
                if (items[i][2] == 0 || selected[items[i][2]-1]) {
                    selected[i] = true;
                    maxWeightedValue = Math.max(
                        recursion(items, budget - items[i][0], curMaxWeightedValue + items[i][0]*items[i][1], dp),
                        maxWeightedValue
                    );
                    selected[i] = false;
                }
            }
        }

        dp.put(contextKey, maxWeightedValue - curMaxWeightedValue);
        return maxWeightedValue;
    }

    @Override
    public int getMaxWeightedValue(int[][] items, int budget) {
        selected = new boolean[items.length];
        Map<String, Integer> dp = new HashMap<>();
        return recursion(items, budget, 0, dp);
    }

}
