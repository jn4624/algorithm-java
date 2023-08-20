package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 문자열 뒤집기 2회차 복습
 */
public class Review07_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        scan.close();

        int zero = 0;
        int one = 0;

        if (str.charAt(0) == '0') {
            zero++;
        } else {
            one++;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                if (str.charAt(i + 1) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
        }

        int result = Math.min(zero, one);

        System.out.println(result);
    }
}
