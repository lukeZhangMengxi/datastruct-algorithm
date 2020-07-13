package patterns.two_heaps.meidum_of_number_stream;

import java.util.PriorityQueue;

public class TwoHeaps extends Solution {

	PriorityQueue<Integer> firstHalf;
	PriorityQueue<Integer> secondHalf;

	public TwoHeaps() {
		// firstHalf.peek() gives first half max
		firstHalf = new PriorityQueue<>((a, b) -> b-a);
		// secondHalf.peek() gives second half min
		secondHalf = new PriorityQueue<>((a, b) -> a-b);
	}

	@Override
	public void insertNum(int num) {
		if (firstHalf.isEmpty() || firstHalf.peek() >= num) {
			firstHalf.add(num);
		} else {
			secondHalf.add(num);
		}

		if (firstHalf.size() > secondHalf.size() + 1) {
			secondHalf.add(firstHalf.poll());
		} else if (firstHalf.size() < secondHalf.size()) {
			firstHalf.add(secondHalf.poll());
		}

	}

	@Override
	public double findMedian() {
		if (firstHalf.size() == secondHalf.size()) {
			return (firstHalf.peek() + secondHalf.peek()) / 2.0;
		} else {
			return firstHalf.peek();
		}
	}

}
