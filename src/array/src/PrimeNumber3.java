package array.src;

// 1,000 이하 소수 찾기
public class PrimeNumber3 {
    public static void main(String[] args) {
        int counter = 0;  // 이 알고리즘이 처리 비용을 얼마나 요구하는지 저장하는 변수
        int primeCtn = 0; // 찾은 소수의 개수
        int[] prime = new int[500]; // 소수를 저장하는 배열

        prime[primeCtn++] = 2;
        prime[primeCtn++] = 3;

        for (int n = 5; n <= 1000; n += 2) {
            boolean flag = false;
            for (int i = 1; prime[i] * prime[i] <= n; i++) {
                counter += 2;   // 곱하기와 나눗셈 연산이 들어가므로 count 2번 해줌
                if (n % prime[i] == 0) {     // n 이 소수인 경우
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                prime[primeCtn++] = n;
                counter++;  // !flag면 곱셈 연산은 counting 이 안됐으므로
            }
        }

        for (int i = 0; i < primeCtn; i++) {
            System.out.println(prime[i]);
        }
        System.out.println("알고리즘 성능: " + counter);
    }
}
