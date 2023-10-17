package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 등수 매기기
 */
public class B02012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(arr);

        long result = 0;
        for (int i = 0; i < N; i++) {
            result += Math.abs((i + 1) - arr.get(i));
        }

        System.out.println(result);
    }
}
