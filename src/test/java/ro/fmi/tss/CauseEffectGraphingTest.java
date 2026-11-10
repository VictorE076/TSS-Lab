
package ro.fmi.tss;

//import org.junit.Test;

//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.runner.RunWith;
//
//import static org.junit.Assert.assertEquals;
//
//@Disabled
//@RunWith(JUnitPlatform.class)

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CauseEffectGraphingTest {

    // T1 - R1: Null vector (C1 = false)
    @Test
    public void testT1() {
        assertEquals("Vectorul nu este valid",
                IncreasingSequenceAnalyzer.analyze(null));
    }

    // T2 - R2: Length below 6 (C2 = false)
    @Test
    public void testT2() {
        int[] scores = {1, 2, 3, 4};

        assertEquals("Vectorul nu este valid",
                IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T3 - R3: Length above 12 (C3 = false)
    @Test
    public void testT3() {
        int[] scores = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        assertEquals("Vectorul nu este valid",
                IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T4 - R4: Negative score (C4 = false)
    @Test
    public void testT4() {
        int[] scores = {5, 10, 20, 0, -1, 40};

        assertEquals("Vectorul nu este valid",
                IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T5 - R5: Score above 100 (C5 = false)
    @Test
    public void testT5() {
        int[] scores = {0, 20, 40, 0, 20, 101};

        assertEquals("Vectorul nu este valid",
                IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T6 - R6: C6 = true, C7 = true
    @Test
    public void testT6() {
        int[] scores = {0, 10, 30, 0, 10, 30, 0, 10, 30};

        assertEquals("DA",
                IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T7 - R7: C6 = true, C7 = false
    @Test
    public void testT7() {
        int[] scores = {0, 10, 35, 0, 10, 44};

        assertEquals("NU",
                IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T8 - R8: C6 = false, C7 = true
    @Test
    public void testT8() {
        int[] scores = {10, 20, 100, 90, 80, 70};

        assertEquals("NU",
                IncreasingSequenceAnalyzer.analyze(scores));
    }

    // T9 - R9: C6 = false, C7 = false
    @Test
    public void testT9() {
        int[] scores = {40, 40, 40, 40, 40, 40};

        assertEquals("NU",
                IncreasingSequenceAnalyzer.analyze(scores));
    }
}
