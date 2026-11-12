package ro.fmi.tss;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.Assert.assertEquals;

//@Disabled

public class McdcTest {

    // Decizia 1: (scores.length < 6 || scores.length > 12)
    // Cazul T1 (Lungime < 6)
    @Test
    public void testLengthLessThanSix() {
        int[] scores = {10, 20, 30, 40, 50};
        assertEquals("Vectorul nu este valid", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // Cazul T2 (Lungime > 12)
    @Test
    public void testLengthGreaterThanTwelve() {
        int[] scores = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        assertEquals("Vectorul nu este valid", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // Decizia 2: (scores[i] < 0 || scores[i] > 100)
    // Cazul T4 (Scor[i] < 0)
    @Test
    public void testScoreLessThanZero() {
        int[] scores = {10, 20, -5, 40, 50, 60};
        assertEquals("Vectorul nu este valid", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // Cazul T5 (Scor[i] > 100)
    @Test
    public void testScoreGreaterThanHundred() {
        int[] scores = {10, 20, 105, 40, 50, 60};
        assertEquals("Vectorul nu este valid", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // Decizia 3: (seqCount >= 2 && sum >= 80)
    // Cazul T3 (Cel putin 2 secvente, Suma >= 80).
    // Acopera simultan T6, T7 din primele doua decizii.
    @Test
    public void testSeqCountAndSumTrue() {
        int[] scores = {10, 20, 50, 5, 15, 30};
        assertEquals("DA", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // Cazul T8 (O singura secventa, dar suma >= 80)
    @Test
    public void testSeqCountFalseSumTrue() {
        int[] scores = {10, 20, 30, 40, 50, 90};
        assertEquals("NU", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // Cazul T9 (Cel putin 2 secvente, dar suma < 80)
    @Test
    public void testSeqCountTrueSumFalse() {
        int[] scores = {10, 20, 30, 5, 10, 20};
        assertEquals("NU", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // Decizia 4 (Simpla): (scores == null)
    // Cazul T10 (Vector null)
    @Test
    public void testVectorNull() {
        assertEquals("Vectorul nu este valid", IncreasingSequenceAnalyzer.analyze(null));
    }

    // Decizia 5 (Simpla): (len >= 3)
    // Cazul T13 (Secvențele au lungimea strict mai mică decât 3)
    @Test
    public void testSequenceLengthLessThanThree() {
        int[] scores = {10, 20, 10, 20, 10, 20};
        assertEquals("NU", IncreasingSequenceAnalyzer.analyze(scores));
    }
}