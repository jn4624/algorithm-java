package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 등수 매기기
 * https://www.acmicpc.net/problem/2012
 */
public class B02012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        arr[0] = 0;

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long result = 0;
        for (int i = 1; i <= N; i++) {
            result += Math.abs(i-arr[i]);
        }

        System.out.println(result);
    }
}
