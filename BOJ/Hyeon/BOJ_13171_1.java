package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13171_1 {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long A = Long.parseLong(br.readLine());
        long X = Long.parseLong(br.readLine());

        System.out.print(cal(A, X));
    }

    public static long cal(long A, long X) {
        if (X == 1) {
            return A % MOD;
        }
        long tmp = cal(A, X / 2);
        if (X % 2 == 0) {
            return (tmp * tmp) % MOD;
        } else {
            return (tmp * tmp) % MOD * (A % MOD) % MOD;
        }
    }
}

// S3 A 분할정복
// x가 64 비트의 최대 수로 엄청 크기 때문에 x를 나누기 2해서 제곱으로 연산하면서 진행하면된다
// 이전의 곱셈 문제와 유사하다. 그래서 홀수일경우 제곱에다가 * A%MOD 연산해줘야하고
// 짝수면 제곱만 해도된다
// 이렇게 해서 기저 사례까지가서 값을 리턴받아서 정복하면된다.
// MOD 연산 주의