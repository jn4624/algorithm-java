package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 국회의원 선거
 * https://www.acmicpc.net/problem/1417
 */
public class B01417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 1; i < N; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while(!queue.isEmpty() && num <= queue.peek()){
            queue.offer(queue.poll() - 1);
            num++;
            result++;
        }

        System.out.println(result);
    }
}
