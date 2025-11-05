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
            for (int s = 0; s <= 2 * (N - i - 1); s++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = i; j < N - 2; j++) {
                sb.append(" ");
            }
            for (int s = 0; s < i * 2 + 3; s++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
// B3 별찍기 - 9 구현
// 10분
// 걍 풀었음.
// 구현이라서 규칙 찾아서 그냥 풀었는데 뭐가 좋은 풀이인지 모르겠음