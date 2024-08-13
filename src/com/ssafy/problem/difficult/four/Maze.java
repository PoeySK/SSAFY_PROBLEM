package com.ssafy.problem.difficult.four;
import java.io.*;
import java.util.*;

public class Maze {
    static int[] my = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] mx = {0, 0, -1, 1}; // 상 하 좌 우

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int test_case = 1; test_case <= 10; test_case++) {
            /* 입력 */
            int T = Integer.parseInt(br.readLine());
            int[][] m = new int[16][16];
            boolean[][] isCheck = new boolean[16][16];
            for (int i = 0; i < 16; i++) {
                String[] input = br.readLine().split("");
                for (int j = 0; j < 16; j++) {
                    m[i][j] = Integer.parseInt(input[j]);
                }
            }

            /* 작동 */
            int result = run(m, isCheck);

            /* 출력 */
            bw.write("#" + test_case + " " + result + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static int run(int[][] m, boolean[][] isCheck) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(1, 1));

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (m[now.y][now.x] == 3) {
                return 1;
            }

            if (isCheck[now.y][now.x]) {
                continue;
            }
            isCheck[now.y][now.x] = true;

            for (int i = 0; i < 4; i++) {
                int ny = now.y + my[i];
                int nx = now.x + mx[i];

                if (0 <= nx && nx < 16 && 0 <= ny && ny < 16) {
                    if (m[ny][nx] == 0 || m[ny][nx] == 3) {
                        q.add(new Node(ny, nx));
                    }
                }
            }
        }

        return 0;
    }
}
