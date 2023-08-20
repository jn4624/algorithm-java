package com.algo.java.jnlim.greedy.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 만들 수 없는 금액 2회차 복습
 */
public class Review08_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        List<Integer> coinList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coinList.add(scan.nextInt());
        }

        scan.close();

        Collections.sort(coinList);

        int result = 1;
        for (int i = 0; i < n; i++) {
            if (result < coinList.get(i)) {
                break;
            }

            result += coinList.get(i);
        }

        System.out.println(result);
    }
}
