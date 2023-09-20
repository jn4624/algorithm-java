package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 강의실 배정
 * https://www.acmicpc.net/problem/11000
 */
public class B11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Room> rooms = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            rooms.add(new Room(startTime, endTime));
        }

        Collections.sort(rooms, new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                if(o1.S == o2.S) {
                    return o1.T - o2.T;
                }
                else {
                    return o1.S - o2.S;
                }
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(rooms.get(0).T);

        for(int i = 1; i < N; i++) {
            if(pq.peek() <= rooms.get(i).S) {
                pq.poll();
            }
            pq.offer(rooms.get(i).T);
        }

        System.out.println(pq.size());
    }
}

class Room{
    int S = 0;
    int T = 0;

    public Room(int s, int t) {
        this.S = s;
        this.T = t;
    }
}