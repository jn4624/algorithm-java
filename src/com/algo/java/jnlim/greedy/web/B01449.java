package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 수리공 항승
 */
public class B01449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int leakCount = Integer.parseInt(st.nextToken());
        int tapeLength = Integer.parseInt(st.nextToken());
        List<Integer> leaks = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < leakCount; i++) {
            leaks.add(Integer.parseInt(st.nextToken()));
        }

        // 물이 새는 곳의 위치를 오름차순 정렬
        Collections.sort(leaks);

        // 첫번째 물이 새는 곳의 위치 값 계산
        double tapeRange = leaks.get(0) - 0.5;
        int tapeCount = 1;

        for (int i = 0; i < leakCount; i++) {
            /**
             * 첫번째 물이 새는 위치에서 사용한 테이프 길이를 오버했다면
             * 테이프 개수 증가 및 새로운 위치로 초기화 처리
             */
            if (tapeRange + tapeLength < leaks.get(i)) {
                tapeCount++;
                tapeRange = leaks.get(i) - 0.5;
            }
        }

        System.out.println(tapeCount);
    }
}
