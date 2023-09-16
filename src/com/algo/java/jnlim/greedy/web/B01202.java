package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 보석 도둑
 */
public class B01202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalJewelryCount = Integer.parseInt(st.nextToken());
        int totalBagCount = Integer.parseInt(st.nextToken());

        List<Jewelry> jewelries = new ArrayList<>();
        for (int i = 0; i < totalJewelryCount; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewelries.add(new Jewelry(weight, price));
        }

        int[] bags = new int[totalBagCount];
        for (int i = 0; i < totalBagCount; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 가방의 무게 오름차순으로 정렬
        Arrays.sort(bags);
        // 보석의 무게를 기준으로 오름차순 정렬
        Collections.sort(jewelries);

        // 가격 내림차순 정렬
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));

        int index = 0;
        long result = 0;

        for (int i = 0; i < totalBagCount; i++) {
            while (true) {
                if (index >= totalJewelryCount)
                    break;

                Jewelry jewelry = jewelries.get(index);
                // 쥬얼리의 무게가 가방의 무게보다 크다면 반복문 탈출
                if (bags[i] < jewelry.getWeight())
                    break;

                // 쥬얼리 무게가 가방의 무게보다 작거나 같다면 queue에 해당 쥬얼리의 가격 추가
                pq.add(jewelry.getPrice());
                index++;
            }

            if (!pq.isEmpty()) {
                result += Math.abs(pq.poll());
            }
        }

        System.out.println(result);
    }
}

class Jewelry implements Comparable<Jewelry> {
    private int weight;
    private int price;

    public Jewelry(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Jewelry o) {
        return this.weight - o.getWeight();
    }
}
