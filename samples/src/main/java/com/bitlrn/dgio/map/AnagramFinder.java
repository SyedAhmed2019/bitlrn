package com.bitlrn.dgio.map;


import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class AnagramFinder {

    private final Map<Character, Integer> tracker = new HashMap<>();

    public static void main(String[] args) {
        AnagramFinder af = new AnagramFinder();
        System.out.println(af.isAnagram("listen", "silent"));
        System.out.println(af.isAnagram("racecar", "carrace"));
        System.out.println(af.isAnagram("palindrome", "emrodinlaq"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        for (char c : s.toCharArray()) {
            tracker.merge(c, 1, Integer::sum);
        }
        for (char c : t.toCharArray()) {
            Integer value = tracker.get(c);
            if (value != null) {
                if (value > 1) {
                    tracker.put(c, --value);
                } else {
                    tracker.remove(c);
                }
            }
        }
        return tracker.isEmpty();
    }
}
