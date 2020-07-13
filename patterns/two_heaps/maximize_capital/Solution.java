package patterns.two_heaps.maximize_capital;


public abstract class Solution {

    abstract public int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) throws Exception;

    protected void isValid(int[] capital, int[] profits, int numberOfProjects, int initialCapital) throws Exception {
        if (capital.length != profits.length) throw new IllegalArgumentException();
        
        for (int i=0; i<capital.length; i++) {
            if (capital[i] < 0) throw new IllegalArgumentException();
            if (profits[i] < 0) throw new IllegalArgumentException();
        }
        
        if (numberOfProjects < 0) throw new IllegalArgumentException();
        
    }
}
