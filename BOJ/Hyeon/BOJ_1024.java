package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        while (L <= 100) {
            long tmp = N - (long) L * (L - 1) / 2;

            if (tmp < 0) {
                break;
            }
            if (tmp % L == 0) {
                long x = tmp / L;

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < L; i++) {
                    sb.append(x + i).append(" ");
                }
                System.out.println(sb);
                return;
            }
            L++;
        }
        System.out.println(-1);
    }
}
// S2 수열의 합 수학
// 1시간
// 아니 N이 1억인줄 알고 투포인터, 슬라이드 윈도우로 해서 풀고있었는데 N이 10억이길래
// 시간초과 야기해서 방법을 찾다가 등차수열의 공식을 이용한 풀이로 개선했다.
// 만약 등차수열의 합이 L의 개수로 나누어지는거라면 연달아서 표현할 수 있다.