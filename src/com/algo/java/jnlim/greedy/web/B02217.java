package com.algo.java.jnlim.greedy.web;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 로프
 */
public class B02217 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int ropeCounts = scan.nextInt();
        Integer[] ropeMaximumWeights = new Integer[ropeCounts];

        for (int i=0; i<ropeCounts; i++) {
            ropeMaximumWeights[i] = scan.nextInt();
        }

        Arrays.sort(ropeMaximumWeights, Collections.reverseOrder());

        int maxWeight = Integer.MIN_VALUE;
        for (int i=0; i<ropeCounts; i++) {
            maxWeight = Math.max(maxWeight, (ropeMaximumWeights[i] * (i+1)));
        }

        System.out.println(maxWeight);
    }
}
