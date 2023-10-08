package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주식
 * https://www.acmicpc.net/problem/11501
 */
public class B11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while(T -- > 0) {
            int N = Integer.parseInt(br.readLine());
            int stocks[] = new int[N];
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i ++) {
                stocks[i] = Integer.parseInt(st.nextToken());
            }

            long max = 0;
            long answer = 0;
            for(int i = N - 1; i >= 0; i --) {
                if(stocks[i] > max) {
                    max = stocks[i];
                }
                else {
                    answer += max - stocks[i];
                }
            }

            result.append(answer + "\n");
        }

        System.out.println(result);
    }
}
