package com.ssafy.problem.pre.middle;

import java.util.Scanner;

public class RemoveFly {
    static int N, M, max = 0;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            /* 입력 */
            String[] str = sc.nextLine().split(" ");
            N = Integer.parseInt(str[0]);
            M = Integer.parseInt(str[1]);
            max = 0;

            arr = new int[N][N];

            // 배열 생성
            for (int i = 0; i < N; i++) {
                String[] input = sc.nextLine().split(" ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }

            /* 작동 */
            run();

            /* 출력 */
            System.out.println("#" + test_case + " " + max);
        }
    }

    public static void run() {
        // 직선 이동
        int[] sy = {-1, 1, 0, 0}; // 상 하 좌 우
        int[] sx = {0, 0, -1, 1}; // 상 하 좌 우
        // 대각 이동
        int[] dy = {-1, -1, 1, 1}; // 북 북 남 남
        int[] dx = {-1, 1, -1, 1}; // 서 동 서 동

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int ps = arr[i][j];
                int xs = arr[i][j];
                for (int k = 0; k < 4; k++) {
                    int nsy = i + sy[k];
                    int nsx = j + sx[k];
                    int ndy = i + dy[k];
                    int ndx = j + dx[k];
                    // 직선 합
                    if (0 <= nsy && nsy < N && 0 <= nsx && nsx < N) {
                        ps = plusSum(nsy, nsx);
                    }
                    // 대각 합
                    if (0 <= ndy && ndy < N && 0 <= ndx && ndx < N) {
                        xs = xSum(ndy, ndx);
                    }
                    int rlt = Math.max(ps, xs);
                    max = Math.max(rlt, max);
                }
            }
        }
    }

    public static int plusSum(int y, int x) {
        int result = arr[y][x];

        for (int i = 1; i < M; i++) {
            if (0 <= y - i) { // 상
                result += arr[y - i][x];
            }
            if (y + i < N) { // 하
                result += arr[y + i][x];
            }
            if (0 <= x - i) { // 좌
                result += arr[y][x - i];
            }
            if (x + i < N) { // 우
                result += arr[y][x + i];
            }
        }
        return result;
    }

    public static int xSum(int y, int x) {
        int result = arr[y][x];

        for (int i = 1; i < M; i++) { // 북서
            if (0 <= y - i && 0 <= x - i) {
                result += arr[y - i][x - i];
            }
            if (0 <= y - i && x + i < N) { // 북동
                result += arr[y - i][x + i];
            }
            if (y + i < N && 0 <= x - i) { // 남서
                result += arr[y + i][x - i];
            }
            if (y + i < N && x + i < N) { // 남동
                result += arr[y + i][x + i];
            }
        }
        return result;
    }
}
