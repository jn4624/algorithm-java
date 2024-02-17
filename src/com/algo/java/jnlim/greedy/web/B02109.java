package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 순회강연
 */
public class B02109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lectureCount = Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> lecturePriorityQueue = new PriorityQueue<>();

        for (int i=0; i<lectureCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int lecturePay = Integer.parseInt(st.nextToken());
            int lectureDay = Integer.parseInt(st.nextToken());

            lecturePriorityQueue.offer(new Lecture(lecturePay, lectureDay));
        }

        // 강연료 오름차순
        PriorityQueue<Integer> lecturePayQueue = new PriorityQueue<>();

        while (!lecturePriorityQueue.isEmpty()) {
            Lecture lecture = lecturePriorityQueue.poll();
            lecturePayQueue.offer(lecture.pay);

            if (lecturePayQueue.size() > lecture.day) {
                lecturePayQueue.poll();
            }
        }

        int result = 0;
        while (!lecturePayQueue.isEmpty()) {
            result += lecturePayQueue.poll();
        }

        System.out.println(result);
    }
}

class Lecture implements Comparable<Lecture> {

    int pay;
    int day;

    public Lecture(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture lecture) {
        // 강연 기간 오름차순
        return this.day - lecture.day;
    }

}
