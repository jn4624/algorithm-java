package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 저울
 */
public class B02437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[N];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(weights);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum + 1 < weights[i]) {
                break;
            }

            sum += weights[i];
        }

        System.out.println(++sum);
    }
}
