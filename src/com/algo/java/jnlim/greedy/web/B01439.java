package com.algo.java.jnlim.greedy.web;

import java.util.Scanner;

/**
 * 뒤집기
 */
public class B01439 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String S = scan.next();
        scan.close();

        int zeroCount = 0;
        int oneCount = 0;

        char tmp = S.charAt(0);
        if (tmp == '0') {
            zeroCount++;
        } else {
            oneCount++;
        }

        for (int i = 1; i < S.length(); i++) {
            if (tmp != S.charAt(i)) {
                if (S.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }

                tmp = S.charAt(i);
            }
        }

        System.out.println(Math.min(zeroCount, oneCount));
    }
}
