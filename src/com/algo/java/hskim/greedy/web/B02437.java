package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 저울
 * https://www.acmicpc.net/problem/2437
 */
public class B02437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] weightArr = new int[N];

        while(st.hasMoreTokens()) {
            int weight = Integer.parseInt(st.nextToken());
            weightArr[weightArr.length - N] = weight;
            N--;
        }

        Arrays.sort(weightArr);

        int sum = 0;

        for(int i = 0; i < weightArr.length; i++) {
            if(sum+1 < weightArr[i]) break;
            sum += weightArr[i];
        }

        System.out.println(++sum);
    }
}
