package com.ssafy.problem.difficult.two;

import java.io.*;
import java.util.*;

public class HundredProject {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            /* 입력 */
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] m = new int[N];
            for (int i = 0; i < N; i++) {
                m[i] = Integer.parseInt(input[i]);
            }

            /* 작동 */
            long result = run(m, N);

            /* 출력 */
            bw.write("#" + test_case + " " + result + "\n");
        }
        br.close();
        bw.close();
        bw.close();
    }

    static long run(int[] m, int N) {
        int max = m[N - 1];
        long result = 0;
        for (int i = N - 2; i >= 0; i--) {
            if (max > m[i]) {
                result += max - m[i];
            } else {
                max = m[i];
            }
        }
        return result;
    }
}