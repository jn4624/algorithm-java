package com.algo.java.jnlim.greedy.book;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 큰 수의 법칙 복습 2회차
 */
public class Review02_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(); // 배열의 크기
        int m = scan.nextInt(); // 더해지는 횟수
        int k = scan.nextInt(); // 초과하여 더해질 수 없는 횟수

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(scan.nextInt());
        }

        scan.close();

        Collections.sort(arr); // 첫번째 큰 수, 두번째 큰 수를 추출하기 위해 정렬 처리

        System.out.println(arr.toString());

        int firstMaxNum = arr.get(n - 1); // 첫번째 큰 수
        int secondMaxNum = arr.get(n - 2); // 두번째 큰 수

        int firstCalcCount = ((m / (k + 1)) * k) + (m % (k + 1)); // 첫번째 큰 수가 계산되어지는 횟수 추출
        int secondCalcCount = (m - firstCalcCount); // 두번째 큰 수가 계산되어지는 횟수 추출

        int result = (firstMaxNum * firstCalcCount) + (secondMaxNum * secondCalcCount);

        System.out.println(result);
    }
}
