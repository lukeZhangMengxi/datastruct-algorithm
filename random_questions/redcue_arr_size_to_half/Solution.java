package random_questions.redcue_arr_size_to_half;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Solution {
    // So that at least half of the integers of the array are removed.
    int minSetSize(int[] arr);
}

class MySolution implements Solution {

    @Override
    @SuppressWarnings("serial")
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>(){{
            for (int v: arr) this.put(v, this.getOrDefault(v, 0) + 1);
        }};
        List<Integer> buf = new ArrayList<>() {{
            for (int v:freq.keySet()) this.add(v);
            Collections.sort(this, (a, b) -> freq.get(b) - freq.get(a));
        }};
        
        int numRemoved = 0, rst = 0;
        int bar = (arr.length%2==0) ? arr.length/2 : arr.length/2+1;
        while (numRemoved < bar) {
            numRemoved += freq.get(buf.get(rst));
            rst++;
        }
        
        return rst;
    }

}
