package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 주식
 */
public class B11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int testCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCount; i++) {
            int days = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            List<Long> stockPrices = new ArrayList<>();
            for (int j = 0; j < days; j++) {
                stockPrices.add(Long.parseLong(st.nextToken()));
            }

            long max = Long.MIN_VALUE;
            long result = 0;

            for (int k = days - 1; k >= 0; k--) {
                if (stockPrices.get(k) > max) {
                    max = stockPrices.get(k);
                } else {
                    result += (max - stockPrices.get(k));
                }
            }

            System.out.println(result);
        }
    }
}
