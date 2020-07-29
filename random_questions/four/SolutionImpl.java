package random_questions.four;

import java.util.ArrayList;
import java.util.List;

public class SolutionImpl implements Solution {

    private List<String> rst;

    SolutionImpl() {
        this.rst = new ArrayList<>();
    }

    @Override
    public void addString(String s) {
        if (s.length() == 0) return;

        while (s.length() % 8 != 0) s = s+"0";
        
        int idx = 0;
        while (idx <= s.length()-8) {
            rst.add(s.substring(idx, idx+8));
            idx+=8;
        }

    }

    @Override
    public List<String> getResult() {
        return rst;
    }
    
}
