/**
 * 2007. 패턴 마디의 길이 [성공|00:31:12]
 * D2, 구현, 시도1
 */
package Swea.Giseok;
import java.io.*;

public class swea_2007
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++)
        {
            String s = br.readLine();

            int ret = 0;
            boolean flag = false;
            for (int i = 1; i <= 10; i++) {
                String copy = s.substring(0, i);
                for (int j = i; j + i <= 30; j+=i) {
                    if (!s.substring(j, j+i).equals(copy)) { flag = false; break; }
                    else { flag = true; }
                }

                if (flag) { ret = copy.length(); break; }
            }

            System.out.println("#" + t + " " + ret);
        }
    }
}