package com.bitlrn.hacker;

import java.util.Scanner;

class UsernameValidatorHelper {
    /*
     * Write regular expression here.
     */
    public static final String regularExpression = "[A-Za-z]{1,1}[\\w]{7,29}";
}


public class UserNameValidator {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            checkUserName(userName);
        }
    }

    private static void checkUserName(String userName) {
        if (userName.matches(UsernameValidatorHelper.regularExpression)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    // for testing purpose only
    public static void checkManyUserNames(String[] names) {
        for (int i = 0; i < names.length; ++i) {
            System.out.println("Checking " + names[i]);
            checkUserName(names[i]);
        }
    }

}
