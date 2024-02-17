package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * 2+1 세일
 */
public class B11508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        Integer[] dairyProducts = new Integer[count];

        for (int i = 0; i < count; i++) {
            dairyProducts[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(dairyProducts, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < count; i++) {
            if (i % 3 == 2) {
                continue;
            }

            result += dairyProducts[i];
        }

        System.out.println(result);
    }
}
