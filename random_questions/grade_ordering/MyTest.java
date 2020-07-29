package random_questions.grade_ordering;

import java.util.List;

import org.junit.Test;

public class MyTest {
    @Test
    public void simple() {
        Solution s = new MySolution(false);
        s.insert("fang", 90);
        s.insert("yang", 50);
        s.insert("ning", 70);

        String[] expected = new String[] {
            "fang 90", "ning 70", "yang 50"
        };

        List<String> out = s.show();
        for (int i=0; i<out.size(); i++)
            assert(out.get(i).compareTo(expected[i]) == 0);
    }

    @Test
    public void simple2() {
        Solution s = new MySolution(true);
        s.insert("fang", 90);
        s.insert("yang", 50);
        s.insert("ning", 70);

        String[] expected = new String[] {
            "yang 50", "ning 70", "fang 90"
        };

        List<String> out = s.show();
        for (int i=0; i<out.size(); i++)
            assert(out.get(i).compareTo(expected[i]) == 0);
    }

    @Test
    public void fail1() {
        String[] inputs = new String[] {
            "qhsq 15","ozslg 79","ncttmtsphb 71","a 39","eeiuyzsj 34","nmlrokx 21","pjizylo 90","ec 45","f 12","sh 31","fm 25","ptprphubqk 29","wxdiwv 0","uhlcpjtxad 60","w 20","zwktbpun 70","efzfkf 69","v 31","rsnrgtl 73","lhdo 76","wt 56","mcdwd 14","ydrnoyd 37","gmlfds 76","zx 1","dqx 98","gz 90","kvbzrwrrjj 13"
        };

        Solution s = new MySolution(true);
        for (String in: inputs) {
            s.insert(in.split(" ")[0], Integer.parseInt(in.split(" ")[1]));
        }
        String a = String.join("", s.show());
        assert(
            a.compareTo("wxdiwv 0zx 1f 12kvbzrwrrjj 13mcdwd 14qhsq 15w 20nmlrokx 21fm 25ptprphubqk 29sh 31v 31eeiuyzsj 34ydrnoyd 37a 39ec 45wt 56uhlcpjtxad 60efzfkf 69zwktbpun 70ncttmtsphb 71rsnrgtl 73lhdo 76gmlfds 76ozslg 79pjizylo 90gz 90dqx 98") == 0
        );
    }
}