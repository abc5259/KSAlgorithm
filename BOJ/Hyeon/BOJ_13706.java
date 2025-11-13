package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_13706 {
    static BigInteger N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = new BigInteger(br.readLine());

        System.out.println(lowerBound());
    }

    static BigInteger lowerBound() {
        BigInteger lo = BigInteger.valueOf(0);
        BigInteger hi = N;

        while (hi.compareTo(lo.add(BigInteger.valueOf(1))) > 0) {
            BigInteger mid = (hi.subtract(lo)).divide(BigInteger.valueOf(2)).add(lo);

            if (check(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }

    static boolean check(BigInteger mid) {
        return (mid.multiply(mid)).compareTo(N) >= 0;
    }
}
// S4 제곱근 이분탐색 + BigInteger
// 16분
// BigInteger 와 BigDecimal 에 대해서 좀 헷갈렸던 것이 있다
// 그리고 BigInteger에 대한 메소드도 알아둬야 할 거 같다 일반 적인 사칙연산으로는 불가능 하다 그리고
// lowerBound 를 통해서 FFFF TTTT 구조 이고 우리가 사실 원하는 값보다 크거나 같다 이므로 이게
// 가장 처음의 T 만 구하면 된다 그 T는 일치할 테고 왜냐하면 제곱근만 주어지는 문제이기에.