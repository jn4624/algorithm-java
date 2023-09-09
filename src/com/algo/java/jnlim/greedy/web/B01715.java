package com.algo.java.jnlim.greedy.web;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 카드 정렬하기
 */
public class B01715 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<Long>();

        for (int i = 0; i < N; i++) {
            pq.add(scan.nextLong());
        }

        scan.close();

        long result = 0;
        while (pq.size() > 1) {
            long card1 = pq.poll();
            long card2 = pq.poll();

            result += (card1 + card2);
            pq.add(card1 + card2);
        }

        System.out.println(result);
    }
}
