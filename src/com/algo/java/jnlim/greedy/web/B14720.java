package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 우유 축제
 */
public class B14720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int storeCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        int milk = 0;

        for (int i=0; i<storeCount; i++) {
            int store = Integer.parseInt(st.nextToken());

            if (store == milk) {
                milk = (milk + 1 == 3) ? 0 : milk + 1;
                result++;
            }
        }

        System.out.println(result);
    }
}
