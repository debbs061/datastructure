package sorting;

import java.util.Scanner;

public class QuickSort {
    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    // 퀵정렬 (재귀버전)
    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2];

        // 배열을 pivot을 기준으로 분할
        do {
            while (a[pl] < x)   // a[pl] >= x 가 성립하는 요소를 찾을 때까지 pl을 오른쪽으로 스캔
                pl++;
            while (a[pr] > x)   // a[pr] <= x 가 성립하는 요소를 찾을 때까지 pr을 왼쪽으로 스캔
                pr--;
            if (pl <= pr)       // pl이 가리키는 요소와 pr이 가리키는 요소 교환
                swap(a, pl++, pr--);    // 교환 끝난 후 각각 한칸씩 이동해줘야 함
        } while (pl <= pr);   // pl과 pr이 교차하면 그룹이 나누는 과정이 끝난다 (pl > pr이 되는 순간)

        /*
         피벗 이하의 그룹 : a[0], ... , a[pl-1]
         피벗 이상의 그룹 : a[pr+1], ... , a[n-1]
         */

        // 정복 : 각각을 다시 recursion으로 정렬
        // 요소의 개수가 1개인 그룹은 더 이상 그룹을 나눌 필요가 없음
        if (left < pr) // 왼쪽 부분배열 정렬
            quickSort(a, left, pr);
        if (pl < right) // 오른쪽 부분배열 정렬
            quickSort(a, pl, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.println("요소 수");
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
