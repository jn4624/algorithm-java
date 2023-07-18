package com.algo.java.jnlim.greedy.web;

import java.util.Scanner;

/**
 * 리모컨
 */
public class C03120 {
    public static int nowTemp;
    public static int changeTemp;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        nowTemp = scan.nextInt();
        changeTemp = scan.nextInt();

        scan.close();

        int result = 0;
        int temp = Math.abs(nowTemp - changeTemp);

        while (true) {
            if (temp == 0) {
                break;
            }

            if (temp >= 8) {
                temp -= 10;
            } else if (temp >= 4) {
                temp -= 5;
            } else {
                if (temp < 0) {
                    temp += 1;
                } else {
                    temp -= 1;
                }
            }

            result++;
        }

        System.out.println(result);
    }
}
