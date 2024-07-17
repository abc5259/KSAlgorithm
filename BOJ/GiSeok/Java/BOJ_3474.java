/**
 * 3474 - 교수가 된 현우 [실패]
 * 실버3, 수학
 * 
 * 맨 오른쪽 0의 개수를 찾는 문제이다.
 * 어떤 수의 0의 개수 n은 10^n과 같다. 10^n은 (2*5)^n으로 표현할 수 있으므로,
 * 해당 수의 2와 5 갯수를 세고 2^n, 5^m 중 작은 n,m 값을 선택하면 된다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3474 {
    // 자연수 N이 주어지면 N!의 오른쪽 끝 0의 개수 찾기 문제
    // 1 <= N <= 1000000000(10억)
    // 완전탐색 x
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int ret = 0;
            int n = Integer.parseInt(br.readLine());

            int t = 0;
            int f = 0;
            for (int x = 2; x <= n; x *= 2)
                t += (n / x);

            for (int x = 5; x <= n; x *= 5)
                f += (n / x);

            ret = Math.min(t, f);
            System.out.println(ret);
        }
    }
}
