package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003 {
    static int zero, one, originalZero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            fibo(N);
            sb.append(zero).append(" ").append(one).append("\n");
        }
        System.out.println(sb);
    }

    static void fibo(int n) {
        zero = 1;
        one = 0;
        originalZero = 1;

        while (n-- > 0) {
            zero = one;
            one += originalZero;
            originalZero = zero;
        }
    }
}

// S3 피보나치 DP
// 메모이제이션을 활용해서 점화식을 만들면 해결
// 복습