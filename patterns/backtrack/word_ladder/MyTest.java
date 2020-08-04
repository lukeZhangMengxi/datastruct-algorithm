package patterns.backtrack.word_ladder;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MyTest {
    
    @Test
    public void simple() {
        Solution s = new DFSBacktrack();

        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList(
            "hot","dot","dog","lot","log","cog"
        );

        assertEquals(5, s.ladderLength(beginWord, endWord, wordList));
    }

    @Test
    public void largeInput() {
        Solution s = new DFSBacktrack();

        String beginWord = "qa", endWord = "sq";
        List<String> wordList = Arrays.asList(
            "si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"
        );

        assertEquals(5, s.ladderLength(beginWord, endWord, wordList));
    }

}
