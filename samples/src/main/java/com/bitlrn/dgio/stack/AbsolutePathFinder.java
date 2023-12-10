package com.bitlrn.dgio.stack;


/**
 * Given an absolute file path in a Unix-style file system, simplify it by converting
 * ".." to the previous directory and removing any "." or multiple slashes.
 * The resulting string should represent the shortest absolute path.
 */

/*
/a/b//c//
/a/b//c//../, /..//c/b/a/
 */

public class AbsolutePathFinder {
    public static String simplifyPath(String path) {
        // a  b    c  d  .  .   ..
        Stack<String> result = new Stack<>(path.length());
        for (String current : path.split("/")) {
            if (current.equals("..")) {
                if (!result.isEmpty()) {
                    result.pop();
                }
            } else if (!current.isEmpty() && !current.equals(".")) {
                result.push(current);
            }
        }
        Stack<String> toReverse = new Stack<>(path.length());
        while (!result.isEmpty()) {
            toReverse.push(result.pop());
        }
        StringBuilder absolute = new StringBuilder();
        while (!toReverse.isEmpty()) {
            absolute.append("/");
            absolute.append(toReverse.pop());
        }
        return absolute.isEmpty() ? "/" : absolute.toString();
    }

    private static boolean isAlphaNumberCharacter(char c) {
        for (int init = 'a'; init <= 'z'; ++init) {
            if (c == init) {
                return true;
            }
        }

        for (int init = 'A'; init <= 'Z'; ++init) {
            if (c == init) {
                return true;
            }
        }

        for (int init = '0'; init <= '9'; ++init) {
            if (c == init) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String result = simplifyPath("/a//b////c/d//././/..");
        System.out.println(result);
        result = simplifyPath("/../");
        System.out.println(result);
        System.out.println(simplifyPath("/home//foo/"));
    }
}
