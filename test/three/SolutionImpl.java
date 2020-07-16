package test.three;

public class SolutionImpl implements Solution {

    private enum HandType {
        DOUBLE,
        TRIPPLE,
        SEQUENCE,
        BOMB,
        TWO_KING
    }

    private class Hand {
        private int val;
        private HandType type;

        private int convert(String val) {
            String buf = val.toUpperCase();
            if (buf.compareTo("3") == 0) return 3;
            if (buf.compareTo("4") == 0) return 4;
            if (buf.compareTo("5") == 0) return 5;
            if (buf.compareTo("6") == 0) return 6;
            if (buf.compareTo("7") == 0) return 7;
            if (buf.compareTo("8") == 0) return 8;
            if (buf.compareTo("9") == 0) return 9;
            if (buf.compareTo("10") == 0) return 10;
            if (buf.compareTo("J") == 0) return 11;
            if (buf.compareTo("Q") == 0) return 12;
            if (buf.compareTo("K") == 0) return 13;
            if (buf.compareTo("A") == 0) return 14;
            if (buf.compareTo("2") == 0) return 15;
            if (buf.compareTo("JOKER") == 0) return 16;
            return -1;
        }

        private Boolean isLarger(Hand another) {
            if (this.type == another.type) {
                return this.val > another.val;
            } else if (another.type == HandType.TWO_KING) {
                return false;
            } else if (this.type == HandType.TWO_KING || this.type == HandType.BOMB) {
                return true;
            }else if (another.type == HandType.BOMB) {
                return false;
            }  else {
                return null;
            }
        }

        Hand(String hand) {
            String[] buf = hand.split(" ");
            switch(buf.length) {
                case 2: this.type = convert(buf[0]) == 16 ? HandType.TWO_KING : HandType.DOUBLE; break; 
                case 3: this.type = HandType.TRIPPLE; break;
                case 4: this.type = HandType.BOMB; break;
                case 5: this.type = HandType.SEQUENCE; break;
            }
            this.val = convert(buf[0]);
        }
    }

    @Override
    public String getLarger(String twoHands) {

        String[] buf = twoHands.split("-");
        
        Hand left = new Hand(buf[0]);
        Hand right = new Hand(buf[1]);

        Boolean cmp = left.isLarger(right);

        if (cmp == null) return "ERROR";
        else if (cmp) return buf[0];
        else return buf[1];
    }
    
}