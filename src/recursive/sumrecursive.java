package recursive;

/**
 * 재귀함수로 총합 구하기
 */
public class sumrecursive {
    public static void main(String[] args) {
        int sum = sumRecursive(10);

        System.out.println(sum);

        sum = sumRecursive(100);

        System.out.println(sum); // 5050

        sum = sumRecursive(1000);

        System.out.println(sum); // 500500

        sum = sumRecursive(100000); // ?? -> 재귀함수도 그 수가 너무 커지면 StackOverflowError 가 발생

        System.out.println(sum);
    }

    private static int sumRecursive(int n) {
        if (n <= 1) {
            return n;
        }

        return n + sumRecursive(n - 1);
    }
}
