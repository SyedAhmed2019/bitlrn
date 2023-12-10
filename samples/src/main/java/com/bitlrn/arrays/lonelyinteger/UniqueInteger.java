package com.bitlrn.arrays.lonelyinteger;

import java.util.*;

/**
 * Given an array of integers, where all elements but one occur twice,
 * find the unique element.
 *
 * Example
 * a = [11,12,13,14,13,12,11];
 * The unique element is 14.
 */
public class UniqueInteger {
    public static int lonelyintegerUsingMap(List<Integer> a){
        Map<Integer,Integer> checkedItems = new HashMap<>();
        int index =0;
        int currentItem = Integer.MIN_VALUE;
        for(Integer item: a){
           if(checkedItems.putIfAbsent(item,index++) != null){
               checkedItems.remove(item);
           }
        }
        for(Map.Entry<Integer,Integer>entry: checkedItems.entrySet()){
            currentItem = entry.getKey();
            break;
        }
        return currentItem;
    }
    public static void main(String[] args) {

        List<Integer> input1 = Arrays.asList(11,12,13,14,13,12,11);
        List<Integer> input2 = Arrays.asList(11,12,13,14,13,12,11,14,15);
        List<Integer> input3 = Arrays.asList(16,15,11,12,13,14,13,12,11,14,15);
        System.out.println(lonelyintegerUsingMap(input1));
        System.out.println(lonelyintegerUsingMap(input2));
        System.out.println(lonelyintegerUsingMap(input3));

    }
}
