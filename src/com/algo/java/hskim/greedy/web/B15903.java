package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 카드 합체 놀이
 * https://www.acmicpc.net/problem/15903
 * 다시
 */
public class B15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            Arrays.sort(arr);
            long N = arr[0] + arr[1];
            arr[0] = N;
            arr[1] = N;
        }

        long result = 0;

        for(int i = 0; i < n; i++) {
            result += arr[i];
        }
        System.out.println(result);
    }
}
