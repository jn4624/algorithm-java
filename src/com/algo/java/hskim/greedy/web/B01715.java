package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 카드 정렬하기
 * https://www.acmicpc.net/problem/1715
 */
public class B01715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        int prev = 0;
        int curr = 0;

        while(pq.size() > 1) {
            prev = pq.poll();
            curr = pq.poll();
            result += prev + curr;
            pq.offer(prev + curr);
        }

        System.out.println(result);

        /* 실패한 방법
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numArr = new int[N];

        for(int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numArr);

        long result = 0;
        long sum = numArr[0];
        for(int i = 1; i < numArr.length; i++) {
            sum += numArr[i];
            result += sum;
        }

        System.out.println(result);
         */
    }
}
