package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 크게 만들기
 */
public class B02812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int len = N - K;

        Stack<Character> stack = new Stack<>();
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            if (!stack.empty()) {
                while (!stack.empty() && K > 0 && stack.peek() < str.charAt(i)) {
                    stack.pop();
                    K--;
                }
            }

            stack.push(str.charAt(i));
        }

        while (true) {
            if (stack.size() == len) {
                break;
            }

            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse().toString());
    }
}
