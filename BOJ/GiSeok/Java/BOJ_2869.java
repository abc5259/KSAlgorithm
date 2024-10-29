/**
 * 2869 - 달팽이는 올라가고 싶다(B1|수학) [O|00:14:02]
 * 시도3
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_2869 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        v -= a; a -= b;
        int ret = v / a + 1;
        if (v % a > 0) ret++;
        System.out.println(ret);
    }
}