package dp.currency_bill_combination;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

interface Solution {
    
    public int getNumOfCombinations(int[] bills, int targetAmount);

}

class BruteForceRecursion implements Solution {

    private Set<String> resultPool;

    private void recursion(int[] bills, int targetAmount, Map<Integer, Integer> buf) {
        if (targetAmount == 0) {
            StringBuilder key = new StringBuilder();
            for (Map.Entry<Integer, Integer> e : buf.entrySet()) {
                key.append(e.getValue() + "#" + e.getKey() + ";");
            }
            resultPool.add(key.toString());
        }

        for (int bill: bills) {
            if (bill <= targetAmount) {
                buf.put(bill, buf.getOrDefault(bill, 0) + 1);

                recursion(bills, targetAmount-bill, buf);

                if (buf.get(bill) == 1) {
                    buf.remove(bill);
                } else {
                    buf.put(bill, buf.get(bill) - 1);
                }
            }
        }
    }

    @Override
    public int getNumOfCombinations(int[] bills, int targetAmount) {
        resultPool = new HashSet<>();
        recursion(bills, targetAmount, new TreeMap<>());
        return resultPool.size();
    }

}

class SimpleRecursion implements Solution {

    private int recursion(int[] bills, int targetAmount, int maxBill) {
        if (targetAmount == 0) {
            return 1;
        }

        int rst = 0;
        for (int bill: bills) {
            if (bill <= targetAmount && bill <= maxBill) {
                rst += recursion(bills, targetAmount-bill, bill);
            }
        }

        return rst;
    }

    @Override
    public int getNumOfCombinations(int[] bills, int targetAmount) {
        return recursion(bills, targetAmount, Integer.MAX_VALUE);
    }

}

class Memoization implements Solution {

    int[][] dp;

    private int recursion(int[] bills, int targetAmount, int maxBill) {
        if (targetAmount == 0) return 1;
        if (dp[targetAmount][maxBill] != -1) return dp[targetAmount][maxBill];

        int rst = 0;
        for (int bill: bills) {
            if (bill <= targetAmount && bill <= maxBill) {
                rst += recursion(bills, targetAmount-bill, bill);
            }
        }

        dp[targetAmount][maxBill] = rst;
        return rst;
    }

    @Override
    public int getNumOfCombinations(int[] bills, int targetAmount) {
        int maxBill = -1;
        for (int v: bills) if (v > maxBill) maxBill = v;

        dp = new int[targetAmount+1][maxBill+1];
        for (int[] r: dp) Arrays.fill(r, -1);

        return recursion(bills, targetAmount, maxBill);
    }

}
