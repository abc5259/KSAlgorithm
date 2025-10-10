package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_13706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());

        System.out.print(lowerBound(N));
    }

    static BigInteger lowerBound(BigInteger N) {
        BigInteger lo = BigInteger.ZERO;
        BigInteger hi = N;

        while (lo.add(BigInteger.ONE).compareTo(hi) < 0) {
            BigInteger mid = hi.subtract(lo).divide(BigInteger.valueOf(2)).add(lo);

            if (mid.multiply(mid).compareTo(N) >= 0) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }
}
// S4 제곱근 이분 탐색
// 15분
// 일단 주어진 문제가 완벽하게 이분탐색이 가능하게 끔 주어졌다 N이 800자 정도라니까 10의 800승인거다,,
// 그래서 long 보다 더 큰 문자열 형태인 BigInteger를 통해서 했고
// 이를 활용하여서 이분탐색을 진행하였다
// 일단 제곱근을 구하는데 항상 양의 정수로 출력된다는거부터 완벽하게 떨어지는 값이 있따고 생각하였고
// 예를들어 36을 주었을 때 6이 나와야 된다
// 근데 그러면 범위를 0부터 36까지 해서 반으로 줄여나가면서 해도 log 연산으로 해도 시간복잡도는 해결가능했다
// 그리고 FFFF TTTT 범위 형식이기 때문에 lowerBound를 통해서 mid * mid >= N 으로 했다