package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 거스름돈
 */
public class B14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = Integer.parseInt(br.readLine());

        int result = 0;
        while (true) {
            if (change == 1) {
                result = -1;
                break;
            }

            if (change == 0) {
                break;
            }

            if (change % 5 == 0) {
                change -= 5;
            } else {
                change -= 2;
            }

            result++;
        }

        System.out.println(result);
    }
}
