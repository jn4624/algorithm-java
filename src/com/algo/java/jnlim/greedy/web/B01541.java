package com.algo.java.jnlim.greedy.web;

import java.util.Scanner;

/**
 * 잃어버린 괄호
 */
public class B01541 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        scan.close();

        int sum = Integer.MAX_VALUE;
        String[] subNumber = str.split("-");

        for (int i = 0; i < subNumber.length; i++) {
            int temp = 0;

            String[] addNumber = subNumber[i].split("\\+");

            for (int j = 0; j < addNumber.length; j++) {
                temp += Integer.parseInt(addNumber[j]);
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
