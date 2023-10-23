package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 이장님 초대
 */
public class B09237 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Collections.reverseOrder());

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, list.get(i) + i + 1);
        }

        result += 1;
        System.out.println(result);
    }
}
