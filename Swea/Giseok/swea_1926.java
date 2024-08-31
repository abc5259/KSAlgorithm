/**
 * 1926. 간단한 369게임 [성공|00:19:22]
 * D2, 구현, 시도2
 */
package Swea.Giseok;
import java.io.*;

public class swea_1926
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            int cnt = 0;

            int tmp = i;
            for (int j = 0; j < 3; j++) {
                int c = tmp % 10;

                if (c == 3 || c == 6 || c == 9) cnt++;
                tmp = tmp / 10;
            }

            for (int c = 0; c < cnt; c++) System.out.print("-");
            if (cnt == 0) System.out.print(i);
            System.out.print(" ");
        }
    }
}