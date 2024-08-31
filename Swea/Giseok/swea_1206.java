/**
 * 1206. [S/W 문제해결 기본] 1일차 - View [성공|00:12:52]
 * D3, 구현, 시도1
 */
package Swea.Giseok;

import java.io.*;
import java.util.StringTokenizer;

public class swea_1206
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int[] citys = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) citys[i] = Integer.parseInt(st.nextToken());

            int ret = 0;
            for (int i = 2; i < n-2; i++) {
                int max = 0;
                boolean flag = false;

                for (int l = 1; l <= 2; l++) {
                    if (citys[i - l] >= citys[i]) flag = true;
                    max = Math.max(max, citys[i - l]);
                }

                for (int r = 1; r <= 2; r++) {
                    if (citys[i + r] >= citys[i]) flag = true;
                    max = Math.max(max, citys[i + r]);
                }

                if (!flag) ret += (citys[i] - max);
            }

            System.out.println("#" + test_case + " " + ret);
        }
    }
}