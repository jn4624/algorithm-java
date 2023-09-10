package com.algo.java.jnlim.greedy.web;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 30
 */
public class B10610 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String N = scan.next();
        scan.close();

        char[] arr = N.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int sum = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i] - '0';
            sum += num;
            sb.append(num);
        }

        if (!N.contains("0") || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb.toString());
    }
}
