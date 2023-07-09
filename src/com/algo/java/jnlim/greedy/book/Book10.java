package com.algo.java.jnlim.greedy.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 무지의 먹방 라이브 (+10)
 * <p>
 * 정확성 테스트
 * 테스트 1 〉	통과 (1.32ms, 78.1MB)
 * 테스트 2 〉	통과 (0.96ms, 75.6MB)
 * 테스트 3 〉	통과 (1.14ms, 73.1MB)
 * 테스트 4 〉	통과 (0.97ms, 77.1MB)
 * 테스트 5 〉	통과 (1.15ms, 77.3MB)
 * 테스트 6 〉	통과 (1.03ms, 76.8MB)
 * 테스트 7 〉	통과 (0.92ms, 73.2MB)
 * 테스트 8 〉	통과 (0.87ms, 75.4MB)
 * 테스트 9 〉	통과 (0.89ms, 72.7MB)
 * 테스트 10 〉	통과 (0.94ms, 75.9MB)
 * 테스트 11 〉	통과 (0.95ms, 75.2MB)
 * 테스트 12 〉	통과 (0.98ms, 75MB)
 * 테스트 13 〉	통과 (1.24ms, 79.5MB)
 * 테스트 14 〉	통과 (0.84ms, 72MB)
 * 테스트 15 〉	통과 (0.92ms, 80.9MB)
 * 테스트 16 〉	통과 (0.03ms, 78MB)
 * 테스트 17 〉	통과 (1.28ms, 77.5MB)
 * 테스트 18 〉	통과 (0.91ms, 74.9MB)
 * 테스트 19 〉	통과 (0.02ms, 75.3MB)
 * 테스트 20 〉	통과 (0.03ms, 76.7MB)
 * 테스트 21 〉	통과 (1.43ms, 73.8MB)
 * 테스트 22 〉	통과 (1.61ms, 74.9MB)
 * 테스트 23 〉	통과 (0.02ms, 70.7MB)
 * 테스트 24 〉	통과 (3.57ms, 75.8MB)
 * 테스트 25 〉	통과 (4.71ms, 66.3MB)
 * 테스트 26 〉	통과 (4.48ms, 76.2MB)
 * 테스트 27 〉	통과 (4.58ms, 74.9MB)
 * 테스트 28 〉	통과 (1.15ms, 77.7MB)
 * 테스트 29 〉	통과 (0.94ms, 70.2MB)
 * 테스트 30 〉	통과 (0.97ms, 75.7MB)
 * 테스트 31 〉	통과 (0.90ms, 74.9MB)
 * 테스트 32 〉	통과 (1.05ms, 70.1MB)
 * <p>
 * 효율성 테스트
 * 테스트 1 〉	통과 (260.57ms, 74.2MB)
 * 테스트 2 〉	통과 (57.68ms, 71.6MB)
 * 테스트 3 〉	통과 (168.89ms, 72.2MB)
 * 테스트 4 〉	통과 (174.52ms, 73.9MB)
 * 테스트 5 〉	통과 (233.18ms, 73.9MB)
 * 테스트 6 〉	통과 (232.05ms, 74.3MB)
 * 테스트 7 〉	통과 (238.00ms, 74MB)
 * 테스트 8 〉	통과 (399.60ms, 92MB)
 * <p>
 * 채점 결과
 * 정확성: 42.9
 * 효율성: 57.1
 * 합계: 100.0 / 100.0
 */
public class Book10 {
    public int solution(int[] food_times, long k) {
        // 총 음식을 먹는 시간보다 네트워크 장애 발생 시간이 크거나 같을 경우 더 섭취해야 할 음식이 없는 경우이므로 -1 return
        long summary = 0;
        for (int time : food_times) {
            summary += time;
        }
        if (summary <= k) return -1;

        // 시간이 짧은 음식부터 섭취해야 하므로 우선순위 큐 사용
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }

        summary = 0; // 음식 섭취에 사용한 시간
        long previous = 0; // 직전에 모두 섭취한 음식의 시간
        long count = food_times.length; // 남은 음식의 개수

        while (summary + ((pq.peek().getTime() - previous) * count) <= k) {
            int now = pq.poll().getTime();
            summary += (now - previous) * count;
            count--; // 다 먹은 음식 제외 처리
            previous = now; // 이전 음식 섭취 시간 재설정
        }

        // 몇번 째 음식이 남았는지 확인 처리
        ArrayList<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // 음식 번호 기준으로 정렬
        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return Integer.compare(o1.getIndex(), o2.getIndex());
            }
        });

        return result.get((int) ((k - summary) % count)).getIndex();
    }

    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        long k = 5;

        System.out.println(new Book10().solution(food_times, k));
    }
}

class Food implements Comparable<Food> {
    private int time;
    private int index;

    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    public int getTime() {
        return time;
    }

    public int getIndex() {
        return index;
    }

    // 시간이 짧은 음식부터 높은 우선 순위를 부여하기 위해
    @Override
    public int compareTo(Food other) {
        return Integer.compare(this.time, other.time);
    }
}
