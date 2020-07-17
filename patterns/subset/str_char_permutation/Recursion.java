package patterns.subset.str_char_permutation;

import java.util.ArrayList;
import java.util.List;

public class Recursion extends Solution {

    @Override
    public List<String> findStringPermutations(String s) throws Exception {
        
        return helper(s);
    }

    private List<String> helper(String s) {
        List<String> rst = new ArrayList<>();

        if (s.length() == 1) {
            rst.add(s);
            return rst;
        }

        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            List<String> subPermutation = helper(s.substring(0, i) + s.substring(i+1));
            for (String p: subPermutation) {
                rst.add(cur + p);
            }
        }
        return rst;
    }
    
}
