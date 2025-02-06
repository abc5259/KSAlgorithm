package BOJ.Hyeon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003 {
    public static int zero, one, prezero;

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

    public static void fibo(int N) {
        zero = 1;
        one = 0;
        prezero = 1;
        while (N-- > 0) {
            zero = one;
            one = zero + prezero;
            prezero = zero;
        }
    }
}
// 재귀 호출을 할 때 이미 한번 연산한 값이 있으면 이를 재사용하여 반복과정을 줄인다.

