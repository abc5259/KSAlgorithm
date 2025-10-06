package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }
            for (int k = i; k < 2 * N - 1 - i; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for (int i = 1; i < N; i++) {
            for (int j = N - i - 1; j > 0; j--) {
                sb.append(" ");
            }
            for (int k = 1; k <= i * 2 + 1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
// B3 별찍기 - 9 구현
// 걍 풀었음.