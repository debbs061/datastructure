package sorting;

import java.util.Scanner;

public class QuickSort {
    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    // 퀵정렬 (재귀버전)
    static void quickSort(int[] a, int start, int end) {
        if (start >= end) // 원소가 1개인 경우 종료
            return;
        int pivot = start; // 피벗은 첫 번째 원소
        int left = start + 1;
        int right = end;

        while (left <= right) { // 두 원소가 엇갈리기 전까지 탐색
            // pivot 보다 큰 데이터를 찾을 때까지 반복
            while (left <= end && a[left] <= a[pivot])
                left += 1;
            // pivot 보다 작은 데이터를 찾을 때까지 반복
            while (right > start && a[right] >= a[pivot])
                right -= 1;
            // 엇갈렸다면 작은 데이터와 pivot 을 교체 (여기서 작은 데이터는 right 값임)
            if (left > right)
                swap(a, right, pivot);
            // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
            else
                swap(a, left, right);
        }
        // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행 (재귀적으로)
        quickSort(a, start, right - 1);
        quickSort(a, right+1, end);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요소 수 : ");
        int n = sc.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }

        quickSort(x, 0, n - 1); // 배열 x를 퀵 정렬

        System.out.println("오름차순으로 정렬");
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }

    }

}
