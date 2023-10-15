package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 주사위
 */
public class B01041 {
    public static long res;
    public static long[] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }

        dice = new long[4];
        dice[1] = 5 * (N - 2) * (N - 2) + 4 * (N - 2);
        dice[2] = 8 * (N - 2) + 4;
        dice[3] = 4;

        if (N == 1) {
            Arrays.sort(arr);

            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += arr[i];
            }

            System.out.println(sum);
        } else {
            long min = arr[0];
            for (int i = 1; i < 6; i++) {
                min = Math.min(min, arr[i]);
            }

            res += dice[1] * min;

            min = Long.MAX_VALUE;
            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {
                    if (j + i != 5) {
                        min = Math.min(min, arr[i] + arr[j]);
                    }
                }
            }

            res += dice[2] * min;

            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += Math.min(arr[i], arr[5 - i]);
            }

            res += dice[3] * sum;

            System.out.println(res);
        }
    }
}
