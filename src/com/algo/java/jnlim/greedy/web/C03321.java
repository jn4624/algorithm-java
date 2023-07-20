package com.algo.java.jnlim.greedy.web;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 최고의 피자
 */
public class C03321 {
    public static int n; // 토핑 종류 수
    public static int doughPlace; // 도우 가격
    public static int toppingPlace; // 토핑 가격
    public static int doughCalorie; // 도우 칼로리
    public static Integer[] toppingCalories; // 토핑 칼로리

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        doughPlace = scan.nextInt();
        toppingPlace = scan.nextInt();
        doughCalorie = scan.nextInt();

        toppingCalories = new Integer[n];
        for (int i=0; i<n; i++) {
            toppingCalories[i] = scan.nextInt();
        }

        scan.close();

        Arrays.sort(toppingCalories, Collections.reverseOrder());

        int result = Integer.MIN_VALUE;
        for (int i=0; i<toppingCalories.length; i++) {
            int temp = doughPlace + (toppingPlace * (i+1));
            doughCalorie += toppingCalories[i];
            result = Math.max(result, doughCalorie/temp);
        }

        System.out.println(result);
    }
}
