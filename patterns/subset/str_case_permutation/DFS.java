package patterns.subset.str_case_permutation;

import java.util.ArrayList;
import java.util.List;

public class DFS extends Solution {

    boolean[] selected;

    @Override
    public List<String> findLetterCaseStringPermutations(String s) throws Exception {
        isValid(s);

        List<String> rst = new ArrayList<>();
        dfs(s, new StringBuilder(), rst, 0);


        return rst;
    }

    private void dfs(String s, StringBuilder buf, List<String> rst, int i) {
        if (s.length() == buf.length()) {
            rst.add(new String(buf));
            return;
        }

        char cur = s.charAt(i);
        if (Character.isLetter(cur)) {
            buf.append(Character.toLowerCase(cur));
            dfs(s, buf, rst, i+1);
            buf.deleteCharAt(buf.length()-1);

            buf.append(Character.toUpperCase(cur));
            dfs(s, buf, rst, i+1);
            buf.deleteCharAt(buf.length()-1);
        } else {
            buf.append(cur);
            dfs(s, buf, rst, i+1);
            buf.deleteCharAt(buf.length()-1);
        }
    }
    
}