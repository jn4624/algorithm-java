package com.algo.java.jnlim.greedy.book;

import java.util.*;

/**
 * 무지의 먹방 라이브 2회차 복습
 */
class EatTime implements Comparable<EatTime> {
    private int time;
    private int index;

    public EatTime(int time, int index) {
        this.time = time;
        this.index = index;
    }

    public int getTime() {
        return time;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(EatTime eatTime) {
        return Integer.compare(this.time, eatTime.time);
    }
}

public class Review10_02 {
    public static int[] food_times = {3, 1, 2};
    public static int k = 5;

    public static void main(String[] args) {
        int result = 0;

        long totalTime = 0;
        for (int time : food_times) {
            totalTime += time;
        }

        if (totalTime <= k) {
            result = -1;
        } else {
            PriorityQueue<EatTime> pq = new PriorityQueue<>(); // 시간이 짧은 음식부터 섭취를 위해 우선순위 큐 사용
            for (int i = 0; i < food_times.length; i++) {
                pq.offer(new EatTime(food_times[i], (i + 1)));
            }

            totalTime = 0; // 음식 섭취에 사용된 시간
            long prevTime = 0; // 직전 섭취에 사용된 시간
            long count = food_times.length; // 음식 개수

            while (totalTime + (pq.peek().getTime() - prevTime) * count <= k) {
                int nowTime = pq.poll().getTime();
                totalTime += (nowTime - prevTime) * count;
                count--;
                prevTime = nowTime;
            }

            List<EatTime> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                list.add(pq.poll());
            }

            Collections.sort(list, new Comparator<EatTime>() {
                @Override
                public int compare(EatTime o1, EatTime o2) {
                    return Integer.compare(o1.getIndex(), o2.getIndex());
                }
            });

            result = list.get((int) ((k - totalTime) % count)).getIndex();
        }

        System.out.println(result);
    }
}
