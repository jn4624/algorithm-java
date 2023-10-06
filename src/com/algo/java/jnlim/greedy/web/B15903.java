package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 카드 합체 놀이
 */
public class B15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Queue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }

        while (M > 0) {
            long sum = queue.poll() + queue.poll();

            for (int i = 0; i < 2; i++) {
                queue.add(sum);
            }

            M--;
        }

        long result = 0;
        while (!queue.isEmpty()) {
            result += queue.poll();
        }

        System.out.println(result);
    }
}
