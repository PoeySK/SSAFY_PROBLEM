package com.ssafy.problem.difficult.four;

import java.io.*;
import java.util.*;

public class Hanaro {
    static int N;
    static double E;
    static ArrayList<Node>[] island;

    static class Node implements Comparable<Node> {
        int w;
        double L;

        public Node(int w, double L) {
            this.w = w;
            this.L = L;
        }

        @Override
        public int compareTo(Node n) {
            return Double.compare(this.L, n.L);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            /* 입력 */
            N = Integer.parseInt(br.readLine());
            island = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                island[i] = new ArrayList<>();
            }

            String[] inputX = br.readLine().split(" ");
            String[] inputY = br.readLine().split(" ");
            E = Double.parseDouble(br.readLine());
            for (int i = 0; i < N; i++) {
                int x1 = Integer.parseInt(inputX[i]);
                int y1 = Integer.parseInt(inputY[i]);
                for (int j = 0; j < N; j++) {
                    int x2 = Integer.parseInt(inputX[j]);
                    int y2 = Integer.parseInt(inputY[j]);
                    double L = len(y1, y2, x1, x2);
                    island[i].add(new Node(j, L));
                }
            }

            /* 작동 */
            long rlt = Math.round(run());

            /* 출력 */
            bw.write("#" + test_case + " " + rlt + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static double run() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] isCheck = new boolean[N];

        pq.add(new Node(0, 0));
        double result = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int v = node.w;

            if (isCheck[v])
                continue;
            isCheck[v] = true;

            result += cal(node.L);

            for (int i = 0; i < N; i++) {
                if (isCheck[island[v].get(i).w])
                    continue;
                pq.add(island[v].get(i));
            }
        }

        return result;
    }

    // 거리 -> 제곱할 예정이므로 루트 사용 안함
    static double len(int y1, int y2, int x1, int x2) {
        return Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2);
    }

    // 세금 계산
    static double cal(double L) {
        return E * L;
    }
}
