package com.bitlrn.dgio.stack;


public class UniqueCharacterSaver {

    public static void main(String[] args) {
        UniqueCharacterSaver ucs = new UniqueCharacterSaver();
        System.out.println(ucs.makeGood("AaBbCcDdEeff"));
        System.out.println(ucs.makeGood("abBA"));
        System.out.println(ucs.makeGood("s"));
    }

    public String makeGood(String s) {
        Stack<Character> input = new Stack<>(s.length());
        for (char current : s.toCharArray()) {
            if (!input.isEmpty() && isSameLetterDiffCase(current, input.peek())) {
                input.pop();
            } else {
                input.push(current);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!input.isEmpty()) {
            sb.append(input.pop());
        }
        return sb.reverse().toString();
    }

    private boolean isSameLetterDiffCase(char current, char compareTo) {
        if (current == compareTo) {
            return false;
        } else return Character.toLowerCase(current) == Character.toLowerCase(compareTo);
    }
}
