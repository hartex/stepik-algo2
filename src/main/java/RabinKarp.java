import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RabinKarp {
    private static final short BASE = 37; // X
    private static final int DIVIDER = 1_000_007; // p

    public List<Integer> findPatterns(String pattern, String text) {
        char[] textChars = text.toCharArray();
        long patternHash = hash(pattern);
        int patternLength = pattern.length();
        long[] aaa = new long[text.length() - patternLength];

        long lastOne = textChars[text.length() - 1] * pow(text.length() - 1);
        aaa[aaa.length - 1] = lastOne;

        for (int i = text.length() - 2; i >= 0; i--) {
            aaa[i+1] * pow(i)
        }

        return new ArrayList<>();
    }

    private long pow(int index) {
        long result = 1;
        for (int i = 0; i < index; i++) {
            result = (result * BASE) & DIVIDER;
        }
        return result;
    }

    private long hash(String str) {
        char[] chars = str.toCharArray();
        long hashCode = 0;
        for (int i = 0; i < chars.length; i++) {
            hashCode = (((hashCode + (chars[i] * pow(i))) % DIVIDER) + DIVIDER) % DIVIDER;
        }
        return hashCode;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        }
        System.out.println(new RabinKarp().hash("sdf"));
    }
}
