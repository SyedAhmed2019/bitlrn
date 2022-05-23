package com.bitlrn.beginner;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortArrayTest {

    @Test
    void bruteForce() {
        SortArray sa = new SortArray();
        int input[]  = new int[]{9,8,7,6,5,4,3,2,1};
        sa.bruteForce(input);
        int result[] = new int[]{1,2,3,4,5,6,7,8,9};
        assert Arrays.equals(input,result);
        assert (input.length-1)*input.length/2  == sa.getInstrumentation().getIterationCount();
        input = new int[]{5,1,1,2,0,0};
        sa.getInstrumentation().reset("secondtest");
        sa.bruteForce(input);
        assert Arrays.equals(input,new int[]{0,0,1,1,2,5});
        assert (input.length-1)*input.length/2 == sa.getInstrumentation().getIterationCount();

    }
}