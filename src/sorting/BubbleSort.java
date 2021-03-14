package sorting;

import java.util.Scanner;

class BubbleSort {
    // 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 앞에서부터 두 원소를 비교하며 swaping.
    // 결국 가장 큰 값이 맨 뒤로 이동. 뒤데 있는 원소가 하나씩 줄어들면서 정렬함
    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("버블 정렬(버전 3)");
        System.out.print("요솟수：");
        int n = sc.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = sc.nextInt();
        }

        bubbleSort(x, n);                // 배열 x를 단순교환정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < n; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
