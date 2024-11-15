/**
 * 11050 - 이항 계수 1(B1) [O|00:06:59]
 * 수학, 시도3
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_11050 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] fact = new int[n+1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = fact[i-1] * i;

        int ret = fact[n] / (fact[k] * fact[n-k]);
        System.out.println(ret);
    }
}
