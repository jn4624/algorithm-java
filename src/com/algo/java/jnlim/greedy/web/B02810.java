package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 컵홀더
 */
public class B02810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int seatCount = Integer.parseInt(br.readLine());
        String seatInfo = br.readLine();

        int sCount = 0;
        int lCount = 0;
        for (int i = 0; i < seatCount; i++) {
            if (seatInfo.charAt(i) == 'S') {
                sCount++;
            } else {
                lCount++;
            }
        }

        int result = 0;
        if (sCount != 0) {
            result += sCount;
        }

        if (lCount != 0) {
            result += (lCount / 2) + 1;
        }

        System.out.println(result);
    }
}
