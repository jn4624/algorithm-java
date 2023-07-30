package com.algo.java.hskim.greedy.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 06.무지의 먹방 라이브(p316)
 * 같은 문제 3회 풀기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42891
 */
public class Review10_01 {
    public static void main(String[] args) {
        int[] food_times = {3,1,2};
        long k = 5;

        Solution01 solutionClass = new Solution01();

        System.out.println(solutionClass.solution02(food_times, k));
    }
}

class Food01 implements Comparable<Food01> {
    private int time;
    private int index;

    public Food01(int time, int index) {
        this.time = time;
        this.index = index;
    }

    public int getTime() {
        return this.time;
    }

    public int getIndex() {
        return this.index;
    }

    // 시간이 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Food01 other) {
        return Integer.compare(this.time, other.time);
    }
}
class Solution01 {
    public int solution02(int[] food_times, long k) {
        // 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
        long summary = 0;
        for (int i = 0; i < food_times.length; i++) {
            summary += food_times[i];
        }
        if (summary <= k) return -1;

        // 시간이 작은 음식부터 빼야 하므로 우선순위 큐를 이용
        PriorityQueue<Food01> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            // (음식 시간, 음식 번호) 형태로 우선순위 큐에 삽입
            pq.offer(new Food01(food_times[i], i + 1));
        }

        summary = 0; // 먹기 위해 사용한 시간
        long previous = 0; // 직전에 다 먹은 음식 시간
        long length = food_times.length; // 남은 음식의 개수

        // summary + (현재의 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k 비교
        while (summary + ((pq.peek().getTime() - previous) * length) <= k) {
            int now = pq.poll().getTime();
            summary += (now - previous) * length;
            length -= 1; // 다 먹은 음식 제외
            previous = now; // 이전 음식 시간 재설정
        }

        // 남은 음식 중에서 몇 번째 음식인지 확인하여 출력
        ArrayList<Food01> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        // 음식의 번호 기준으로 정렬
        Collections.sort(result, new Comparator<Food01>() {
            @Override
            public int compare(Food01 a, Food01 b) {
                return Integer.compare(a.getIndex(), b.getIndex());
            }
        });
        return result.get((int) ((k - summary) % length)).getIndex();
    }

    /**
     * 정확성  테스트
     * 테스트 1 〉	실패 (0.03ms, 76.7MB)
     * 테스트 2 〉	실패 (0.04ms, 75.9MB)
     * 테스트 3 〉	실패 (0.02ms, 76.5MB)
     * 테스트 4 〉	실패 (0.03ms, 76.3MB)
     * 테스트 5 〉	실패 (0.03ms, 77.7MB)
     * 테스트 6 〉	실패 (0.02ms, 77.7MB)
     * 테스트 7 〉	실패 (0.03ms, 77.6MB)
     * 테스트 8 〉	실패 (0.03ms, 78.3MB)
     * 테스트 9 〉	실패 (0.03ms, 75.9MB)
     * 테스트 10 〉	실패 (0.03ms, 77.2MB)
     * 테스트 11 〉	실패 (0.02ms, 74.3MB)
     * 테스트 12 〉	실패 (0.02ms, 79.6MB)
     * 테스트 13 〉	실패 (0.02ms, 74.9MB)
     * 테스트 14 〉	실패 (0.03ms, 71.2MB)
     * 테스트 15 〉	실패 (0.05ms, 73.8MB)
     * 테스트 16 〉	실패 (0.02ms, 75.4MB)
     * 테스트 17 〉	통과 (0.02ms, 74.5MB)
     * 테스트 18 〉	실패 (0.02ms, 76.6MB)
     * 테스트 19 〉	실패 (0.02ms, 73.8MB)
     * 테스트 20 〉	실패 (0.02ms, 76MB)
     * 테스트 21 〉	실패 (0.02ms, 77MB)
     * 테스트 22 〉	실패 (0.03ms, 78.3MB)
     * 테스트 23 〉	실패 (0.02ms, 72.3MB)
     * 테스트 24 〉	실패 (0.02ms, 76.7MB)
     * 테스트 25 〉	실패 (0.02ms, 79.4MB)
     * 테스트 26 〉	실패 (0.03ms, 77.2MB)
     * 테스트 27 〉	실패 (0.02ms, 75.3MB)
     * 테스트 28 〉	실패 (0.03ms, 73.8MB)
     * 테스트 29 〉	실패 (0.03ms, 74.5MB)
     * 테스트 30 〉	실패 (0.03ms, 73MB)
     * 테스트 31 〉	실패 (0.02ms, 75.9MB)
     * 테스트 32 〉	실패 (0.02ms, 75.1MB)
     *
     * 효율성  테스트
     * 테스트 1 〉	실패 (4.26ms, 61.6MB)
     * 테스트 2 〉	실패 (4.20ms, 61.6MB)
     * 테스트 3 〉	실패 (0.02ms, 61.9MB)
     * 테스트 4 〉	실패 (4.31ms, 61.4MB)
     * 테스트 5 〉	실패 (0.02ms, 61.9MB)
     * 테스트 6 〉	실패 (0.03ms, 61.8MB)
     * 테스트 7 〉	실패 (0.02ms, 61.5MB)
     * 테스트 8 〉	실패 (0.02ms, 62.2MB)
     *
     * 채점 결과
     * 정확성: 1.3
     * 효율성: 0.0
     * 합계: 1.3 / 100.0
     *
     *
     * 테스트 1
     * 입력값 〉	[3, 1, 2], 5
     * 기댓값 〉	1
     * 실행 결과 〉	테스트를 통과하였습니다.
     *
     * 테스트 2
     * 입력값 〉	[200, 39, 983], 4
     * 기댓값 〉	0
     * 실행 결과 〉	테스트를 통과하였습니다.
     */
    public static int solution01(int[] food_times, long k) {
        int answer = 0;
        int index = (int) k + 1;
        int num = index / (int) k;

        if(index-3 >= 3) {
            index %= 3;
        }

        for(int i = 0; i < food_times.length; i++) {
            food_times[i] -= num;

            if(i == index) {
                if(food_times[i] <= 0) {
                    index++;

                    if(index == food_times.length) {
                        index = 0;
                    }
                }
                else {
                    answer = index+1;
                    break;
                }
            }
        }

        return answer;
    }
}