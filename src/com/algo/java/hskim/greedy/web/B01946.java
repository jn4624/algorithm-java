package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 신입 사원
 * https://www.acmicpc.net/problem/1946
 */
public class B01946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            Npc[] npc = new Npc[N];

            for(int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                npc[j] = new Npc(doc, interview);
            }

            List<Npc> testCase = Arrays.asList(npc);
            NpcSort npcSort = new NpcSort();    //서류 기준 정렬
            Collections.sort(testCase, npcSort);

            int peak = Integer.MAX_VALUE;
            int result = 0;

            for(int k = 0; k < testCase.size(); k++) {
                Npc curr = testCase.get(k);

                if(peak > curr.interview) {
                    peak = curr.interview;
                    result++;
                }
            }

            System.out.println(result);
        }
    }

    /** idea
     1. 서류 또는 면접 순위로 오름차순 정렬(내가 푼 코드는 서류 기준 정렬)
     2. 가장 먼저 뽑힌 신입사원의 인터뷰 순위보다 높은 인터뷰 순위를 갖고 있는 신입사원을 뽑는다(숫자 자체로 비교하면 더 작은 수)
     3. 2번 반복

     서류  인터뷰
     1      4 (서류 기준 정렬시 가장 먼저 뽑힐 신입사원, 인터뷰 : 4)
     2      5 (4 > 5 = 탈락)
     3      6 (4 > 6 = 탈락)
     4      2 (4 > 2 = 합격)
     5      7 (2 > 7 = 탈락)
     6      1 (2 > 1 = 합격)
     7      3 (1 > 3 = 탈락)
     */
}

class Npc {
    int doc = 0;
    int interview = 0;

    public Npc(int doc, int interview) {
        this.doc = doc;
        this.interview = interview;
    }
}

class NpcSort implements Comparator<Npc> {
    @Override
    public int compare(Npc o1, Npc o2) {
        return o1.doc - o2.doc;
    }
}
