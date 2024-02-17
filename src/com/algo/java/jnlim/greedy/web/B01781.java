package com.algo.java.jnlim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 컵라면
 */
public class B01781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        Queue<Rules> rulesQueue = new PriorityQueue<>();
        Queue<Integer> ramenCountsQueue = new PriorityQueue<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rulesQueue.offer(new Rules(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while (!rulesQueue.isEmpty()) {
            int size = ramenCountsQueue.size();
            Rules rules = rulesQueue.poll();

            if (size < rules.deathLine) {
                ramenCountsQueue.offer(rules.ramenCount);
            } else if (size == rules.deathLine) {
                int ramenCount = ramenCountsQueue.peek();

                if (!ramenCountsQueue.isEmpty() && ramenCount < rules.ramenCount) {
                    ramenCountsQueue.poll();
                    ramenCountsQueue.offer(rules.ramenCount);
                }
            }
        }

        long result = 0;
        while (!ramenCountsQueue.isEmpty()) {
            result += ramenCountsQueue.poll();
        }

        System.out.println(result);
    }
}

class Rules implements Comparable<Rules> {
    int deathLine;
    int ramenCount;

    public Rules(int deathLine, int ramenCount) {
        this.deathLine = deathLine;
        this.ramenCount = ramenCount;
    }

    @Override
    public int compareTo(Rules rules) {
        // 데드라인이 같은 경우
        if (this.deathLine == rules.deathLine) {
            // 컵라면 갯수로 오름차순 정렬
            return rules.ramenCount - this.ramenCount;
        }

        // 데드라인으로 내림차순 정렬
        return this.deathLine - rules.deathLine;
    }
}
