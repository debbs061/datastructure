package recursive;

/**
 * 꼬리 재귀함수로 총합 구하기
 */
public class sumtailrecursive {
    public static void main(String[] args) {
        int sum = sumTailRecursive(10, 0);

        System.out.println(sum); // 55

        sum = sumTailRecursive(100, 0);

        System.out.println(sum); // 5050

        sum = sumTailRecursive(1000, 0);

        System.out.println(sum); // 500500

        sum = sumTailRecursive(100000, 0); // ??

        System.out.println(sum);
    }

    private static int sumTailRecursive(int n, int sum) {
        if (n <= 0) {
            return sum;
        }

        return sumTailRecursive(n-1, sum+n);
    }
}
