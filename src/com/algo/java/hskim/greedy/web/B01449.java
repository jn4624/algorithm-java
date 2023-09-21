package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 수리공 항승
 * https://www.acmicpc.net/problem/1449
 */
public class B01449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] tapeArr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            tapeArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tapeArr);

        int range = (int)(tapeArr[0]- 0.5 + L);
        int result = 1;

        for(int i = 1; i < tapeArr.length; i++){
            if(range < (int)(tapeArr[i] + 0.5)) {
                range = (int)(tapeArr[i] - 0.5 + L);
                result++;
            }
        }

        System.out.println(result);
    }
}
