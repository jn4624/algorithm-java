package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 로프
 * https://www.acmicpc.net/problem/2217
 */
public class B02217 {
    /** keyword
     * 1. w/k(N) 만큼 중량이 걸린다
     *  각 로프의 최대 중량은 10, 15이고, 임의로 w에 20 중량이 주어졌을 때
     *       w/k = 각 로프에 나누어 걸리는 중량
     *      20/2 = 10
     *  로프 1개, 최대 중량 10인 로프를 사용하면 최대 중량은 10
     *  로프 1개, 최대 중량 15인 로프를 사용하면 최대 중량은 15
     *  로프 2개, 최대 중량 25인 로프를 사용하면 각 로프에 걸리는 무게는 10, 10씩 걸 수 있게 된다
     *
     * 2. 모든 로프를 사용할 필요 없다
     *  5개의 로프가 있을 때
     *  로프 1개일 때 최대 중량을 들 수 있다면 1개만 사용
     *  로프 2개일 때 최대 중량을 들 수 있다면 2개만 사용한다는 뜻
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] ropeArr = new int[N];
        for(int i = 0; i < N; i++) {
            ropeArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropeArr);

        int maxRope = Integer.MIN_VALUE;
        int index = N;
        for(int i = 0; i < N; i++) {
            index--;
            int rope = ropeArr[index] * (i+1);
            if(rope > maxRope) maxRope = rope;
        }

        System.out.println(maxRope);
    }
}
