
package ro.fmi.tss;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EquivalencePartitioningTest {

    // T1 - C1: Valid input, both conditions satisfied
    @Test
    public void testC1() {
        int[] scores = {10, 30, 50, 0, 20, 70};

        assertEquals("DA", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T2 - C2: Two sequences, sum below 80
    @Test
    public void testC2() {
        int[] scores = {10, 20, 30, 0, 10, 40};

        assertEquals("NU", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T3 - C3: One sequence, sum at least 80
    @Test
    public void testC3() {
        int[] scores = {10, 20, 90, 80, 70, 60};

        assertEquals("NU", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T4 - C4: No relevant increasing sequences
    @Test
    public void testC4() {
        int[] scores = {0, 0, 0, 0, 0, 0};

        assertEquals("NU", IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T5 - C5: Null input
    @Test
    public void testC5() {
        assertEquals(
                "Vectorul nu este valid",
                IncreasingSequenceAnalyzer.analyze(null)
        );
    }

    // T6 - C6: Length below 6
    @Test
    public void testC6() {
        int[] scores = {10, 20, 30, 0, 20};

        assertEquals(
                "Vectorul nu este valid",
                IncreasingSequenceAnalyzer.analyze(scores)
        );
    }

    // T7 - C7: Length above 12
    @Test
    public void testC7() {
        int[] scores = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        assertEquals(
                "Vectorul nu este valid",
                IncreasingSequenceAnalyzer.analyze(scores)
        );
    }

    // T8 - C8: Negative score
    @Test
    public void testC8() {
        int[] scores = {10, 30, 50, 0, 20, -1};

        assertEquals(
                "Vectorul nu este valid",
                IncreasingSequenceAnalyzer.analyze(scores)
        );
    }

    // T9 - C9: Score above 100
    @Test
    public void testC9() {
        int[] scores = {10, 30, 50, 0, 20, 101};

        assertEquals(
                "Vectorul nu este valid",
                IncreasingSequenceAnalyzer.analyze(scores)
        );
    }
}
