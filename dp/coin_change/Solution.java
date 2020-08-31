package dp.coin_change;

import java.util.Arrays;

interface Solution {
    int coinChange(int[] coins, int amount);
}

class BetterMEM implements Solution {

    int dfs(int[] sortedCoins, int amount, Integer[] dp) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (dp[amount] != null) return dp[amount];

        int result = -1;
        for (int i=sortedCoins.length-1; i>=0; i--) {
            int tmp = dfs(sortedCoins, amount-sortedCoins[i], dp);
            if (tmp != -1) {
                result = (result==-1) ? tmp + 1 : Math.min(result, tmp + 1);
            }
        }

        dp[amount] = result;
        return result;
    }

    @Override
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return dfs(coins, amount, new Integer[amount+1]);
    }

}

class BadMEM implements Solution {

    int dfs(int[] sortedCoins, int amount, int buf, Integer[][] dp) {
        if (amount == 0) return buf;
        if (amount < 0) return -1;
        if (dp[amount][buf] != null) return dp[amount][buf];

        int result = -1;
        for (int i=sortedCoins.length-1; i>=0; i--) {
            int tmp = dfs(sortedCoins, amount-sortedCoins[i], buf+1, dp);
            if (tmp != -1) result = (result==-1) ? tmp: Math.min(result, tmp);
        }

        dp[amount][buf] = result;
        return result;
    }

    @Override
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return dfs(coins, amount, 0, new Integer[amount+1][amount/coins[0]+1]);
    }

}

class BF implements Solution {

    int dfs(int[] sortedCoins, int amount, int buf) {
        if (amount == 0) return buf;
        if (amount < 0) return -1;

        int result = -1;
        for (int i=sortedCoins.length-1; i>=0; i--) {
            int tmp = dfs(sortedCoins, amount-sortedCoins[i], buf+1);
            if (tmp != -1) result = (result==-1) ? tmp: Math.min(result, tmp);
        }

        return result;
    }

    @Override
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return dfs(coins, amount, 0);
    }

}
