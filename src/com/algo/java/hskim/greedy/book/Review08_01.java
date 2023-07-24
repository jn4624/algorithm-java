package com.algo.java.hskim.greedy.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 04.만들 수 없는 금액(p314)
 * 같은 문제 3회 풀기
 */
public class Review08_01 {
    /**
     * 2회차 : 2023-07-23
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] numArr = new int[N];

        for(int i = 0; i < N; i++) {
            numArr[i] = sc.nextInt();
        }

        Arrays.sort(numArr);

        int target = 1;
        int sum = 0;

        for(int num : numArr) {
            sum += num;

            if(target < num) {
                break;
            }

            if(target <= sum) {
                target = sum;
                target++;
            }
            else {
                target++;
            }
        }

        System.out.println(target);
    }
}
