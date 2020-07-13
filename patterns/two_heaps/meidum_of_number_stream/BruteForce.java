package patterns.two_heaps.meidum_of_number_stream;

import java.util.LinkedList;
import java.util.List;

public class BruteForce extends Solution {

	List<Integer> storage;

	public BruteForce() {
		this.storage = new LinkedList<>();
	}

	@Override
	public void insertNum(int num) {
		if (storage.size() == 0) {
			storage.add(num);
			return;
		}

		int insertIdx = 0;
		while (insertIdx < storage.size() && storage.get(insertIdx) < num)
			insertIdx++;
		
		storage.add(insertIdx, num);
	}

	@Override
	public double findMedian() {
		int len = storage.size();
		if (len % 2 == 0) {
			return (storage.get(len/2-1) + storage.get(len/2)) / 2.0;
		} else {
			return storage.get(len/2);
		}
	}
  
}
