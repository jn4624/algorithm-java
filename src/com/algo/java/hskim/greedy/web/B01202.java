package com.algo.java.hskim.greedy.web;

import java.util.*;

/**
 * 보석 도둑
 * https://www.acmicpc.net/problem/1202
 * 다시
 */
public class B01202 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        ArrayList<Gem> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = scan.nextInt();
            int v = scan.nextInt();
            list.add(new Gem(m, v));
        }

        Collections.sort(list, (o1, o2) -> o1.m - o2.m);

        int[] weight = new int[k];
        for (int i = 0; i < k; i++) {
            weight[i] = scan.nextInt();
        }

        Arrays.sort(weight);

        long total = 0;
        int listIdx = 0;

        PriorityQueue<Gem> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);

        for (int i = 0; i < k; i++) {
            while (listIdx < n && list.get(listIdx).m <= weight[i]) {
                Gem current = list.get(listIdx++);
                pq.add(new Gem(current.m, current.v));
            }
            if (!pq.isEmpty()) total += pq.poll().v;
        }

        System.out.println(total);
    }
}

class Gem {
    int m;
    int v;

    public Gem(int m, int v) {
        this.m = m;
        this.v = v;
    }
}