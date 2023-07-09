package com.algo.java.hskim.greedy.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Food implements Comparable<Food> {
    private int time;
    private int index;

    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    public int getTime() {
        return this.time;
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public int compareTo(Food other) {
        return Integer.compare(this.time, other.time);
    }
}

public class Book10 {
    /**
     * 06.무지의 먹방 라이브(p316)
     * 같은 문제 3회 풀기
     *
     * https://school.programmers.co.kr/learn/courses/30/lessons/42891
     */

    /**
     * 1회차 : 2023-07-09
     * 답 확인 함
     *
     * #1. 시간복잡도
     * #2. Queue & Priority Queue
     * #3. Tuple
     * #4. Heap
     * #5. Linked List
     * #6. 완전이진트리
     */
    public static int solution01(int[] food_times, long k) {
        long summary = 0;
        for (int i = 0; i < food_times.length; i++) {
            summary += food_times[i];
        }
        if (summary <= k) return -1;

        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }

        summary = 0;
        long previous = 0;
        long length = food_times.length;

        while (summary + ((pq.peek().getTime() - previous) * length) <= k) {
            int now = pq.poll().getTime();
            summary += (now - previous) * length;
            length -= 1;
            previous = now;
        }

        ArrayList<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food a, Food b) {
                return Integer.compare(a.getIndex(), b.getIndex());
            }
        });
        return result.get((int) ((k - summary) % length)).getIndex();
    }

    /**
     * 1회차 : 2023-07-07
     정확성  테스트
     테스트 1 〉	실패 (0.02ms, 75.1MB)
     테스트 2 〉	실패 (0.03ms, 77.1MB)
     테스트 3 〉	실패 (0.02ms, 68.1MB)
     테스트 4 〉	실패 (0.02ms, 76.8MB)
     테스트 5 〉	실패 (런타임 에러)
     테스트 6 〉	실패 (0.02ms, 73.5MB)
     테스트 7 〉	실패 (0.02ms, 77MB)
     테스트 8 〉	실패 (런타임 에러)
     테스트 9 〉	실패 (런타임 에러)
     테스트 10 〉	실패 (런타임 에러)
     테스트 11 〉	실패 (런타임 에러)
     테스트 12 〉	실패 (0.02ms, 77.2MB)
     테스트 13 〉	실패 (런타임 에러)
     테스트 14 〉	실패 (런타임 에러)
     테스트 15 〉	실패 (런타임 에러)
     테스트 16 〉	실패 (0.02ms, 77.5MB)
     테스트 17 〉	실패 (런타임 에러)
     테스트 18 〉	실패 (0.03ms, 79.8MB)
     테스트 19 〉	실패 (0.03ms, 76.3MB)
     테스트 20 〉	실패 (런타임 에러)
     테스트 21 〉	실패 (0.19ms, 76.9MB)
     테스트 22 〉	실패 (런타임 에러)
     테스트 23 〉	통과 (0.30ms, 75.8MB)
     테스트 24 〉	실패 (런타임 에러)
     테스트 25 〉	실패 (0.49ms, 67.1MB)
     테스트 26 〉	실패 (런타임 에러)
     테스트 27 〉	실패 (7.09ms, 85.2MB)
     테스트 28 〉	실패 (0.03ms, 74.8MB)
     테스트 29 〉	실패 (0.02ms, 80.6MB)
     테스트 30 〉	실패 (0.04ms, 81.2MB)
     테스트 31 〉	실패 (0.03ms, 67.1MB)
     테스트 32 〉	실패 (0.02ms, 79.6MB)
     효율성  테스트
     테스트 1 〉	실패 (시간 초과)
     테스트 2 〉	실패 (시간 초과)
     테스트 3 〉	실패 (시간 초과)
     테스트 4 〉	실패 (시간 초과)
     테스트 5 〉	실패 (시간 초과)
     테스트 6 〉	실패 (시간 초과)
     테스트 7 〉	실패 (시간 초과)
     테스트 8 〉	실패 (시간 초과)
     채점 결과
     정확성: 1.3
     효율성: 0.0
     합계: 1.3 / 100.0
     */
    public static int solution01_fail(int[] food_times, long k) {
        int index = 0;

        for(int i = 1; i <= k; i++) {
            int num = food_times[index];

            if(num == 0) {
                num = food_times[++index];
            }

            food_times[index] = num - 1;

            if((index+1) == food_times.length) {
                index = 0;
            }
            else {
                index++;
            }
        }

        if(food_times[index] <= 0) {
            return -1;
        }
        else {
            return food_times[index];
        }
    }
    public static void main(String[] args) {
        int[] food_times = {3,1,2};
        long k = 5;

        System.out.println(solution01(food_times, k));
    }
}
