package com.algo.java.jnlim.greedy.web;

import java.util.Scanner;

/**
 * A -> B
 */
public class B16953 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        scan.close();

        int count = 1;
        while (B != A) {
            if (B < A) {
                count = -1;
                break;
            }

            String str = String.valueOf(B);

            if (str.substring(str.length() - 1).equals("1")) {
                str = str.substring(0, str.length() - 1);
                B = Integer.parseInt(str);
            } else if (B % 2 == 0) {
                B /= 2;
            } else {
                count = -1;
                break;
            }

            count++;
        }

        System.out.println(count);
    }
}
