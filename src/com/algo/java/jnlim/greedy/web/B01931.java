package com.algo.java.jnlim.greedy.web;

import java.util.*;

/**
 * 회의실 배정
 */
class Time {
    int start; // 시작 시간
    int end; // 종료 시간

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

public class B01931 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        List<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            times.add(new Time(scan.nextInt(), scan.nextInt()));
        }

        scan.close();

        // 종료 시간을 기준으로 정렬
        Collections.sort(times, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if (o1.getEnd() == o2.getEnd()) {
                    return o1.getStart() - o2.getStart();
                }
                return o1.getEnd() - o2.getEnd();
            }
        });

        int count = 0;
        int prevEndTime = 0;

        for (int i = 0; i < n; i++) {
            // 직전 종료 시간이 다음 시작 시간보다 작거나 같다면
            if (prevEndTime <= times.get(i).getStart()) {
                // 직전 종료 시간 초기화
                prevEndTime = times.get(i).getEnd();
                count++;
            }
        }

        System.out.println(count);
    }
}
