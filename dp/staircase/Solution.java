package dp.staircase;

interface Solution {
    
    public int getCombination(int numOfStairs, int stepRange);

}

class Recursion implements Solution {

    @Override
    public int getCombination(int numOfStairs, int stepRange) {
        if (numOfStairs == 0) return 1;
        
        int ways = 0;
        for (int i=1; i<=stepRange; i++) {
            if (i <= numOfStairs) {
                ways += getCombination(numOfStairs-i, stepRange);
            }
        }

        return ways;
    }

}

class Memoization implements Solution {

    int[] combinations;

    private int compute(int numOfStairs, int stepRange) {
        if (combinations[numOfStairs] != 0) return combinations[numOfStairs];

        int ways = 0;
        for (int i=1; i<=stepRange; i++) {
            if (i <= numOfStairs) {
                ways += compute(numOfStairs-i, stepRange);
            }
        }

        combinations[numOfStairs] = ways;
        return ways;
    }

    @Override
    public int getCombination(int numOfStairs, int stepRange) {
        combinations = new int[numOfStairs+1];
        combinations[0] = 1;
        return compute(numOfStairs, stepRange);
    }

}
