
package ro.fmi.tss;

public class IncreasingSequenceAnalyzer {

    private static int getIncreasingSequenceLength(int[] scores, int start) {
        int len = 1;

        for (int i = start + 1; i < scores.length; i++) {
            if (scores[i] > scores[i - 1]) {
                len++;
            } else {
                break;
            }
        }

        return len;
    }

    public static String analyze(int[] scores) {
        if (scores == null) {
            return "Vectorul nu este valid";
        }

        if (scores.length < 6 || scores.length > 12) {
            return "Vectorul nu este valid";
        }

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 0 || scores[i] > 100) {
                return "Vectorul nu este valid";
            }
        }

        int seqCount = 0;
        int sum = 0;

        for (int start = 0; start < scores.length;) {
            int len = getIncreasingSequenceLength(scores, start);

            if (len >= 3) {
                seqCount++;
                int last = start + len - 1;
                sum += scores[last];
            }

            start += len;
        }

        if (seqCount >= 2 && sum >= 80) {
            return "DA";
        }

        return "NU";
    }
}
