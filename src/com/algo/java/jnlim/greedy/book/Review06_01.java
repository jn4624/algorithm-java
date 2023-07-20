package com.algo.java.jnlim.greedy.book;

import java.util.Scanner;

/**
 * 곱하기 혹은 더하기 1회차 복습
 */
public class Review06_01 {
    public static String str;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        str = scan.next();
        scan.close();

        long result = 0;
        for (char c : str.toCharArray()) {
            int temp = Integer.parseInt(Character.toString(c));

            if (result <= 1 || temp <= 1) {
                result += temp;
            } else {
                result *= temp;
            }
        }

        System.out.println(result);
    }
}
