import java.util.Scanner;

/**
 * Ordered list 에 insert 하는 알고리즘 (Bubble sort 개념 존재)
 * 현재까지 입력된 정수들을 정렬된 상태로 출력하라
 * ex) 입력: 4  .. 5 2 1 9
 */
public class Code15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int data[] = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            int j = i - 1;
            // ordered list에 insert 하는 알고리즘은, 뒤에서부터 비교해가며 한칸씩 뒤로 밀려주는게 제일 빠름
            while (j >= 0 && data[j] > tmp) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = tmp;
            for (int k = 0; k < i + 1; k++) {
                System.out.print(data[k] + " ");
            }
            System.out.println();
        }
    }
}
