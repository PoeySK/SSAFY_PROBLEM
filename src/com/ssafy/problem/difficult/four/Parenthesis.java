package com.ssafy.problem.difficult.four;

import java.io.*;
import java.util.*;

public class Parenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int test_cast = 1; test_cast <= 10; test_cast++) {
            /* 입력 */
            int N = Integer.parseInt(br.readLine());

            String[] input = br.readLine().split("");
            /* 작동 */
            boolean isCheck = run(input, N);

            /* 출력 */
            bw.write("#" + test_cast + " " + (isCheck ? 1 : 0) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static boolean run(String[] str, int N) {
        int small = 0;
        int middle = 0;
        int big = 0;
        int cut = 0;

        for (int i = 0; i < N; i++) {
            if (str[i].equals("(")) {
                small++;
            } else if (str[i].equals("{")) {
                middle++;
            } else if (str[i].equals("[")) {
                big++;
            } else if (str[i].equals("<")) {
                cut++;
            } else if (str[i].equals(")")) {
                small--;
            } else if (str[i].equals("}")) {
                middle--;
            } else if (str[i].equals("]")) {
                big--;
            } else if (str[i].equals(">")) {
                cut--;
            }

            if (small < 0 || middle < 0 || big < 0 || cut < 0) {
                return false;
            }
        }
        return small == 0 && middle == 0 && big == 0 && cut == 0;
    }
}

