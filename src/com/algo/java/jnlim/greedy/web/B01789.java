package com.algo.java.jnlim.greedy.web;

import java.util.Scanner;

/**
 * 수들의 합
 */
public class B01789 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long s = scan.nextLong();
        scan.close();

        long sum = 0;
        long cnt = 0;

        for (int i=1; i<=s; i++) {
            sum += i;

            if (sum > s)
                break;

            cnt++;
        }

        System.out.println(cnt);
    }
}
