package com.algo.java.jnlim.greedy.book;

import java.util.*;

/**
 * 모험가 길드
 */
public class Book05 {
    public static int n; // 모험가의 수
    public static List<Integer> fearLevelList = new ArrayList<>(); // 공포도 리스트

    public static int solution() {
        // 공포도가 낮은 것부터 확인하기 위해 오름차순 정렬
        Collections.sort(fearLevelList);

        // 현재 그룹에 포함된 모험가의 수
        int adventurers = 0;
        // 결성된 총 그룹의 수
        int groups = 0;

        for (int i = 0; i < n; i++) {
            // 현재 그룹에 모험가 참여
            adventurers++;

            // 현재 그룹에 포함된 모험가의 수가 공포도 이상이라면 그룹 결성
            if (adventurers >= fearLevelList.get(i)) {
                groups++;
                adventurers = 0; // 현재 그룹 초기화
            }
        }

        return groups;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            fearLevelList.add(scan.nextInt());
        }

        scan.close();

        System.out.println(solution());
    }
}
