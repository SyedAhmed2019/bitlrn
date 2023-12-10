package com.bitlrn.hijri1445.arrays;

public class Palindrome {
    // given x return true if x is palindrome
    // input 121
    // input 0;
    // input 1;
    // input 12;
    // input 22;
    // input 222;
    // input 4444
    boolean isPalindrome(int x){
        int buff[] = new int [10];
        int temp = x;
        int i = 0;
        if ((temp==0)||(temp==1)){
            return true;
        }
        // 121
        while( temp/10 != 0) {
            buff[i] = temp % 10;
            System.out.println(buff[i]);
            temp = temp/10;
            i++;
        }
        buff[i] = temp%10;
        System.out.println(buff[i]);
        for(int left=0, right = i; left != right &&  left < right; ++left, --right){
            if(buff[left]!=buff[right]){
                return false;
            }
        }
        return true;
    }

    boolean isPalindrome_smartest(int x){
        int reverseSum = 0;
        while (x > reverseSum){
            reverseSum = reverseSum*10 +  x%10;
            x/=10;
        }
        return x == reverseSum || x == reverseSum/10;
    }
    //123321
    // reverseSum = 1
    // 10 + 2 = 12
    // 120 + 3 = 123

    //121
    // revesesum = 1
    // reversesum = 12
    //
    public static void main(String[] args) {
        Palindrome pal = new Palindrome();
        // O(n)
        System.out.println(pal.isPalindrome(123321));
        System.out.println(pal.isPalindrome(1221));
        System.out.println(pal.isPalindrome(121));
        System.out.println(pal.isPalindrome(12321));
        System.out.println(pal.isPalindrome(123213));
        //O(n/2)
        System.out.println(pal.isPalindrome_smartest(123321));
        System.out.println(pal.isPalindrome_smartest(1221));
        System.out.println(pal.isPalindrome_smartest(121));
        System.out.println(pal.isPalindrome_smartest(12321));
        System.out.println(pal.isPalindrome_smartest(123213));
    }
}
