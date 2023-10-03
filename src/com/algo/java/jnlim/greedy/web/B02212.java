package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 센서
 */
public class B02212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] intArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            intArr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(intArr);

        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < N - 1; i++)
            q.offer(intArr[i + 1] - intArr[i]);

        int ans = 0;
        for (int i = 0; i < N - K; i++)
            ans += q.poll();

        System.out.println(ans);
    }
}
