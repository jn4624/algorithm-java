package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 도서관
 */
public class B01461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 두 우서순위 큐는 내림차순 정렬
        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>((p1, p2) -> p2 - p1);
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>((p1, p2) -> p2 - p1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (temp > 0) {
                positiveQueue.offer(temp);
            } else {
                negativeQueue.offer(Math.abs(temp));
            }
        }

        // 가장 멀리 있는 책의 위치 저장
        int max = 0;
        if (positiveQueue.isEmpty()) {
            max = negativeQueue.peek();
        } else if (negativeQueue.isEmpty()) {
            max = positiveQueue.peek();
        } else {
            max = Math.max(positiveQueue.peek(), negativeQueue.peek());
        }

        int result = 0;
        while (!positiveQueue.isEmpty()) {
            int temp = positiveQueue.poll();

            for (int i = 0; i < M - 1; i++) {
                positiveQueue.poll();

                if (positiveQueue.isEmpty()) {
                    break;
                }
            }

            result += temp * 2;
        }

        while (!negativeQueue.isEmpty()) {
            int temp = negativeQueue.poll();

            for (int i = 0; i < M - 1; i++) {
                negativeQueue.poll();

                if (negativeQueue.isEmpty()) {
                    break;
                }
            }

            result += temp * 2;
        }

        result -= max;
        System.out.println(result);
    }
}
