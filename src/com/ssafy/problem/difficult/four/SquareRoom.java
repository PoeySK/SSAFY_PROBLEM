package com.ssafy.problem.difficult.four;

import java.io.*;
import java.util.*;

public class SquareRoom {
    static int N;
    static int[][] field;
    static Node[] adj;
    static int[] dy = {-1, 1, 0, 0,};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            /* 입력 */
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            field = new int[N][N];
            int max = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    field[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, field[i][j]);
                }
            }

            /* 작동 */
            adj = new Node[max + 1];
            adj[0] = new Node(0, 0);
            run();
            int size = 0;
            int idx = 0;
            for (int i = 1; i <= max; i++) {
                if (size < adj[i].size) {
                    idx = i;
                    size = adj[i].size;
                }
            }

            /* 출력 */
            bw.write("#" + test_case + " " + idx + " " + size + "\n");
        }
        br.close();
        bw.close();
    }

    private static void run() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                adj[field[i][j]] = new Node(field[i][j], 1);
                moveDfs(i, j, field[i][j]);
            }
        }
    }

    private static void moveDfs(int y, int x, int start) {
        int number = field[y][x];
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0 <= ny && ny < N && 0 <= nx && nx < N && field[ny][nx] == number + 1) {
                moveDfs(ny, nx, start);
                adj[start].size++;
            }
        }
    }

    static class Node {
        int idx;
        int size;

        Node(int idx, int size) {
            this.idx = idx;
            this.size = size;
        }
    }
}
