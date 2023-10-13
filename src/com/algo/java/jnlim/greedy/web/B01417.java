package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 국회의원 선거
 */
public class B01417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int temp = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int number = queue.poll();

            if (temp <= number) {
                result++;
                temp++;
                queue.add(--number);
            }
        }

        System.out.println(result);
    }
}
