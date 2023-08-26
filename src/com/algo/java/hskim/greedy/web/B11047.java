package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 동전 0
 * https://www.acmicpc.net/problem/11047
 */
public class B11047 {
    /** [2023-08-22]
     * ArrayList 쓴 코드 128ms
     * 쓰지 않고 나머지는 유사한 코드(202212) 124ms
     *
     * K 보다 큰 동전으로 나누지 않기 위해 ArrayList를 썼는데 굳이 쓰지 않아도 됨
     * 궁금하면 '/', '%' 연산을 해볼 것
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> num = new ArrayList<>();
        int temp = K;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            temp = Integer.parseInt(st.nextToken());

            if(temp <= K) {
                num.add(temp);
            }
        }

        int result = 0;

        for(int i = num.size()-1; i >= 0; i--) {
            if(num.get(i) <= K) {
                result += K / num.get(i);
                K = K % num.get(i);
            }
        }

        System.out.println(result);
    }
}
