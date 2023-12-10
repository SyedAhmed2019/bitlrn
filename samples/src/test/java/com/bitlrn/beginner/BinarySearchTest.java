package com.bitlrn.beginner;

import org.junit.jupiter.api.Test;

class BinarySearchTest {
    @Test
    void findElement_found_in_array_thenPass() {
        BinarySearch bis = new BinarySearch();
        int []input = new int[]{1,2,3,4,5};
        bis.getInstrumentation().reset("findElementRecursive");
        int pos = bis.findElementRecursive(input,0,4, 4);
        assert pos==3;
        assert Math.round(Math.log(5)) == bis.getInstrumentation().getIterationCount();
        bis.getInstrumentation().reset("findElementNonRecursive");
        pos = bis.findElementNonRecursive(input,4);
        assert pos==3;
        assert Math.round(Math.log(5)) == bis.getInstrumentation().getIterationCount();
        input = new int[]{1,2,3,4,5,6};
        pos = bis.findElementRecursive(input,0,5, 4);
        assert pos==3;
        pos = bis.findElementNonRecursive(input,4);
        assert pos==3;
    }

    @Test
    void findElement_not_found_in_array_thenPass() {
        BinarySearch bis = new BinarySearch();
        int []input = new int[]{1,2,3,4,5};
        bis.getInstrumentation().reset("findElementRecursive");
        int pos = bis.findElementRecursive(input,0,4, 6);
        assert pos==-1;
        assert Math.log(5)==bis.getInstrumentation().getIterationCount();
        pos = bis.findElementNonRecursive(input,6);
        assert pos==-1;
        input = new int[]{1,2,3,4,5,6};
        pos = bis.findElementRecursive(input,0,5, 0);
        assert pos==-1;
        pos = bis.findElementNonRecursive(input,0);
        assert pos==-1;
    }

    @Test
    void findElement_found_at_0_pos_or_max_pos_thenPass() {
        BinarySearch bis = new BinarySearch();
        int []input = new int[]{1,2,3,4,5};
        int pos = bis.findElementRecursive(input,0,4, 1);
        assert pos==0;
        pos = bis.findElementNonRecursive(input,1);
        assert pos==0;
        input = new int[]{1,2,3,4,5,6};
        pos = bis.findElementRecursive(input,0,5, 6);
        assert pos==5;
        pos = bis.findElementNonRecursive(input,6);
        assert pos==5;

    }

    @Test
    void findElement_in_empty_array_thenPass() {
        BinarySearch bis = new BinarySearch();
        int []input = new int[]{};
        int pos = bis.findElementRecursive(input,0,input.length-1, 4);
        assert pos==-1;
        pos = bis.findElementNonRecursive(input,4);
        assert pos==-1;
    }

    @Test
    void findElement_non_existent_using_Iterative(){
        BinarySearch bis = new BinarySearch();
        bis.findElementIterative(new int[]{-1,0,3,5,9,12},2);
    }
}