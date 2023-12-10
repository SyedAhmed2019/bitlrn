package com.bitlrn.hacker;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you this feature. Try to solve this problem using Arraylist.
 * <p>
 * You are given  lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in  position of  line.
 * <p>
 * Take your input from System.in.
 * <p>
 * Input Format
 * The first line has an integer . In each of the next  lines there will be an integer  denoting number of integers on that line and then there will be  space-separated integers. In the next line there will be an integer  denoting number of queries. Each query will consist of two integers  and .
 * <p>
 * Constraints
 * <p>
 * Each number will fit in signed integer.
 * Total number of integers in  lines will not cross .
 * <p>
 * Output Format
 * In each line, output the number located in  position of  line. If there is no such position, just print "ERROR!"
 * <input>
 * 5
 * 5 41 77 74 22 44
 * 1 12
 * 4 37 34 36 52
 * 0
 * 3 20 22 33
 * 5
 * 1 3
 * 3 4
 * 3 1
 * 4 3
 * 5 5
 * </input>
 *
 * <output>
 * 74
 * 52
 * 37
 * ERROR!
 * ERROR!
 * </output>
 */

public class HrArrayList {
    public static void main2(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfLists = scanner.nextInt();
        List<List<Integer>> listOfLists = new ArrayList<>();
        while (sizeOfLists-- >= 0) {
            String s = scanner.nextLine();
            s.trim();
            s = s.replace("//s+", "");
            String[] stringLists = s.split(" ");
            List<Integer> lists = new ArrayList<>();
            for (String item : stringLists) {
                if (!item.isEmpty()) {
                    lists.add(Integer.parseInt(item));
                }
            }
            if (!lists.isEmpty()) {
                listOfLists.add(lists);
            }
        }
        // here we take the query input
        int numberOfQueries = scanner.nextInt();
        StringBuffer stringBuffer = new StringBuffer();
        while (numberOfQueries-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine();
            if (x > (listOfLists.size() - 1)) {
                stringBuffer.append("ERROR!");
                stringBuffer.append("\n");
                continue;
            }
            if (y > (listOfLists.get(x - 1).size() - 1)) {
                stringBuffer.append("ERROR!");
                stringBuffer.append("\n");
                continue;
            }
            stringBuffer.append(listOfLists.get(x - 1).get(y));
            stringBuffer.append("\n");
        }
        scanner.close();
        System.out.println(stringBuffer.toString().trim());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        //Save numbers in two dimension list
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = scan.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                list.add(scan.nextInt());
            }
            lists.add(list);
        }

        // handle queries
        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            List<Integer> list = lists.get(x - 1);
            if (y <= list.size()) {
                System.out.println(list.get(y - 1));
            } else {
                System.out.println("ERROR!");
            }
        }

        scan.close();
    }
}
