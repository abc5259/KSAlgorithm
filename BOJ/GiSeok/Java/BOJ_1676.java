/**
 * 1676 - 팩토리얼 0의 개수(S5) [O|00:11:40]
 * 수학, 시도4
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.math.BigInteger;

public class BOJ_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BigInteger[] fact = new BigInteger[501]; fact[0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++) fact[i] = fact[i-1].multiply(new BigInteger(String.valueOf(i)));

        int ret = 0;
        for (int i = fact[n].toString().length() - 1; i >= 0; i--) {
            if (fact[n].toString().charAt(i) != '0') break;
            ret++;
        }
        System.out.println(ret);
    }
}
