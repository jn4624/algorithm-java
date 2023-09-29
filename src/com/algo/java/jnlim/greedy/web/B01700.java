package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 멀티탭 스케줄링
 */
public class B01700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int socketCount = Integer.parseInt(st.nextToken());
        int useCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> electronics = new ArrayList<>();
        for (int i = 0; i < useCount; i++) {
            electronics.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> set = new HashSet<>();

        int result = 0;
        for (int i = 0; i < useCount; i++) {
            int num = electronics.get(i);
            if (set.contains(num)) {
                continue;
            }

            if (set.size() < socketCount && set.add(num)) {
                continue;
            }

            int max = -1;
            int idx = -1;
            for (int s : set) {
                int tmp = 0;
                List<Integer> sub = electronics.subList(i + 1, useCount);

                if (sub.contains(s)) {
                    tmp = sub.indexOf(s) + 1;
                } else {
                    tmp = useCount - i - 1;
                }

                if (tmp > max) {
                    max = tmp;
                    idx = s;
                }
            }

            set.remove(idx);
            set.add(num);
            result++;
        }

        System.out.println(result);
    }
}
