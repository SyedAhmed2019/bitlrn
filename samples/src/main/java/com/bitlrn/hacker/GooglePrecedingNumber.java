package com.bitlrn.hacker;

/**
 * Give a positive sorted array a = [3,4,6,9.10.12,14,15,17,
 * 19,21] Define a function f(a,x) that returns x,
 * the next smallest number, or -1 for errors
 * i.e.
 * f(a,12) = 12
 * f(a,13) = 12
 */
public class GooglePrecedingNumber {
    public static int preceding(int[] a, int x) {
        if (a == null) {
            System.out.println("Invalid input");
            return -1;
        }
        if (a.length == 0) {
            return -1;
        }
        if (x < a[0]) {
            return -1;
        }
        int delta = x - a[0];
        for (int i = 1; i < a.length; ++i) {
            if (x - a[i] <= delta) {
                if (x - a[i] >= 0) {
                    delta = x - a[i];
                } else {
                    break;
                }
            }
        }
        return x - delta;
    }

    public static int precedingLogN(int[] a, int x) {
        if (a == null) {
            System.out.println("Invalid input");
            return -1;
        }
        if (x < a[0]) {
            return -1;
        }
        //let's take low and high markers
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (x > a[mid]) {
                if (a[mid + 1] < x) {
                    low = mid + 1;
                    if (low == a.length - 1) {
                        return a[low];
                    }
                } else {
                    if (a[mid + 1] == x) {
                        return a[mid + 1];
                    } else {
                        return a[mid];
                    }
                }
            } else if (x == a[mid]) {
                return a[mid];
            } else {
                if (a[mid - 1] >= x) {
                    high = mid - 1;
                } else {
                    return a[mid];
                }
            }
        }
        return -1;
    }

    public static int precedingLogNBest(int[] a, int x) {
        if (a == null) {
            System.out.println("Invalid input");
            return -1;
        }
        int answer = -1;
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (int) (low + Math.floor(high - low / 2));
            if (a[mid] == x) {
                return x;
            } else if (a[mid] < x) {
                answer = a[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // negative condition 0.
        int[] a = new int[1];
        System.out.println(preceding(a, 1));
        // negative condition 1.
        a = new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21};
        usePreceding(a);
        usePrecedingLogN(a);
        usePrecdingLogNBest(a);
    }

    private static void usePrecdingLogNBest(int[] a) {
        System.out.println(precedingLogNBest(a, 12));
        System.out.println(precedingLogNBest(a, 13));
        System.out.println(precedingLogNBest(a, 2));
        System.out.println(precedingLogNBest(a, 22));
        System.out.println(precedingLogNBest(a, 3));
        System.out.println(precedingLogNBest(a, 21));
        System.out.println(precedingLogNBest(new int[1], 21));
        System.out.println(precedingLogNBest(null, 21));
    }


    private static void usePreceding(int[] a) {
        System.out.println(preceding(a, 12));
        System.out.println(preceding(a, 13));
        System.out.println(preceding(a, 2));
        System.out.println(preceding(a, 22));
        System.out.println(preceding(a, 3));
        System.out.println(preceding(a, 21));
        System.out.println(preceding(new int[1], 21));
        System.out.println(preceding(null, 21));
    }

    private static void usePrecedingLogN(int[] a) {
        System.out.println(precedingLogN(a, 12));
        System.out.println(precedingLogN(a, 13));
        System.out.println(precedingLogN(a, 2));
        System.out.println(precedingLogN(a, 22));
        System.out.println(precedingLogN(a, 3));
        System.out.println(precedingLogN(a, 21));
        System.out.println(precedingLogN(new int[1], 21));
        System.out.println(precedingLogN(null, 21));
    }
}
