package array.src;

// 1,000 이하의 소수를 나열
// 핵심 : 981 이라는 숫자가 소수인지 아닌지 판별할 때 2부터 980까지로 나누어보면서 확인하는게 아니라
// '소수'로 나누어떨어지는 지 여부만 확인하면 된다 (중복을 피할 수 있다)
class PrimeNumber2 {
    public static void main(String[] args) {
        int counter = 0;
        int cnt = 0; // 여태까지 찾은 소수의 개수
        int[] prime = new int[500]; // 소수를 저장하는 배열

        prime[cnt++] = 2; // 2는 소수니까 일단 넣고 시작하자.

        for (int n = 3; n <= 1000; n += 2) { // 짝수는 검사할 필요 없음. 어차피 소수가 아니므로.
            int i;
            for (i = 1; i < cnt; i++) { // 소수로만 나눠봐서 소수인지 아닌지 판별하는게 핵심
                counter++;
                if (n % prime[i] == 0) {
                    break;
                }
            }
            if (cnt == i)   // 마지막까지 나누어떨어지지 않은 것이므로 소수라고 배열에 저장
                prime[cnt++] = n;
        }

        for (int i = 0; i < cnt; i++) {
            System.out.println(prime[i]);
        }

        System.out.println("나눗셈 수행 횟수: " + counter);

    }
}