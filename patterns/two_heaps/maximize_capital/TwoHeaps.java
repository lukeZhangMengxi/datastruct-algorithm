package patterns.two_heaps.maximize_capital;

import java.util.PriorityQueue;

public class TwoHeaps extends Solution {

    @Override
    public int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) throws Exception {
        isValid(capital, profits, numberOfProjects, initialCapital);

        int n = profits.length;
        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n, (i1, i2) -> capital[i1] - capital[i2]);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n, (i1, i2) -> profits[i2] - profits[i1]);

        for (int i = 0; i < n; i++)
            minCapitalHeap.offer(i);

        int availableCapital = initialCapital;
        for (int i = 0; i < numberOfProjects; i++) {
            
            while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= availableCapital)
                maxProfitHeap.add(minCapitalHeap.poll());

            if (maxProfitHeap.isEmpty())
                break;

            availableCapital += profits[maxProfitHeap.poll()];
        }

        return availableCapital;
    }
    
}
