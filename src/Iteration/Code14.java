package Iteration;

import java.util.Scanner;

/**
 * 사용자로부터 n개의 정수를 입력받은 후 오름차순으로 정렬(sort)
 * 맨 처음부터 두 원소를 비교하며 가장 큰 값이 맨 마지막으로 배치됨.
 * -> 그리고 그 마지막 배치된걸 제외하고 나머지끼리 다시 비교
 */
public class Code14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int data[] = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        for (int i = n - 1; i > 0; i--) { // 인덱스 n-1부터
            // data[0] .. data[i] -> 에서 가장 큰 값을 data[i]로 넣음
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    // swap data[j] and data[j+1]
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
        System.out.println("Sorted data: ");
        for (int i = 0; i < n; i++) {
            System.out.println(data[i]);
        }
    }
}
