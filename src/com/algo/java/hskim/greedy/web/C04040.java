package com.algo.java.hskim.greedy.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 펜션
 * https://codeup.kr/problem.php?id=4040
 */
public class C04040 {
    public static void main(String[] args) throws IOException {
        int result = solution01();
        System.out.println(result);
    }

    /**
     * 풀이봄
     */
    private void solution02() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j+1] = s.charAt(j) == 'O' ? 1 : 0;
            }
        }
        for (int i = n-1; i >= 1; i--) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 0) continue;
                arr[i][j] += arr[i+1][j];
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int total = 0;
        while (s<t) {
            total++;
            int max = 0;
            for (int j = 1; j <= m; j++) {
                max = Math.max(max, arr[s][j]);
            }
            if (max == 0) {
                System.out.println(-1);
                return;
            }
            s += max;
        }
        System.out.println(total-1);
    }

    /**
     * 1회차 : 2023-07-30
     * 시간 모잘라서 스탑됨.
     */
    public static int solution01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] reserveStatus = new String[n][m];
        int[][] room = new int[2][m+1];

        for(int i = 0; i < n; i++) {   //기간
            String str = br.readLine();
            String[] arr = str.split("");

            for(int j = 0; j < arr.length; j++) {  //방 개수
                reserveStatus[i][j] = arr[j];
            }
        }

        for(int i = 0; i < m; i++) {
            int index = 0;  //i방의 연속 예약 가능 시작날
            int count = 0;  //i방의 연속 예약 가능 최대 일수

            for(int j = 0; j < n-1; j++) {
                String curr = reserveStatus[i][j];
                String next = reserveStatus[i][j+1];

                if(curr.equals("0") && next.equals("0")) {
                    room[0][i] += 1;

                    if(count == 0) { //최초 인덱스 저장이라면
                        room[1][i] = j;
                    }
                }
                else if(curr.equals("0") && !next.equals("0")) {
                    int temp = room[0][i]+1;

                    if(count < temp) { //이전에 저장해놓은 연속 카운트가 있다면 비교
                        room[1][i] = j - room[0][i];
                        room[0][i] = temp; //다음 연속 카운트 저장을 위해
                    }
                    else {
                        count = temp; //최초 연속 카운트 저장
                    }

                    room[0][i] = 0; //초기화
                }
            }

            room[0][i] = count;
            room[1][i] = index;
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int days = s;
        int result = 0;

        while(days < t) {
            for(int i = 0; i < room[1].length; i++) {
                int in = room[1][i] + 1;
                int roomCount = room[0][i];

                if(in == days) {
                    days += room[0][i];
                    result++;
                }
            }
        }

        return result;
    }
}
