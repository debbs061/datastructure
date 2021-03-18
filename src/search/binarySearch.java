package search;

/**
 * @FileName :
 * @Link : https://www.acmicpc.net/problem/
 * @Date : 2021/03/19
 */
public class binarySearch {
    // 이진 탐색 (반복문)
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    // 이진 탐색 (recursive)
    public static int binarySearch2(int[] arr, int target, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (target == arr[mid])
            return mid;
        else if (target < arr[mid])
            return binarySearch2(arr, target, start, mid - 1);
        else
            return binarySearch2(arr, target, mid + 1, end);
    }
}
