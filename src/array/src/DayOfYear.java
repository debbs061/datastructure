package array.src;

import java.util.Scanner;

public class DayOfYear {
    // 각 달의 일수
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}  // 윤년
    };

    // year 년은 윤년인가? (윤년: 1 / 평년: 0)
    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    // y년 m월 d일의 그 해 경과 일수를 구함
    static int dayOfYear(int y, int m, int d) {
        int days = d;
        for (int i = 0; i < m-1; i++) { // 1월 ~ m-1월의 일 수를 더함
            days += mdays[isLeap(y)][i];
        }
        return days;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int retry; // 다시 한 번?

        System.out.println("그 해의 경과 일수를 구해주는 프로그램 입니다.");
        do {
            System.out.print("년 : ");
            int year = sc.nextInt();

            System.out.print("월 : ");
            int month = sc.nextInt();

            System.out.print("일 : ");
            int day = sc.nextInt();

            System.out.printf("그 해 %d일째입니다.\n", dayOfYear(year, month, day));

            System.out.println("한 번 더 할까요? (1.예 / 0. 아니오) : ");
            retry = sc.nextInt();
        } while (retry == 1);
    }
}
