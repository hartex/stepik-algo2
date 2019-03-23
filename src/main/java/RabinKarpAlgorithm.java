import java.util.*;

public class RabinKarpAlgorithm {
    private final int pDivider = (int) Math.pow(2, 15) - 1;
    private final int xBase = new Random().nextInt(pDivider);

    private final String pattern;
    private final int patternHash;
    private final int patternLength;

    private final String text;
    private final int textLength;
    private final char[] textChars;

    public RabinKarpAlgorithm(String pattern, String text) {
        this.pattern = pattern;
        this.patternHash = hash(pattern);
        this.patternLength = pattern.length();
        this.text = text;
        this.textLength = text.length();
        this.textChars = text.toCharArray();
    }

    public List<Integer> findOccurrences() {
        int[] frameHashes = buildFrameHashes();
        List<Integer> occurrences = new ArrayList<>();
        for (int i = 0; i < frameHashes.length; i++) {
            int frameHash = frameHashes[i];
            if (frameHash == patternHash) {
                if (text.substring(i, i + patternLength).equals(pattern)) {
                    occurrences.add(i);
                }
            }
        }

        return occurrences;
    }

    private int[] buildFrameHashes() {
        int[] frameHashes = new int[textLength - patternLength + 1];
        int lastFrameHash = hash(text.substring(textLength - patternLength));
        frameHashes[frameHashes.length - 1] = lastFrameHash;

        int lasSymbolExponent = pow(patternLength - 1);
        int lastSymbolHash = textChars[textLength - 1] * lasSymbolExponent % pDivider;

        for (int i = frameHashes.length - 2; i >= 0; i--) {
            int nextHash = frameHashes[i + 1];
            int hash = prevHash(nextHash, lastSymbolHash, textChars[i]);
            frameHashes[i] = hash;
            // avoiding unnecessary calculations here
            if (i != 0) {
                lastSymbolHash = textChars[i + patternLength - 1] * lasSymbolExponent % pDivider;
            }
        }
        return frameHashes;
    }

    private int prevHash(int hash, int lastSymbolHash, char firstSymbolHash) {
        return ((((hash - lastSymbolHash) * xBase + firstSymbolHash) % pDivider) + pDivider) % pDivider;
    }

    private int hash(String str) {
        char[] chars = str.toCharArray();
        int hashCode = 0;
        int prefix = 1;
        for (char aChar : chars) {
            int symbolHash = aChar * prefix % pDivider;
            hashCode = hashCode + symbolHash;
            prefix = (prefix * xBase) % pDivider;
        }
        return hashCode % pDivider;
    }

    private int pow(int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result = (result * xBase) % pDivider;
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String pattern = scanner.next();
            String text = scanner.next();
            RabinKarpAlgorithm algorithm = new RabinKarpAlgorithm(pattern, text);
            List<Integer> occurrences = algorithm.findOccurrences();
            StringJoiner joiner = new StringJoiner(" ");
            for (Integer occurrence : occurrences) {
                joiner.add(occurrence.toString());
            }
            System.out.println(joiner);
        }
    }
}
