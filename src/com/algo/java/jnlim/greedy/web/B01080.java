package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 행렬
 */
public class B01080 {
    public static int[][] AList;
    public static int[][] BList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        AList = new int[N][M];
        BList = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                AList[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                BList[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }

        int count = 0;
        /**
         * 탐색 시작
         * 배열의 범위를 넘어가지 않게 N-2, M-2까지만 탐색
         */
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                /**
                 * A리스트와 B리스트와 값이 다를 경우 뒤집는다
                 * 이 지점은 다시 뒤집을 수 없는 지점이므로 무조건 뒤집는다
                 */
                if (AList[i][j] != BList[i][j]) {
                    change(i, j);
                    count++;
                }
            }
        }

        int flag = 0;
        /**
         * A리스트와 B리스트가 같은지 확인한다
         */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (AList[i][j] == BList[i][j]) {
                    flag++;
                }
            }
        }

        if (flag == N * M) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

    /**
     * i, j 기준으로 3 * 3 크기만큼 뒤집는다
     */
    public static void change(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                AList[i][j] = AList[i][j] ^ 1;
            }
        }
    }
}
