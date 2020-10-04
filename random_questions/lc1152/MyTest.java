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
        Solution s = new BF();

        TestUtils.assertStringListEquals(
            Arrays.asList("hibympufi","hibympufi","yljmntrclw"), 
            s.mostVisitedPattern(
                new String[] {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"},
                new int[] {527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930},
                new String[] {"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"}
            )
        );
    }
}
