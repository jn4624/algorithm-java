package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

/**
 * 크게 만들기
 * https://www.acmicpc.net/problem/2812
 * 키워드: deque
 */
public class B02812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = K;

        String numStr = br.readLine();
        int[] numArr = new int[N];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < numStr.length(); i++) {
            numArr[i] = Integer.parseInt(numStr.substring(i, i+1));
        }

        for(int i = 0; i < numArr.length; i++) {
            int curr = numArr[i];

            while(!stack.isEmpty() && stack.peek() < curr && count > 0) {
                stack.pop();
                count--;
            }

            stack.push(curr);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N-K; i++) {
            sb.append(stack.get(i));
        }

        System.out.println(sb.toString());
    }
}
