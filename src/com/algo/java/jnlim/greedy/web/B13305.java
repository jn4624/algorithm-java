package com.algo.java.jnlim.greedy.web;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 주유소
 */
public class B13305 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        BigInteger[] km = new BigInteger[n-1];
        BigInteger[] price = new BigInteger[n];

        for (int i = 0; i < n-1; i++) {
            km[i] = scan.nextBigInteger();
        }

        for (int i = 0; i < n; i++) {
            price[i] = scan.nextBigInteger();
        }

        scan.close();

        BigInteger totalPrice = new BigInteger("0");
        BigInteger minPrice = price[0];

        for (int i = 0; i < n-1; i++) {
            // 이전 가격과 현재 가격 비교해서 저렴한 가격으로 초기화
            if (price[i].compareTo(minPrice) < 0) {
                minPrice = price[i];
            }

            totalPrice = totalPrice.add(minPrice.multiply(km[i]));
        }

        System.out.println(totalPrice);
    }
}
