package BOJ.JaeIk.practice.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class BOJ_1003
{
    static Integer[] dp0;
    static Integer[] dp1;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            int number = Integer.parseInt(br.readLine());

            dp0 = new Integer[41];
            dp1 = new Integer[41];

            dp0[0] = 1;
            dp0[1] = 0;
            dp1[0] = 0;
            dp1[1] = 1;

            for(int i=2; i<=number; i++) {
                dp0[i] = dp0[i-1] + dp0[i-2];
                dp1[i] = dp1[i-1] + dp1[i-2];
            }

            System.out.println(dp0[number]+" "+dp1[number]);
        }
    }
}