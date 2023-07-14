package com.algo.java.jnlim.greedy.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Review05_01 {
    private static int n;
    private static List<Integer> fearLevelList = new ArrayList<>();

    public static void main(String[] args) {
        init();

        Collections.sort(fearLevelList);

        int adventurer = 0; // 참여 모험가 수
        int groups = 0; // 결성 그룹 수

        for (int i = 0; i < n; i++) {
            adventurer++;

            // 참여한 모험가의 수가 공포도 이상이라면 그룹 결성
            if (adventurer >= fearLevelList.get(i)) {
                groups++;
                adventurer = 0;
            }
        }

        System.out.println(groups);
    }

    public static void init() {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            fearLevelList.add(scan.nextInt());
        }

        scan.close();
    }
}
