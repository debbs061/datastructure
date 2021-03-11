package sorting;

import java.util.Scanner;

public class HeapSort {
    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    // 배열 a를 left부터 right까지 힙 구조로 만든다
    static void downHeap(int[] a, int left, int right) {
        int root = a[left];
        int child;
        int parent;

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1;
            int cr = cl + 1;
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl; // 왼쪽자식,오른쪽자식 중 큰값을 선택
            if (root >= a[child])   // 부모가 자식노드보다 더 크면 종료
                break;
            a[parent] = a[child]; // 부모가 자식노드보다 작으면 exchange 한 후
        }
        a[parent] = root; // 부모 노드 변경
    }

    static void heapSort(int[] a, int n) {
        // 힙 정렬을 하기 위해서는 먼저, 배열을 힙 구조로 만들어야 함
        // 힙 구조가 아닌 트리를 힙 구조로 만들 때, 전체 개수에서 1/2개만 보면 됨
        for (int i = (n - 1) / 2; i >= 0; i--)
            downHeap(a, i, n - 1);

        // 힙 구조를 가지고 힙 정렬 수행하기
        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i); // root 요소와 마지막 요소 교환
            downHeap(a, 0, i - 1); // root 요소가 마지막으로 갔으니까(max값), 그거 제외하고 다시 heapify
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수：");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        heapSort(x, nx); // 배열 x를 힙 정렬합니다.

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] ::: " + x[i]);
    }
}
