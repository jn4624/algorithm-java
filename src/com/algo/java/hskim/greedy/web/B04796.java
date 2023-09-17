package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 캠핑
 * https://www.acmicpc.net/problem/4796
 * 다시
 */
public class B04796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int index = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L, P, V = 0;

            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if(L == 0 && P == 0 && V == 0) break;

            int count = L * (V/P) + Math.min(L, (V%P));
            sb.append("Case " + index + ": " + count + "\n");

            index++;
        }

        System.out.println(sb.toString());
    }
}
