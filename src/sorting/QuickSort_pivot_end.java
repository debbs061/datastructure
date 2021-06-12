package sorting;

import java.util.Scanner;

public class QuickSort_pivot_end {
    public static void quickSort(int[] nums) {
        quickSortRecursive(nums, 0, nums.length - 1);
    }

    public static void quickSortRecursive(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotPos = partition(nums, left, right); // 정렬 후, 최종적으로 정렬된 index 위치

        quickSortRecursive(nums, left, pivotPos - 1);
        quickSortRecursive(nums, pivotPos + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right]; // 가장 오른쪽 요소를 pivot 값으로 지정

        int i = left;
        for (int j = left; j < right; ++j) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        int pivotPos = i;
        swap(nums, pivotPos, right);
        return pivotPos;
    }

    public static void swap(int a[], int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
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

        quickSort(x); // 배열 x를 퀵 정렬

        System.out.println("오름차순으로 정렬");
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }
}
