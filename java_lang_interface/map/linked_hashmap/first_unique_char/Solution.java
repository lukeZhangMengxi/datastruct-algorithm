package java_lang_interface.map.linked_hashmap.first_unique_char;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

interface Solution {
    int firstUniqChar(String s);    
}

class OnePassUseLinkedHashMap implements Solution {

    @Override
    @SuppressWarnings("serial")
    public int firstUniqChar(String s) {

        Map<Character, Integer> m = new LinkedHashMap<Character, Integer>() {{

            Set<Character> visited = new HashSet<>();

            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);

                if (this.containsKey(c)) this.remove(c);    // Remove it if not unique
                else if (!visited.contains(c)) this.put(c, i);  // Only store first-occurance index

                visited.add(s.charAt(i));
            }
        }};
        
        for (int index: m.values()) {
            if (index != -1) return index;
        }

        return 0;
    }

}
