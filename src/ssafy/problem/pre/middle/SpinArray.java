package ssafy.problem.pre.middle;

import java.io.*;

public class SpinArray {
    static int N;
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            /* 입력 */
            N = Integer.parseInt(br.readLine());
            arr = new String[N][N];

            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 0; k < N; k++) {
                    arr[j][k] = input[k];
                }
            }

            /* 작동 */
            String[][] rlt = run();

            /* 출력 */
            bw.write("#" + i + "\n");
            for(int j=0; j<N; j++) {
                for (int k=0; k<3; k++) {
                    bw.write(rlt[j][k] + " ");
                }
                bw.write("\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static String[][] run() {
        String[][] result = new String[N][3];

        for (int i = 0; i < N; i++) {
            int index = 0;
            // 90도
            StringBuilder temp90 = new StringBuilder();
            for (int j = N - 1; j >= 0; j--) {
                temp90.append(arr[j][i]);
            }
            result[i][index++] = temp90.toString();

            // 180도
            StringBuilder temp180 = new StringBuilder();
            for (int k = N - 1; k >= 0; k--) {
                temp180.append(arr[N - (i + 1)][k]);
            }
            result[i][index++] = temp180.toString();

            // 270도
            StringBuilder temp270 = new StringBuilder();
            for (int k = 0; k < N; k++) {
                temp270.append(arr[k][N - (i + 1)]);
            }
            result[i][index] = temp270.toString();
        }

        return result;
    }
}

/*
2
3
1 2 3
4 5 6
7 8 9
6
6 9 4 7 0 5
8 9 9 2 6 5
6 8 5 4 9 8
2 2 7 7 8 4
7 5 1 9 7 9
8 9 3 9 7 6

 */