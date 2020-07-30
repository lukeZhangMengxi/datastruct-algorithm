package java_lang_interface.map.computeIfAbsent.random_pick_index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

interface Solution {
    void init(int[] arr);
    int pick(int target);    
}

class ConstructMapOfCollection implements Solution {

    private final Random rnd = new Random();
    private Map<Integer, List<Integer>> index;

    @Override
    @SuppressWarnings("serial")
    public void init(int[] arr) {
        index = new HashMap<>() {{
            for (int i = 0; i < arr.length; i++) {
                // if (!this.containsKey(arr[i])) 
                //      this.put(arr[i], new new ArrayList<>())
                // this.get(arr[i]).add(i)
                this.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
            }
        }};
    }

    @Override
    public int pick(int target) {
        List<Integer> buf = index.get(target);
        return buf.get(rnd.nextInt(buf.size()));
    }

}
