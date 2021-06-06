package search.src;

public class searchRotatedArray {

    public static void main(String[] args) {

    }

    private static int indexOfRotatedArray(int[] arry, int start, int end, int num) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arry[mid] == num) {
            return mid;
        }

        // 경우 1. start 부터 mid 까지 정렬되어 있는 경우 -> 중간에 튀는애가 내 뒤에 있다는 것임
        if (arry[start] <= arry[mid]) {
            if (num >= arry[start] && num <= arry[mid]) {
                // num 이 정렬된 곳 사이에 있다는 것이니까 이진탐색처럼 찾으면 됨.
                return indexOfRotatedArray(arry, start, mid - 1, num);
            }
            // 그렇지 않다면 mid+1부터 end까지의 범위를 탐
            return indexOfRotatedArray(arry, mid + 1, end, num);
        }

        // 경우 2. mid 에서 end 까지 수가 정렬된 경우 -> start ~ mid 까지는 정렬이 안되어있다는 소
        if (num >= arry[mid] && num <= arry[end]) {
            return indexOfRotatedArray(arry, mid + 1, end, num);
        }

        // 그렇지 않다면 start 부터 mid-1 까지의 범위를 탐
        return indexOfRotatedArray(arry, start, mid - 1, num);

    }
}

