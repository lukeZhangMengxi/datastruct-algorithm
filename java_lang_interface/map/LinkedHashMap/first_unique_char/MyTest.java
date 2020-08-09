package java_lang_interface.map.LinkedHashMap.first_unique_char;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void simple() {
        Solution s = new OnePassUseLinkedHashMap();

        assertEquals(0, s.firstUniqChar("leetcode"));
        assertEquals(2, s.firstUniqChar("loveleetcode"));
        assertEquals(29, s.firstUniqChar("lovqwhebkjqwbdqwluKLJWEIQWNNEOH2034J32IRPKM2JIRJD9WDKL#@$%$^%^*gdbjhqwbdxh&^**)(*)(*_+*&%$#@qwjalydgVvxbqwehqlueykhqkwjesaqwjhebqdb;ekf.neleetcodeQ"));
    }
}
