package com.ssafy.problem.difficult.four;

import java.io.*;
import java.util.*;

public class ConnectingPlate {
    static String[][] p;
    static Set<String> set;
    static int[] my = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] mx = {0, 0, -1, 1}; // 상 하 좌 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            /* 입력 */
            p = new String[4][4];
            set = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < 4; j++) {
                    p[i][j] = input[j];
                }
            }

            /* 작동 */
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    run(i, j, p[i][j]); // 모든 위치에서 시작
                }
            }

            /* 출력 */
            bw.write("#" + test_case + " " + set.size() + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static void run(int y, int x, String number) {
        if (number.length() == 7) {
            set.add(number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + my[i];
            int nx = x + mx[i];

            if (0 <= ny && ny < 4 && 0 <= nx && nx < 4) {
                String sumNumber = number + p[ny][nx];
                run(ny, nx, sumNumber);
            }
        }

    }
}
