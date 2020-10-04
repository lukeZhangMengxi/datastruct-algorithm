package random_questions.lc1152;

import java.util.Arrays;

import org.junit.Test;

import lib.TestUtils;

public class MyTest {
    @Test
    public void simple() {
        Solution s = new BF();

        TestUtils.assertStringListEquals(
            Arrays.asList("home","about","career"), 
            s.mostVisitedPattern(
                new String[] {"joe","joe","joe","james","james","james","james","mary","mary","mary"},
                new int[] {1,2,3,4,5,6,7,8,9,10},
                new String[] {"home","about","career","home","cart","maps","home","home","about","career"}
            )
        );

        TestUtils.assertStringListEquals(
            Arrays.asList("oz","mryxsjc","wlarkzzqht"), 
            s.mostVisitedPattern(
                new String[] {"zkiikgv","zkiikgv","zkiikgv","zkiikgv"},
                new int[] {436363475,710406388,386655081,797150921},
                new String[] {"wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"}
            )
        );
    }

    @Test
    public void failure1() {
        // A user can only contribute to a sequence once
        Solution s = new BF();

        TestUtils.assertStringListEquals(
            Arrays.asList("hibympufi","hibympufi","yljmntrclw"), 
            s.mostVisitedPattern(
                new String[] {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"},
                new int[] {
                    527896567,  // h, hibympufi
                    334462937,  // eiy, hibympufi
                    517687281,  // cq, hibympufi
                    134127993,  // h, hibympufi
                    859112386,  // cq, hibympufi
                    159548699,  // txldsscx, hibympufi
                    51100299,  // cq, hibympufi
                    444082139,  // txldsscx, hibympufi
                    926837079,  // h, yljmntrclw
                    317455832,  // cq, hibympufi
                    411747930},  // cq, yljmntrclw
                new String[] {"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"}
            )
        );
    }
}
