/**
 * 1629 - 곱셈 [실패/1:13:24]
 * 분할정복, 실버1
 * 
 * 이번엔 재귀함수를 이용한 풀이
 * 2로 계속 나누면서 한번씩만 호출하므로, 시간복잡도는 O(logN)
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    static long pow(long a, long b, long c) {
        if (b == 0) return 1;

        long n = pow(a, b/2, c);
        if (b % 2 == 0)
            return n * n % c;
        else
            return n * n % c * a % c;
    }
}
