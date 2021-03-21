package sorting;

import java.util.Scanner;

public class InsertionSort {
    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    // selectionSort, bubbleSort : 이미 정렬이 이루어져 있는 상태여도, 반드시 반복을 수행함 (비효율적)
    // insertionSort : '필요할 때만' 위치를 바꿈. 앞에 있는 원소들이 이미 정렬되어 있다고 가정.
    static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {       // 인덱스 i부터 1까지 1씩 감소하며 반복
            for (int j = i; j > 0; j--) {   // 한 칸씩 왼쪽으로 이동
                if (a[j] < a[j - 1])
                    swap(a, j, j - 1);
                else    // 자기보다 작은 데이터를 만나면 그 위치에서 멈춤 (그 앞의 원소들은 이미 정렬되어 있다고 가정하기 때문)
                    break;
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
