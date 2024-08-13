package com.ssafy.exam.recursive;

import java.util.*;

public class RecursiveTest {
    static int[] arr = {1, 3, 5};
    static boolean[] isVisit = new boolean[arr.length];

    public static void main(String[] args) {
//        c(0, 0, new int[3]);
//        h(0, new int[arr.length]);
//        p(0, new int[arr.length]);
        s(0);
    }


    // 조합 clear !!
    private static void c(int idx, int k, int[] sel) {
        // basis part
        if (k == sel.length) {
            for (int i = 0; i < sel.length; i++) {
                System.out.print(sel[i] + " ");
            }
            System.out.println();
            return;
        }
        if (idx == arr.length) {
            return;
        }

        // inductive part
        sel[k] = arr[idx];
        c(idx + 1, k + 1, sel);
        c(idx + 1, k, sel);
    }

    // 중복 순열 clear !!
    private static void h(int idx, int[] sel) {
        // basis part
        if (idx == arr.length) {
            for (int i = 0; i < sel.length; i++) {
                System.out.print(sel[i] + " ");
            }
            System.out.println();
            return;
        }

        // inductive part
        for (int i = 0; i < arr.length; i++) {
            sel[idx] = arr[i];
            h(idx + 1, sel);
        }
    }

    // 순열 clear!!
    private static void p(int idx, int[] sel) {
        // basis part
        if (idx == arr.length) {
            for (int i = 0; i < sel.length; i++) {
                System.out.print(sel[i] + " ");
            }
            System.out.println();
            return;
        }

        // inductive part
        for (int i = 0; i < arr.length; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                sel[idx] = arr[i];
                p(idx + 1, sel);
                isVisit[i] = false;
            }
        }
    }

    // 부분 집합 clear !!
    private static void s(int idx) {
        // basis part
        if (idx == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if (isVisit[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        // inductive part
        isVisit[idx] = true;
        s(idx + 1);

        isVisit[idx] = false;
        s(idx + 1);
    }
}