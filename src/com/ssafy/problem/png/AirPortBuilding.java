package com.ssafy.problem.png;

import java.io.*;
import java.util.*;

public class AirPortBuilding {
    static int N, K, saveX1, saveX2, saveY1, saveY2;
    static boolean[][] areaCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            /* 입력 */
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);

            int[][] ground = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] arrInput = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    ground[i][j] = Integer.parseInt(arrInput[j]);
                }
            }

            /* 작동 */
            int result = run(ground);

            /* 출력 */
            bw.write("\n#" + test_case + " " + result + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static int run(int[][] ground) {
        ArrayList<Integer> area = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                saveX2 = j;
                saveY2 = i;
                areaCheck = new boolean[N][N];
                areaCheck[i][j] = true;
                int rightMax = Math.max(ground[i][j], ground[i][j + 1]);
                int rightMin = Math.min(ground[i][j], ground[i][j + 1]);
                int downMax = Math.max(ground[i][j], ground[i + 1][j]);
                int downMin = Math.min(ground[i][j], ground[i + 1][j]);
                isRightCheck(ground, i, j, rightMax, rightMin);
                isDownCheck(ground, i, j, downMax, downMin);

                int xLen = saveX2 - saveX1 == 0 ? 1 : Math.abs(saveX1 - saveX2) + 1;
                int yLen = saveY2 - saveY1 == 0 ? 1 : Math.abs(saveY2 - saveY1) + 1;
                area.add(xLen * yLen);

                System.out.println("i:" + i + " j:" + j + " / saveY1:" + saveY1 + " saveX1:" + saveX1 + " saveY2:" + saveY2 + " saveX2:" + saveX2);
                for (int k = 0; k < N; k++) {
                    System.out.println(Arrays.toString(areaCheck[k]));
                }
                System.out.println(xLen * yLen);
                System.out.println();
            }
        }
        for (int i = 0; i < area.size(); i++) {
            System.out.print(area.get(i) + " ");
        }

        return Collections.max(area);
    }

    static void isDownCheck(int[][] ground, int i, int j, int max, int min) {
        int dIndex = i + 1;
        if (dIndex == N) {
            return;
        }
        while (max - min <= K) {
            areaCheck[dIndex][j] = true;
            dIndex++;
            if (dIndex == N) {
                break;
            }
            int down = ground[dIndex][j];
            max = Math.max(down, max);
            min = Math.min(min, down);
            isRightCheck(ground, dIndex, j, max, min);
        }

        if (max - min <= K) {
            areaCheck[dIndex - 1][j] = false;
        }
        saveY1 = dIndex - 1;
    }

    static void isRightCheck(int[][] ground, int i, int j, int max, int min) {
        int rIndex = j + 1;
        if (rIndex == N) {
            return;
        }

        while (max - min <= K) {
            areaCheck[i][rIndex] = true;
            rIndex++;
            if (rIndex == N) {
                break;
            }
            int right = ground[i][rIndex];
            max = Math.max(right, max);
            min = Math.min(min, right);
            isDownCheck(ground, i, rIndex, max, min);
        }
        if (max - min <= K) {
            areaCheck[i][rIndex - 1] = false;
        }
        saveX1 = rIndex - 1;
    }
}
/*
1
5 3
7 7 4 0 0
3 6 6 7 1
7 0 5 5 7
4 8 3 2 4
6 0 6 8 1

 */
