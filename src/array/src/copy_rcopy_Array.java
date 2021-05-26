package array.src;

/**
 * 배열 b의 모든 요소를 배열 a에  copy 하는 메소드
 * 배열 b의 모든 요소를 배열 a에 역순으로 copy 하는 메소드
 */
public class copy_rcopy_Array {

    static void copy(int[] a, int[] b) {
        int num = a.length <= b.length ? a.length : b.length;
        for (int i = 0; i < num; i++) {
            a[i] = b[i];
        }
    }

    static void rcopy(int[] a, int[] b) {
        int num = a.length <= b.length ? a.length : b.length;
        for (int i = 0; i < num; i++) {
            a[i] = b[b.length - i - 1];
        }
    }

}
