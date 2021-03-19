package Iteration;

import java.util.Scanner;

/**
 *  n개의 음이 아닌 한 자리 정수를 입력받아 배열에 저장
 *  이들 중에서 1개 이상의 연속된 정수들을 이어붙여 얻을 수 있는 소수들 중에서 최대값을 구하여 출력하라
 */
public class Code13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int data[] = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            StringBuffer sum = new StringBuffer();
            for (int j = i; j < n; j++) {
                boolean isPrime = true;
                sum.append(data[j]);
                int newSum = Integer.parseInt(String.valueOf(sum));
                for (int k = 2; k * k <= newSum; k++) {
                    if (newSum % k == 0) {
                        isPrime = false;
                        break;
                    }
                }
                // 위의 소수판별식은 1보다 크다고 가정하고 소수찾는 방법이므로.. (1은 소수가 아니므로 뺴줘야함)
                if (isPrime && newSum > 1 && newSum > max) {
                    max = newSum;
                }
            }
        }
        System.out.println(max);
    }
}
