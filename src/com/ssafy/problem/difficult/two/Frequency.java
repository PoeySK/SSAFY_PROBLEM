package com.ssafy.problem.difficult.two;

import java.io.*;
import java.util.*;

public class Frequency {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            /* 입력 */
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            /* 작동 */
            int result = run(input);

            /* 출력 */
            bw.write("#" + test_case + " " + result + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static int run(String[] input) {
        int max = 0;
        int result = 0;
        for (int i = 1; i <= 1000; i++) {
            int value = Collections.frequency(Arrays.asList(input), Integer.toString(i));
            if (max <= value) {
                max = value;
                result = i;
            }
        }

        return result;
    }
}
