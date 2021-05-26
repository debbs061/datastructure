package array.src;

// 1,000 이하의 소수를 열거
public class PrimeNumber1 {
    public static void main(String[] args) {
        int counter = 0;  // 성능 비교를 위해 나눗셈 횟수를 변수로 지정

        for (int n = 2; n <= 1000; n++) {
            int i;
            for (i = 2; i < n; i++) {
                counter++;
                if (n % i == 0) {   // 나누어 떨어지면 소수가 아니므로 더이상의 반복은 필요 없음
                    break;
                }
            }
            if (n == i) {
                System.out.println(n);
            }
        }
        System.out.println("나눗셈 수행 횟수 : " + counter);
    }
}
