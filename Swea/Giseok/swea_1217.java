/**
 * 1217. [S/W 문제해결 기본] 4일차 - 거듭 제곱 (D3|재귀) [O|00:12:23]
 * 시도1
 */
package Swea.Giseok;

import java.util.Scanner;

public class swea_1217 {

    static int num, exp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt();
            num = sc.nextInt();
            exp = sc.nextInt();

            System.out.println("#" + t + " " + pow(1, 0));
        }
    }

    public static int pow(int n, int e) {
        if (e == exp) {
            return n;
        }

        return pow(n * num, e+1);
    }
}
            