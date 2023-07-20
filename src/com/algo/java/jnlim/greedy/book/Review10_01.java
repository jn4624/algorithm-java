package com.algo.java.jnlim.greedy.book;

import java.util.*;

/**
 * 무지의 먹방 라이브 1회차 복습
 */
public class Review10_01 {
    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        int k = 5;

        System.out.println(solution(food_times, k));
    }

    public static int solution(int[] food_times, long k) {
        long sum = 0;
        for (int time : food_times) {
            sum += time;
        }

        if (sum <= k) {
            return -1;
        }

        PriorityQueue<FoodTime> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            priorityQueue.offer(new FoodTime(food_times[i], (i + 1)));
        }

        sum = 0;
        long prevTime = 0;
        long count = food_times.length;

        while (sum + (priorityQueue.peek().getTime() - prevTime) * count <= k) {
            int nowTime = priorityQueue.poll().getTime();
            sum += (nowTime - prevTime) * count;
            count--;
            prevTime = nowTime;
        }

        List<FoodTime> answer = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            answer.add(priorityQueue.poll());
        }

        Collections.sort(answer, new Comparator<FoodTime>() {
            @Override
            public int compare(FoodTime o1, FoodTime o2) {
                return Integer.compare(o1.getIndex(), o2.getIndex());
            }
        });

        return answer.get((int) ((k - sum) % count)).getIndex();
    }
}

class FoodTime implements Comparable<FoodTime> {
    private int time;
    private int index;

    public FoodTime(int time, int index) {
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
    public int compareTo(FoodTime foodTime) {
        return Integer.compare(this.time, foodTime.time);
    }
}
