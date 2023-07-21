package com.algo.java.jnlim.greedy.web;

import java.util.Scanner;

/**
 * 펜션
 */
public class C04040 {
    public static int season; // 펜션에서 관리하는 여름 성수기 총 기간
    public static int rooms; // 펜션이 보유하고 있는 방의 개수
    public static int[][] reservations; // 예약 현황
    public static int arrival; // 펜션에 도착하는 날
    public static int departure; // 펜션을 떠나는 날

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        season = scan.nextInt();
        rooms = scan.nextInt();

        reservations = new int[season + 1][rooms + 1]; // 일자를 맞추기 위해 배열에 +1 처리

        /**
         * [0, 0, 0, 0, 0, 0, 0, 0]
         * [0, 0, 0, 0, 0, 0, 0, 0]
         * [0, 0, 1, 0, 0, 0, 0, 1]
         * [0, 0, 1, 0, 0, 0, 0, 1]
         * [0, 0, 1, 0, 0, 0, 1, 0]
         * [0, 1, 0, 0, 1, 0, 1, 0]
         * [0, 0, 1, 0, 1, 0, 1, 0]
         * [0, 1, 0, 0, 1, 0, 1, 0]
         * [0, 1, 0, 0, 0, 0, 1, 0]
         * [0, 0, 0, 0, 0, 0, 0, 0]
         * [0, 0, 0, 0, 0, 0, 0, 0]
         */
        for (int i = 1; i <= season; i++) {
            String status = scan.next();

            for (int j = 1; j <= rooms; j++) {
                reservations[i][j] = status.charAt(j - 1) == 'O' ? 1 : 0;
            }
        }

        /**
         * [0, 0, 0, 0, 0, 0, 0, 0]
         * [0, 0, 0, 0, 0, 0, 0, 0]
         * [0, 0, 3, 0, 0, 0, 0, 2]
         * [0, 0, 2, 0, 0, 0, 0, 1]
         * [0, 0, 1, 0, 0, 0, 5, 0]
         * [0, 1, 0, 0, 3, 0, 4, 0]
         * [0, 0, 1, 0, 2, 0, 3, 0]
         * [0, 2, 0, 0, 1, 0, 2, 0]
         * [0, 1, 0, 0, 0, 0, 1, 0]
         * [0, 0, 0, 0, 0, 0, 0, 0]
         * [0, 0, 0, 0, 0, 0, 0, 0]
         */
        for (int i = 1; i <= rooms; i++) {
            for (int j = season; j > 0; j--) {
                if (reservations[j][i] == 0 || reservations[j - 1][i] == 0) {
                    continue;
                }

                reservations[j - 1][i] += reservations[j][i];
            }
        }

        arrival = scan.nextInt();
        departure = scan.nextInt();

        int result = -1; // 예약 첫 날이 방 변경 횟수에 포함되므로 0이 아닌 -1로 초기화 진행
        while (arrival < departure) {
            result++;

            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= rooms; j++) {
                max = Math.max(max, reservations[arrival][j]);
            }

            // 예약이 불가능한 경우
            if (max == 0) {
                result = -1;
                break;
            }

            arrival += max;
        }

        System.out.println(result);
    }
}
