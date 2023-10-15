package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 통나무 건너뛰기
 */
public class B11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int left = N - 1;
            int right = 0;
            int[] numbers = new int[N];

            for (int j = 0; j < N; j++) {
                if (j % 2 == 0) {
                    numbers[left--] = arr[j];
                } else {
                    numbers[right++] = arr[j];
                }
            }

            int answer = Integer.MIN_VALUE;
            for (int j = 1; j < N; j++) {
                answer = Math.max(answer, Math.abs(numbers[j] - numbers[j - 1]));
            }

            answer = Math.max(answer, Math.abs(numbers[0] - numbers[N - 1]));

            System.out.println(answer + " ");
        }
    }
}
