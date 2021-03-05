/**
 * 1에서 100000 사이의 모든 소수를 출력하라
 */
public class Code10 {
    public static void main(String[] args) {

        for (int n = 2; n <= 100000; n++) {
            boolean isPrime = true;
            // n의 약수가 n/2보다 클 수 없기 때문에 2, 3, ..., n/2까지만 체크하면 됨
            // (개선) 2, 3, ..., sqrt(n) 루트(n)까지만 돌면 됨
            // 왜? 약수는 쌍으로 존재. 하나가 루트 n보다 크면 다른 하나는 반드시 루트 n보다 작아야 함
            // (둘다 루트n보다 클 순 없음. 그러면 곱하면 n보다 커버리니까)
            for (int i = 2; i * i <= n; i++) {
                //for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {  // not prime (소수) 가 아닌 경우
                    isPrime = false;
                    break;         // 개선 -> n에 대한 약수가 하나라도 찾아지면 소수가 아니라는 거니깐 검사를 멈춰야함
                }
            }

            if (isPrime) {
                System.out.println(n);
            }
        }

    }
}
