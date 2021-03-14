package sorting;

import java.util.Scanner;
// 병합 정렬

class MergeSort {
    // 정렬 배열은 반드시 static으로 선언해 줘야 함
    // 필요할 떄마다, 배열을 생성한다고 하면 비효율적으로 작동함 (불필요한 메모리 사용 문제를 해결 하기 위해)
    static int[] sorted;    // 정렬 배열

    static void merge(int a[], int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = left;

        // 작은 순서대로 배열에 삽입
        while (i <= middle && j <= right) {
            if (a[i] <= a[j]) {
                sorted[k] = a[i];
                i++;
            } else {
                sorted[k] = a[j];
                j++;
            }
            k++;
        }

        // i가 모든 원소를 정렬배열에 넣었다면, 남은 j를 다 노넣어줘야함
        if (i > middle) {
            for (int t = j; t <= right; t++) {
                sorted[k] = a[t];
                k++;
            }
        } else {
            for (int t = i; t <= middle; t++) {
                sorted[k] = a[t];
                k++;
            }
        }
        // 정렬된 배열을 삽입
        for (int t = left; t <= right; t++) {
            a[t] = sorted[t];
        }
    }

    // 일단 반으로 나눈다 (재귀적으로 구현)
    static void mergeSort(int[] a, int m, int n) {
        // 크기가 1보터 큰 경우
        if (m < n) {
            int middle = (m + n) / 2;
            mergeSort(a, m, middle);
            mergeSort(a, middle + 1, n);
            merge(a, m, middle, n);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("병합 정렬");
        System.out.print("요솟수：");
        int n = sc.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = sc.nextInt();
        }
        sorted = new int[n];
        mergeSort(x, 0, n - 1);        // 배열 x를 병합 정렬합니다.

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < n; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}