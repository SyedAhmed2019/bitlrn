package com.bitlrn.beginner;

import org.junit.jupiter.api.Test;

public class OddEvenCounterTest {
    @Test
    public void testCount_thenPass(){
        int count = OddEvenCounter.count(3,7, OddEvenCounter.Type.ODD);
        assert count == 3;
        count = OddEvenCounter.count(3,7, OddEvenCounter.Type.EVEN);
        assert count == 2;
        count = OddEvenCounter.count(2,8, OddEvenCounter.Type.EVEN);
        assert count == 4;
        count = OddEvenCounter.count(2,8, OddEvenCounter.Type.ODD);
        assert count == 3;
    }
}
