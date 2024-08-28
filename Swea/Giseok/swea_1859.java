/**
 * [swea] 1859 - 백만 장자 프로젝트 [성공(댓글힌트)|00:47:47]
 * D2, 그리디, 시도5
 */
package Swea.Giseok;

import java.util.Scanner;

public class swea_1859 {

    static int[] gold;
    static long ret;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();

            gold = new int[n];
            for (int i = 0; i < n; i++) gold[i] = sc.nextInt();

            ret = 0;
            int max = 0;
            for (int i = n-1; i >= 0; i--) {
                if (gold[i] > max) max = gold[i];
                else ret += (max - gold[i]);
            }

            System.out.println("#" + test_case + " " + ret);
        }
    }
}
