package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13171 {
    private final static int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long A = Long.parseLong(br.readLine());
        long X = Long.parseLong(br.readLine());

        long[] up = new long[64];
        up[0] = A % MOD;

        for (int i = 1; i < 64; i++) {
            up[i] = (up[i - 1] % MOD) * (up[i - 1] % MOD) % MOD;
        }

        long result = 1;

        for (int i = 63; i >= 0; i--) {
            if ((X & (1L << i)) != 0) {
                result = (result * up[i]) % MOD;
            }
        }
        System.out.print(result);
    }
}

// S3 A 재귀 비트마스크
// 이제 브루트포스 단원이 끝나고 재귀, device and conquer 문제 한다
// 일단 시작은 mod 연산 문제로 64비트 내의 숫자이고 지수를 1 2 4 8 순으로 가서 1<<의 지수 를 관련해서
// 반복문을 사용한다
// 이전 값 제곱 에다가 MOD 연산을 하기에 1부터 시작하고 0의 값은 대입해준다
// X 를 이진수로 만들 때 1<< 쉬프트 연산으로 0하면 1 1하면 10으로 2가 되어서
// 1과 AND 연산해서 0이 아닐경우 1을 포함하고 있다는 것으로 한다음 누적 곱으로 계산한다.