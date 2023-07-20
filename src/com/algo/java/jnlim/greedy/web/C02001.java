package com.algo.java.jnlim.greedy.web;

import java.util.Scanner;

/**
 * 최소 대금
 */
public class C02001 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int minPricePasta = Integer.MAX_VALUE;
        int minPriceJuice = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            if (i < 3) {
                minPricePasta = Math.min(minPricePasta, scan.nextInt());
            } else {
                minPriceJuice = Math.min(minPriceJuice, scan.nextInt());
            }
        }

        scan.close();

        int setPrice = (minPricePasta + minPriceJuice);
        float tax = setPrice * 0.1F;

        System.out.println(String.format("%.1f", setPrice + tax));
    }
}
