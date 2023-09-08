package com.algo.java.jnlim.greedy.web;

import java.util.Scanner;

/**
 * 전자레인지
 */
public class B10162 {
    public static int[] times = {300, 60, 10};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times.length; i++) {
            sb.append(T / times[i]).append(" ");
            T = (T % times[i]);
        }

        if (T != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb.toString());
    }
}
