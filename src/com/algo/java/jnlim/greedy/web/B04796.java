package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 캠핑
 */
public class B04796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int index = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int useDays = Integer.parseInt(st.nextToken()); // 캠핑장 사용 일수
            int campUseDays = Integer.parseInt(st.nextToken()); // 캠핑장 연속 일수
            int vacationDays = Integer.parseInt(st.nextToken()); // 휴가 일수

            if (useDays == 0 && campUseDays == 0 && vacationDays == 0) {
                break;
            }

            /**
             * useDays * (vacationDays / campUseDays) -> 휴가 일수를 캠핑장 연속 일수로 나누어 휴가 일수 동안 캠핑장을 사용할 수 있는 일수를 추출 후 캠핑장 사용 일수를 곱하여 최대 사용 일수 추출
             * Math.min(useDays, vacationDays % campUseDays) -> 캠핑장 사용 일수보다 캠핑장을 사용할 수 있는 일수가 적으면 최대 사용 일수에 포함
             */
            int total = useDays * (vacationDays / campUseDays) + Math.min(useDays, vacationDays % campUseDays);
            sb.append("Case " + index + ": " + total + "\n");
            index++;
        }

        System.out.println(sb);
    }
}
