package com.bitlrn.hacker;

import java.util.Scanner;

/**
 * Let's play a game on an array! You're standing at index  of an -element array named . From some index  (where ), you can perform one of the following moves:
 * <p>
 * Move Backward: If cell  exists and contains a , you can walk back to cell .
 * Move Forward:
 * If cell  contains a zero, you can walk to cell .
 * If cell  contains a zero, you can jump to cell .
 * If you're standing in cell  or the value of , you can walk or jump off the end of the array and win the game.
 * In other words, you can move from index  to index , , or  as long as the destination index is a cell containing a . If the destination index is greater than , you win the game.
 * <p>
 * Function Description
 * <p>
 * Complete the canWin function in the editor below.
 * <p>
 * canWin has the following parameters:
 * <p>
 * int leap: the size of the leap
 * int game[n]: the array to traverse
 * Returns
 * <p>
 * boolean: true if the game can be won, otherwise false
 * Input Format
 * <p>
 * The first line contains an integer, , denoting the number of queries (i.e., function calls).
 * The  subsequent lines describe each query over two lines:
 * <p>
 * The first line contains two space-separated integers describing the respective values of  and .
 * The second line contains  space-separated binary integers (i.e., zeroes and ones) describing the respective values of .
 * Constraints
 * <p>
 * It is guaranteed that the value of  is always .
 * Sample Input
 * <p>
 * STDIN           Function
 * -----           --------
 * 4               q = 4 (number of queries)
 * 5 3             game[] size n = 5, leap = 3 (first query)
 * 0 0 0 0 0       game = [0, 0, 0, 0, 0]
 * 6 5             game[] size n = 6, leap = 5 (second query)
 * 0 0 0 1 1 1     . . .
 * 6 3
 * 0 0 1 1 1 0
 * 3 1
 * 0 1 0
 * Sample Output
 * <p>
 * YES
 * YES
 * NO
 * NO
 * Explanation
 * <p>
 * We perform the following  queries:
 * <p>
 * For  and , we can walk and/or jump to the end of the array because every cell contains a . Because we can win, we return true.
 * For  and , we can walk to index  and then jump  units to the end of the array. Because we can win, we return true.
 * For  and , there is no way for us to get past the three consecutive ones. Because we cannot win, we return false.
 * For  and , there is no way for us to get past the one at index . Because we cannot win, we return false.
 */

public class HrArrayGame {

    public static boolean isSolvable(int m, int[] arr, int i) {
        if (i < 0 || arr[i] == 1) return false;
        if ((i == arr.length - 1) || i + m > arr.length - 1) return true;

        arr[i] = 1;
        return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);
    }

    public static boolean canWinMoveBackwardFirst(int leap, int[] game) {
        if (game.length == 1 || leap == 0) {
            return true;
        }
        int i = 0;
        while ((i + leap) < game.length) {
            if (game[i + leap] == 0) {
                i = i + leap;
            } else if (((i - 1) > 0 && leap != 1) && game[i - 1 + leap] == 0) {
                i = i - 1;
                if (leap == 1) {
                    return false;
                }
            } else if (game[i + 1] == 0) {
                i = i + 1;
                if (i == game.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean canWinMoveFwdFirst(int leap, int[] game) {
        if (game.length == 1 || leap == 0) {
            return true;
        }
        int i = 0;
        while ((i + leap) < game.length) {
            if (game[i + leap] == 0) {
                i = i + leap;
            } else if (game[i + 1] == 0) {
                i = i + 1;
                if (i == game.length - 1) {
                    return true;
                }
            } else if (((i - 1) > 0 && leap != 1) && game[i - 1 + leap] == 0) {
                i = i - 1;
                if (leap == 1) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWinMoveFwdFirst(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
