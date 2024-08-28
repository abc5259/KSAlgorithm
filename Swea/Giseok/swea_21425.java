/**
 * [swea] 21425 - += [성공|00:24:00]
 * D2, 구현, 시도1
 *
 * 최악의 경우 A = 1, B = 1인 상황에서 N이 10^9이면
 * 피보나치 수열 꼴로 A와 B가 증가한다.
 * 근데, 피보나치 수열은 50번째 숫자만 되어도 70억이 넘음. 즉, 완탐이 가능한 문제다.
 */
package Swea.Giseok;

import java.util.Scanner;

public class swea_21425 {

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int N = sc.nextInt();

            int cnt = 1;
            while (A + B <= N) {
                if (A > B) B += A;
                else A += B;
                cnt++;
            }

            System.out.println(cnt);
        }
    }
}