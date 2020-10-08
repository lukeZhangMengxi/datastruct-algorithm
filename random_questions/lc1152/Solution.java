package random_questions.lc1152;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

interface Solution {
    public List<String> mostVisitedPattern(
        String[] username, int[] timestamp, String[] website
    );
}

@SuppressWarnings("serial")
class BF implements Solution {

    String encode(String a, String b, String c) {
        return a+"#"+b+"#"+c;
    }
    List<String> decode(String encoded) {
        return new ArrayList<>() {{
            String[] buf = encoded.split("#");
            for (String web : buf) this.add(web);
        }};
    }

    Set<String> findEncodedCombinations(List<String> raw) {
        // A user can only contribute to a sequence once, thus use set to remove duplicates
        return new HashSet<>() {{
            for (int i=0; i<raw.size(); i++) {
                for (int j=i+1; j<raw.size(); j++) {
                    for (int k=j+1; k<raw.size(); k++) {
                        this.add(encode(raw.get(i), raw.get(j), raw.get(k)));
                    }
                }
            }
        }};
    }

    @Override
    public List<String> mostVisitedPattern(
        String[] username, int[] timestamp, String[] website
    ) {
        // timestamp -> index of the three arrays
        TreeMap<Integer, Integer> timeToIndex = new TreeMap<>() {{
            for (int i=0; i<timestamp.length; i++) this.put(timestamp[i], i);
        }};

        // user -> list_sorted_by_time<website>
        Map<String, List<String>> userToSortedWebs = new HashMap<>() {{
            while (!timeToIndex.isEmpty()) {
                int index = timeToIndex.pollFirstEntry().getValue();
                if (!this.containsKey(username[index])) {
                    this.put(username[index], new ArrayList<>());
                }
                this.get(username[index]).add(website[index]);
            }
        }};

        // encoded_webstie_esquences -> number of users
        Map<String, Integer> sequenceToNumber = new HashMap<>() {{
            for (List<String> webs: userToSortedWebs.values()) {
                Set<String> sequences = findEncodedCombinations(webs);
                for (String seq: sequences) {
                    this.put(seq, this.getOrDefault(seq, 0) + 1);
                }
            }
        }};

        String max = "";
        int maxNum = -1;
        for (Map.Entry<String, Integer> e : sequenceToNumber.entrySet()) {
            if (
                ( e.getValue() > maxNum ) ||
                ( e.getValue() == maxNum && e.getKey().compareTo(max) < 0 )
            ) {
                max = e.getKey();
                maxNum = e.getValue();
            }
        }
        return decode(max);
    }

}
