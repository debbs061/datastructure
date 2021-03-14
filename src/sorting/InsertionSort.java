package sorting;

import java.util.Scanner;

public class InsertionSort {
    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    //단순 삽입 정렬
    static void insertionSort(int[] a, int n) {
        int j;
        for (int i = 0; i < n; i++) {
            j = i; // 현재 정렬할 원소를 선택해서 적절한 위치에 삽입하기 위함
            while (j > 0 && a[j - 1] > a[j]) {
                swap(a, j - 1, j);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수：");
        int n = sc.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = sc.nextInt();
        }

        insertionSort(x, n);                // 배열 x를 단순교환정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < n; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
