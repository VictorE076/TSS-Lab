
package ro.fmi.tss;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoundaryValueAnalysisTest {

    // A. Array length boundaries

    // T1 - Length 5
    @Test
    public void testT1() {
        int[] scores = {0, 0, 0, 0, 0};
        assertEquals("Vectorul nu este valid",
                IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T2 - Length 6
    @Test
    public void testT2() {
        int[] scores = {0, 0, 0, 0, 0, 0};
        assertEquals("NU", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T3 - Length 7
    @Test
    public void testT3() {
        int[] scores = {0, 0, 0, 0, 0, 0, 0};
        assertEquals("NU", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T4 - Length 11
    @Test
    public void testT4() {
        int[] scores = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertEquals("NU", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T5 - Length 12
    @Test
    public void testT5() {
        int[] scores = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertEquals("NU", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T6 - Length 13
    @Test
    public void testT6() {
        int[] scores = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertEquals("Vectorul nu este valid",
                IncreasingSequenceAnalyzer.analyze(scores));
    }

    // B. Lower score boundary

    // T7 - Score -1
    @Test
    public void testT7() {
        int[] scores = {-1, 20, 40, 0, 20, 40};
        assertEquals("Vectorul nu este valid",
                IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T8 - Score 0
    @Test
    public void testT8() {
        int[] scores = {0, 20, 40, 0, 20, 40};
        assertEquals("DA", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T9 - Score 1
    @Test
    public void testT9() {
        int[] scores = {1, 20, 40, 0, 20, 40};
        assertEquals("DA", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // C. Upper score boundary

    // T10 - Score 99
    @Test
    public void testT10() {
        int[] scores = {0, 20, 40, 0, 20, 99};
        assertEquals("DA", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T11 - Score 100
    @Test
    public void testT11() {
        int[] scores = {0, 20, 40, 0, 20, 100};
        assertEquals("DA", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T12 - Score 101
    @Test
    public void testT12() {
        int[] scores = {0, 20, 40, 0, 20, 101};
        assertEquals("Vectorul nu este valid",
                IncreasingSequenceAnalyzer.analyze(scores));
    }

    // D. Relevant sequence length boundaries

    // T13 - Sequence of length 2
    @Test
    public void testT13() {
        int[] scores = {0, 20, 40, 0, 40, 0};
        assertEquals("NU", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T14 - Sequence of length 4
    @Test
    public void testT14() {
        int[] scores = {0, 10, 20, 40, 0, 20, 40};
        assertEquals("DA", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // E. Relevant sequence count boundaries

    // T15 - One relevant sequence
    @Test
    public void testT15() {
        int[] scores = {0, 20, 80, 0, 0, 0};
        assertEquals("NU", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T16 - Three relevant sequences
    @Test
    public void testT16() {
        int[] scores = {0, 10, 30, 0, 10, 30, 0, 10, 30};
        assertEquals("DA", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // F. Sum threshold boundaries

    // T17 - Sum 79
    @Test
    public void testT17() {
        int[] scores = {0, 10, 39, 0, 10, 40};
        assertEquals("NU", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T18 - Sum 81
    @Test
    public void testT18() {
        int[] scores = {0, 10, 41, 0, 10, 40};
        assertEquals("DA", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // G. Strict increase boundaries

    // T19 - Difference -1
    @Test
    public void testT19() {
        int[] scores = {0, 40, 80, 0, 20, 19};
        assertEquals("NU", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T20 - Difference 0
    @Test
    public void testT20() {
        int[] scores = {0, 40, 80, 0, 20, 20};
        assertEquals("NU", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T21 - Difference 1
    @Test
    public void testT21() {
        int[] scores = {0, 40, 80, 0, 20, 21};
        assertEquals("DA", IncreasingSequenceAnalyzer.analyze(scores));
    }
}
