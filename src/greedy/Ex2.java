package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @문제 : 1이 될 때까지
 * @Link : https://github.com/ndb796/python-for-coding-test/blob/master/3/6.java
 * @Date : 2021/03/24
 */
public class Ex2 {
    // 방법 1) n과 k가 10만 이하의 정수이기 때문에 이 풀이도 가능하지만 시간복잡도 측면에서 떨어짐
    static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans = 0;

        while (true) {
            if (n % k == 0)
                n = n / k;
            else
                n -= 1;
            ans++;
            if (n == 1)
                break;
        }
        System.out.println(ans);
    }

    /* 방법 2) 반복문이 한 번 반복 될 때마다 바로 n이 k로 나누어지는 연산이 무조건 한 번 수행이 되기 때문에
              n이 기하급수적으로 빠르게 작아질 수 있는 방법이다. (-> log 시간복잡도가 나올 수 있음)
              n과 k가 100억 혹은 1000억이 넘어가는 수라도, log 시간복잡도로 해결 가능 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;
        while (true) {
            // (Skill)
            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            // n 이 k 로 나누어지지 않는다고 했을 때, 가장 가까운 k 로 나누어지는 수가 어떤건지
            // 찾고자 할 때 유용한 스킬. target 은 k 로 나누어지는 수가 된다.
            int target = (n / k) * k;
            result += (n - target);
            n = target;
            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) break;
            // K로 나누기
            result += 1;
            n /= k;
        }
        // n이 1보다 크다면, 1이 되도록 하기 위해서
        // 마지막으로 남은 수에 대하여 1씩 빼기
        result += (n - 1);
        System.out.println(result);
    }


}
