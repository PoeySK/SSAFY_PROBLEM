package ssafy.problem.pre.middle;

import java.io.*;

public class TwoNumberArray {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            /* 입력 */
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);

            String[] inputA = br.readLine().split(" ");
            int[] Ai = new int[N];
            for (int i = 0; i < N; i++) {
                Ai[i] = Integer.parseInt(inputA[i]);
            }

            String[] inputB = br.readLine().split(" ");
            int[] Bj = new int[M];
            for (int i = 0; i < M; i++) {
                Bj[i] = Integer.parseInt(inputB[i]);
            }

            /* 작동 */
            int len = Math.min(Ai.length, Bj.length); // 더 짧은 길이
            int cha = Math.abs(Ai.length - Bj.length) + 1;

            int max = 0;
            for (int i = 0; i < cha; i++) {
                int result = 0;
                for (int j = 0; j < len; j++) {
                    if (Ai.length < Bj.length) {
                        result += Ai[j] * Bj[j + i];
                    } else { // Ai.length >= Bj.length
                        result += Ai[j + i] * Bj[j];
                    }
                }
                max = Math.max(max, result);
            }

            /* 출력 */
            bw.write("#" + test_case + " " + max + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

/*
2
3 5
1 5 3
3 6 -7 5 4
7 6
6 0 5 5 -1 1 6
-4 1 8 7 -9 3

 */