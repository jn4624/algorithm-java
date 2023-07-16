package com.algo.java.hskim.greedy.book;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Book03 {
    /**
     * 숫자 카드 게임(p96)
     * 1회차 : 2023-07-01
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = Integer.MIN_VALUE;     //정수형 데이터 중 가장 작은 값으로 초기화

        // N 행 M 번 입력
        for(int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;    //정수형 데이터 중 가장 큰 값으로 초기화
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                min = Math.min(min, temp);
            }

            result = Math.max(result, min);
        }

        br.close();
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}