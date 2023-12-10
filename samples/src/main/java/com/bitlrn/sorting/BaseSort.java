package com.bitlrn.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class BaseSort {
    protected Scanner scanner;

    BaseSort() {
        scanner = new Scanner(System.in);
    }

    List<Integer> getUnsortedItems() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        List<Integer> unsortedList = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            unsortedList.add(scanner.nextInt());
        }
        return unsortedList;
    }

    abstract protected List<Integer> sort(List<Integer> unsortedList);

    protected void display(List<Integer> list) {
        for (int i = -0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
    }
}
