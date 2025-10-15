package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == M) {
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}
// S4 수들의 합 2 누적합 + 완탐
// 10분
// 쉽게 풀었다 시간제한이 0.5초라서 주어진 N이 10,000 이라 N^2/2 의 연산이 필요했고
// 누적합과완탐으로 시간복잡도 분석했다.