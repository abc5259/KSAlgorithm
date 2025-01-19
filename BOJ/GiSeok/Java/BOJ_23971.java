/**
 * [B3 구현] ZOAC 4 - O, 00:07:57
 * 시도 1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int ret = 0;
        for (int y = 0; y < h; y+=(n+1)) {
            for (int x = 0; x < w; x+=(m+1)) {
                ret++;
            }
        }

        System.out.println(ret);
    }
}
