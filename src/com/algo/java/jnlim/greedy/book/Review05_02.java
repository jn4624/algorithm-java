package com.algo.java.jnlim.greedy.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 모험가 길드 2회차 복습
 */
public class Review05_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        List<Integer> fear = new ArrayList<>(); // 공포도 리스트
        for (int i = 0; i < n; i++) {
            fear.add(scan.nextInt());
        }

        scan.close();

        Collections.sort(fear); // 낮은 공포도부터 처리하기 위해 정렬 처리

        int adven = 0; // 참가한 모험가 수
        int groups = 0; // 결성된 그룹 수

        for (int i = 0; i < n; i++) {
            adven++;

            if (adven >= fear.get(i)) { // 참가한 모험가의 수가 공포도보다 크거나 같다면
                groups++; // 그룹 결성
                adven = 0;
            }
        }

        System.out.println(groups);
    }
}
