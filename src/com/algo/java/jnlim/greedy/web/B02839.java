package com.algo.java.jnlim.greedy.web;

import java.util.Scanner;

/**
 * 설탕 배달
 */
public class B02839 {
    public static final int sugar5kg = 5;
    public static final int sugar3kg = 3;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int delivered = scan.nextInt();

        scan.close();

        int count = 0;
        while (true) {
            if (delivered % sugar5kg == 0) {
                count += (delivered / sugar5kg);
                break;
            } else {
                delivered -= sugar3kg;
                count++;
            }

            if (delivered < 0) {
                count = -1;
                break;
            }
        }

        System.out.println(count);
    }
}
