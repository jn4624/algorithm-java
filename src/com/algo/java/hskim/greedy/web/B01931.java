package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 회의실 배정
 * https://www.acmicpc.net/problem/1931
 */
public class B01931 {
    /** [2023-08-26]
     * 556ms
     * 종료시간 기준으로 compare 오버라이딩했을 시 통과(시작시간 기준으로 compare 구현했을 시 실패)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        int result = 0;

        Meeting[] arr = new Meeting[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i] = new Meeting(start, end);
        }

        List<Meeting> list = Arrays.asList(arr);
        MeetingSort meetingSort = new MeetingSort();
        Collections.sort(list, meetingSort);

        int prevStartTime = 0;

        for(int i = 0; i < list.size(); i++){
            Meeting curr = list.get(i);

            if(prevStartTime <= curr.startHour) {
                prevStartTime = curr.endHour;
                result++;
            }
        }

        System.out.println(result);
    }
}

class Meeting {
    int startHour = 0;
    int endHour = 0;

    Meeting(int start, int end) {
        this.startHour = start;
        this.endHour = end;
    }
}

class MeetingSort implements Comparator<Meeting> {
    @Override
    public int compare(Meeting o1, Meeting o2) {
        if(o1.endHour == o2.endHour) {
            return o1.startHour - o2.startHour;
        }

        return o1.endHour - o2.endHour;
    }
}

/** 실패한 방법
 1. 시작시간 기준으로 회의 수 오름차순 정렬
 2. 정렬된 2차원 배열을 자기 자신과 비교(arr[i][j] < arr[i][j+1])
 2-1. 시작시간 종료시간 차가 더 작은 원소(배열)을 반환
 2-2. 회의 개수++
 2-3. 반환된 배열의 종료시간과 같거나 큰 시작시간 회의를 찾는다
 2-4. '2' 반복

 11
 0 6 = 6
 1 4 = 3
 2 13 = 11
 3 5 = 2
 3 8 = 5
 5 7 = 2
 5 9  = 4
 6 10 = 4
 8 11 = 3
 8 12 = 4
 12 14 = 2

public class B01931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        int result = 1;

        Meeting[] arr = new Meeting[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i] = new Meeting(start, end);
        }

        List<Meeting> list = Arrays.asList(arr);
        Collections.sort(list);

        Meeting prev = list.get(0);
        Meeting curr = list.get(1);

        int prevDiff = prev.endHour - prev.startHour;
        int currDiff = curr.endHour - curr.startHour;

        if(prevDiff > currDiff) {
            prev = list.get(1);
        }

        for(int i = 2; i <= list.size()-1; i++) {
            curr = list.get(i);

            if(prev.endHour <= curr.startHour) {
                if(i == list.size()-1) {
                    result++;
                    break;
                }

                prev = curr;
                curr = list.get(++i);

                prevDiff = prev.endHour - prev.startHour;
                currDiff = curr.endHour - curr.startHour;

                if(prevDiff > currDiff) {
                    prev = list.get(i);
                }

                result++;
            }
        }

        System.out.println(result);
    }
}

class Meeting implements Comparable<Meeting> {
    int startHour = 0;
    int endHour = 0;

    Meeting(int start, int end) {
        this.startHour = start;
        this.endHour = end;
    }

    @Override
    public int compareTo(Meeting o) {
        return this.startHour - o.startHour;
    }
}
 */