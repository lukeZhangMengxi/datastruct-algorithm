package test.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionImpl implements Solution {

    public Map<String, Integer> records;
    private Map<String, Integer> firstOcur;
    private int order;

    SolutionImpl() {
        records = new HashMap<>();
        firstOcur = new HashMap<>();
        order = 0;
    }

    @Override
    public void storeError(String path) {
        
        String[] buf = path.split("\\\\");
        String fullFileNameWithLine = buf[buf.length-1];
        
        // if (records.size() == 8 && !records.containsKey(fullFileNameWithLine)) return;

        if (!records.containsKey(fullFileNameWithLine)) firstOcur.put(fullFileNameWithLine, order++);

        records.put(fullFileNameWithLine, records.getOrDefault(fullFileNameWithLine, 0)+1);
    }

    @Override
    public String showResult() {
        List<String> rst = new ArrayList<>();

        for (Map.Entry<String, Integer> e: records.entrySet()) {
            rst.add(e.getKey() + " " + e.getValue());
        }

        Collections.sort(rst, (a, b) -> {
            int countA = Integer.valueOf(a.split(" ")[2]);
            int countB = Integer.valueOf(b.split(" ")[2]);
            if (countA != countB) return countB - countA;
            else return firstOcur.get(a.split(" ")[0] + " " + a.split(" ")[1]) - firstOcur.get(b.split(" ")[0] + " " + b.split(" ")[1]);
        });

        for (int i=0; i<rst.size(); i++) {
            String[] buf = rst.get(i).split(" ");
            if (buf[0].length() > 16) {
                buf[0] = buf[0].substring(buf[0].length()-16);
                rst.set(i, String.join(" ", buf));
            }
            
        }

        return String.join(" ", rst.subList(0, 8));
    }
    
}
