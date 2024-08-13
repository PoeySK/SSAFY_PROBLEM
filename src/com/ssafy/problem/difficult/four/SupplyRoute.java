package com.ssafy.problem.difficult.four;

import java.io.*;
import java.util.*;

public class SupplyRoute {
    static int[] my = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] mx = {0, 0, -1, 1}; // 상 하 좌 우

    static class Coordination {
        int y;
        int x;

        public Coordination(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int test_case = 1; test_case <= 10; test_case++) {
            /* 입력 */
            int N = Integer.parseInt(br.readLine());
            int[][] l = new int[100][100];
            int start_y = 0, start_x = 0;
            for (int i = 0; i < 100; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < 100; j++) {
                    l[i][j] = Integer.parseInt(input[j]);
                    if (l[i][j] == 2) {
                        start_y = i;
                        start_x = j;
                    }
                }
            }

            /* 작동 */
            int result = run(l, start_y, start_x);

            /* 출력 */
            bw.write("#" + test_case + " " + result + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static int run(int[][] l, int start_y, int start_x) {
        Queue<Coordination> q = new ArrayDeque<>();
        q.add(new Coordination(start_y, start_x));
        int rlt = 0;
        while (!q.isEmpty()) {
            Coordination now = q.poll();
            int lx = now.x - 1;
            int rx = now.x + 1;
            int uy = now.y - 1;

            if (0 <= lx && l[now.y][lx] == 1) { // 왼쪽 길 판단
                while (l[now.y][lx] == 1) {
                    lx--;
                    if (lx < 1) {
                        break;
                    }
                }
                q.add(new Coordination(now.y - 1, lx + 1));
            } else if (rx < 100 && l[now.y][rx] == 1) { // 오른쪽 길 판단
                while (l[now.y][rx] == 1) {
                    rx++;
                    if (rx == 100) {
                        break;
                    }
                }
                q.add(new Coordination(now.y - 1, rx - 1));
            } else if (0 <= uy) { // 위쪽 길 판단
                while (l[uy][now.x] == 1) {
                    if (uy == 0) {
                        return now.x;
                    }

                    if (0 <= lx && l[uy][lx] == 1) {
                        q.add(new Coordination(uy, now.x));
                        break;
                    }
                    if (rx < 100 && l[uy][rx] == 1) {
                        q.add(new Coordination(uy, now.x));
                        break;
                    }
                    uy--;
                }
            }
            rlt = now.x;
        }

        return rlt;
    }
}
