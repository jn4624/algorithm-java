package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 배
 */
public class B01092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int craneCount = Integer.parseInt(br.readLine()); // 크레인 갯수
        List<Integer> cranes = new ArrayList<>(); // 크레인 종류
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < craneCount; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        int boxCount = Integer.parseInt(br.readLine()); // 박스 갯수
        List<Integer> boxes = new ArrayList<>(); // 박스 종류
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < boxCount; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        // 내림차순 정렬
        Collections.sort(cranes, Collections.reverseOrder());
        Collections.sort(boxes, Collections.reverseOrder());

        // 크레인이 옮길 수 있는 무게보다 박스 무게가 더 무거울 경우
        if (boxes.get(0) > cranes.get(0)) {
            System.out.println(-1);
            return;
        }

        int result = 0;
        while (!boxes.isEmpty()) {
            int craneIndex = 0;
            int boxIndex = 0;

            while (craneIndex < craneCount) {
                if (boxIndex == boxes.size()) { // 박스 위치와 남은 박스의 갯수가 동일하다면
                    break;
                } else if (cranes.get(craneIndex) >= boxes.get(boxIndex)) { // 크레인이 박스 무게를 옮길 수 있는 경우
                    boxes.remove(boxIndex); // 옮길 수 있는 박스 제거
                    craneIndex++; // 크레인 위치 이동
                } else { // 크레인이 박스를 옮길 수 없는 경우
                    boxIndex++; // 박스 위치 이동
                }
            }

            result++;
        }

        System.out.println(result);
    }
}
