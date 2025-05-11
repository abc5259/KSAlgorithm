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
// 다른 풀이를 적용해서 풀었다
// mid를 기준으로 나누느게 분할정복이고 X==1까지 해서 기저조건을 설정한다 이는 가장 앞의 수이다
// X 가 홀수면 A가 짝수인데다가 A를 한번 더 곱해주면 끝이긴하다.