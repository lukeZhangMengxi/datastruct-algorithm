package patterns.xor.single_from_doube_nums;

import java.util.HashMap;
import java.util.Map;

interface Solution {
    int findSingleNumber(int[] arr);
}

class UseMap implements Solution {

    @Override
    @SuppressWarnings("serial")
    public int findSingleNumber(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>() {{
            for (int v: arr) this.put(v, this.getOrDefault(v, 0)+1);
        }};

        for (Map.Entry<Integer, Integer> e: freq.entrySet()) {
            if (e.getValue() == 1) return e.getKey();
        }

        return -1;
    }

}

class UseXor implements Solution {

    @Override
    public int findSingleNumber(int[] arr) {
        int xorResult = 0;
        for (int v: arr) xorResult ^= v;
        return xorResult;
    }

}
