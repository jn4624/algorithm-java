package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 문자열 뒤집기 1회차 복습
 */
public class Review07_01 {
    public static String str;
    public static int zeroCount;
    public static int oneCount;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        str = scan.next();
        scan.close();

        if (str.charAt(0) == '0') {
            zeroCount++;
        } else {
            oneCount++;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                if (str.charAt(i + 1) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
        }

        System.out.println(Math.min(zeroCount, oneCount));
    }
}
