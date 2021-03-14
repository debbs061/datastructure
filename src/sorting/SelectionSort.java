package sorting;

import java.util.Scanner;

public class SelectionSort {
    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    // 가장 작은 것을 선택해서 앞으로 보낸다 (exchange)
    // 앞에 있는 원소가 하나씩 줄어드는 방법
    static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) { // 가장 작은걸 앞으로 보낸다음 그 앞 원소를 제외하고 다시 선택
            int min = i;            // 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 기록합니다.
            for (int j = i + 1; j < n; j++)
                if (a[j] < a[min])
                    min = j;
            swap(a, i, min);        // 아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소를 교환합니다.
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 선택 정렬");
        System.out.print("요솟수：");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        selectionSort(x, nx);            // 배열x를 단순선택정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }

}
