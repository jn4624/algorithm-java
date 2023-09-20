package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 강의실 배정
 */
public class B11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        List<LectureRoom> lectureRooms = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectureRooms.add(new LectureRoom(start, end));
        }

        /**
         * 시작 시간을 기준으로 오름차순 하되
         * 시작 시간이 같다면 종료 시간을 기준으로 오름차순 처리
         */
        Collections.sort(lectureRooms);

        Queue<Integer> pq = new PriorityQueue<>();

        int endTime = 0;
        for (LectureRoom room : lectureRooms) {
            endTime = room.end;

            /**
             * 우선 순위 큐에 담긴 가장 작은 종료 시간과
             * 강의실 시작 시간을 비교
             */
            if (!pq.isEmpty() && pq.peek() <= room.start) {
                pq.poll();
            }

            pq.add(endTime);
        }

        System.out.println(pq.size());
    }
}

class LectureRoom implements Comparable<LectureRoom> {
    public int start;
    public int end;

    public LectureRoom(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(LectureRoom o) {
        if (this.start == o.start) {
            return this.end - o.end;
        } else {
            return this.start - o.start;
        }
    }
}
