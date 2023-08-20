package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ATM
 * https://www.acmicpc.net/problem/11399
 */
public class B11399 {
    /**
     * 메모리 14448 kb
     * 시간 140 ms
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sb.readLine());
        StringTokenizer st = new StringTokenizer(sb.readLine());

        int[] numArr = new int[N];

        while(st.hasMoreTokens()) {
            numArr[numArr.length-N] = Integer.parseInt(st.nextToken());
            N--;
        }

        Arrays.sort(numArr);

        int result = numArr[0];

        for(int i = 1; i < numArr.length; i++) {
            numArr[i] = numArr[i - 1] + numArr[i];
            result += numArr[i];
        }

        System.out.println(result);
    }
}
