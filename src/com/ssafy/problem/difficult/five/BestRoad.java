package com.ssafy.problem.difficult.five;

import java.io.*;
import java.util.*;

public class BestRoad {
    static int N, result;
    static ArrayList<Node> co;
    static boolean[] isCheck;
    static Node home, company;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            /* 입력 */
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            co = new ArrayList<>();
            for (int i = 0; i < N + 2; i++) {
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                co.add(new Node(y, x));
            }

            /* 작동 */
            company = co.remove(0);
            home = co.remove(0);
            isCheck = new boolean[N];
            result = Integer.MAX_VALUE;
            run(0, new int[N]);

            /* 출력 */
            bw.write("#" + test_case + " " + result + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void run(int r, int[] sel) {
        if (r == N) {
            int sum = path(company, co.get(sel[0]));
            for (int i = 0; i < N - 1; i++) {
                sum += path(co.get(sel[i]), co.get(sel[i + 1]));
            }
            sum += path(co.get(sel[N - 1]), home);
            result = Math.min(result, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isCheck[i]) {
                isCheck[i] = true;
                sel[r] = i;
                run(r + 1, sel);
                isCheck[i] = false;
            }
        }
    }

    private static int path(Node a, Node b) {
        int y1 = a.y;
        int y2 = b.y;
        int x1 = a.x;
        int x2 = b.x;

        return Math.abs(y2 - y1) + Math.abs(x2 - x1);
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


}
