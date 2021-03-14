package sorting;

import java.util.Scanner;

public class HeapSort {
    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    static void heapSort(int a[], int n) {
        // 먼저 전체 트리 구조를 최대 힙 구조로 바꿈 ( 1부터 시작하는 down-heapify)
        for (int i = 1; i < n; i++) {
            int c = i;
            // 재귀적으로 계속 자기 부모 노드로 이동하면서, 힙 구조를 만들어주는 것임
            do {
                int root = (c-1) / 2; // 특정한 원소의 부모를 가리킴
                if (a[root] < a[c]) // 부모의 값보다 자식의 값이 크면 위치를 바꿔준다
                    swap(a, root, c);

                // 루트를 한단계 올려서 위에부분도 다 heapify 수행시켜줌
                c = root;
            } while (c != 0);
        }

        // 크기를 줄여가며 반복적으로 힙 구성 (크기를 줄이고 -> 힙을 만들어주고, 크기를 줄이고 -> 힙을 만들어주고..
        // 이 과정을 n번 반복하면 힙 정렬이 만들어지는 것
        for (int i = n - 1; i >= 0; i--) {
            // 1) 가장 큰 값을 맨 뒤로 보냄
            swap(a, 0, i);  // 가장 큰 값(0번 인덱스) 와 가장 뒤에 있는 노드를 바꿔줌

            // 2) 최대 힙 구조가 무너졌으므로, 다시 힙 구조를 만듬
            int root = 0;
            int c = 1;
            do {
                c = 2 * root + 1;   // root 의 자식 (root부터 down-heapify 해줌)
                // 자식 중에 더 큰 값 찾기
                // c < i-1 ::: 범위를 벗어나지 않게 해준거임 ( 오른쪽자식은 c < i 니까 왼쪽은 c < i-1)
                if (c < i - 1 && a[c] < a[c + 1]) { // 왼쪽 자식보다 오른쪽 자식이 더 크다면, 더 큰 값을 c에 담는다
                    c++;
                }
                // 루트보다 자식이 크다면 교환
                if (c < i && a[root] < a[c]) {
                    swap(a, root, c);
                }
                root = c; // 다시 c를 root로 이동시켜 downheapify 진행
            } while (c < i);
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
