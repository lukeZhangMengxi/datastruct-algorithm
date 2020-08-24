package java_lang_interface.array.custom_sort.reorder_data_log;

import java.util.Arrays;

interface Solution {
    String[] reorderLogFiles(String[] logs);
}

class MS implements Solution {

    @Override
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String aBuf = a.substring(a.indexOf(" ")+1);
            String bBuf = b.substring(b.indexOf(" ")+1);
            boolean aIsLetter = Character.isLetter(aBuf.charAt(0));
            boolean bIsLetter = Character.isLetter(bBuf.charAt(0));
            if (aIsLetter && bIsLetter) {
                int tmp = aBuf.compareTo(bBuf);
                return tmp != 0 ? tmp : a.split(" ")[0].compareTo(b.split(" ")[0]);
            } else if (aIsLetter && !bIsLetter) {
                return -1;
            } else if (!aIsLetter && bIsLetter) {
                return 1;
            } else {
                return 0;
            }
        });

        return logs;
    }

}
