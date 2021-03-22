package sorting.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @FileName : 두 배열의 원소 교체
 * @Link : https://github.com/ndb796/python-for-coding-test/blob/master/6/12.java
 * @Date : 2021/03/23
 */
public class Ex1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer a[] = new Integer[n];
        Integer b[] = new Integer[n];

        // 배열 A의 모든 원소 입력받기
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            a[j] = Integer.parseInt(st.nextToken());
        }
        // 배열 B의 모든 원소 입력받기
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            b[j] = Integer.parseInt(st.nextToken());
        }

        // 배열 A는 오름차순 정렬 수행
        Arrays.sort(a);
        // 배열 B는 내림차순 정렬 수행 (Collections 라이브러리의 reverseOrder 메소드 이용)
        Arrays.sort(b, Collections.reverseOrder());

        // 첫 번째 인덱스부터 확인하며, 두 배열의 원소를 최대 K번 비교
        for (int i = 0; i < k; i++) {
            if (a[i] < b[n - 1 - i]) {
                int tmp = a[i];
                a[i] = b[n - 1 - i];
                b[n - 1 - i] = tmp;
            } else
                break;
        }

        // 배열 A의 모든 원소의 합을 출력
        int max = 0;
        for (int i = 0; i < n; i++) {
            max += a[i];
        }
        System.out.println(max);
    }
}
