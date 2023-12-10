package com.bitlrn.dgio.arrays;


import java.util.LinkedList;
import java.util.List;

public class ConferenceRoomOptimizer {
    public static void main(String[] args) {
        ConferenceRoomOptimizer cro = new ConferenceRoomOptimizer();
      /*  for(Interval interval: cro.merge(List.of(new Interval(1,5),new Interval(2,6)))){
            System.out.println("["+interval.start+","+interval.end+"]");
        }*/
        for (Interval interval : cro.merge(List.of(new Interval(1, 2), new Interval(2, 3), new Interval(5, 6), new Interval(4, 8)))) {
            System.out.println("[" + interval.start + "," + interval.end + "]");
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        int[] hour24 = new int[24];
        for (int i : hour24) {
            hour24[i] = 0;
        }
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            int low = interval.start;
            int high = interval.end;
            for (int i = low; i <= high; ++i) {
                hour24[i] = 1;
            }
        }
        Interval interval = null;
        int nextHour = -1;
        for (int i = 0; i < 24; ++i) {
            if (hour24[i] == 1) {
                if (interval == null) {
                    interval = new Interval(i, i + 1);
                    nextHour = i + 1;
                } else {
                    if (nextHour == i && nextHour == interval.end) {
                        interval.end++;
                        nextHour = i + 1;
                    }
                }
            } else {
                if (interval != null) {
                    mergedIntervals.add(new Interval(interval.start, --interval.end));
                    interval = null;
                }
            }
        }
        return mergedIntervals;
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
