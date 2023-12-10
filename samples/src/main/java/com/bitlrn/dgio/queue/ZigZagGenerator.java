package com.bitlrn.dgio.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagGenerator {

    private final Queue<Integer> queueFirst;

    private ZigZagGenerator() {
        queueFirst = new LinkedList<>();
    }

    public ZigZagGenerator(List<Integer> v1, List<Integer> v2) {
        queueFirst = new LinkedList<>();
        boolean toggle = true;
        int v1Index = 0;
        int v2Index = 0;
        while (!(v1Index == v1.size()) || !(v2Index == v2.size())) {
            if (!(v1Index == v1.size())) {
                queueFirst.add(v1.get(v1Index++));
            }
            if (!(v2Index == v2.size())) {
                queueFirst.add(v2.get(v2Index++));
            }
        }
    }

    public static void main(String[] args) {
        ZigZagGenerator zzg = new ZigZagGenerator(List.of(1, 2, 3), List.of(4, 5, 6));
        while (zzg.hasNext()) {
            System.out.println(zzg.next());
        }
    }

    public int next() {
        if (!queueFirst.isEmpty()) {
            return queueFirst.poll();
        }
        return -1;
    }

    public boolean hasNext() {
        return !queueFirst.isEmpty();
    }
}
