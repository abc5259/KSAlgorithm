package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] sum = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int a = Integer.parseInt(st.nextToken());
                sum[i][j] = a + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int res = sum[x][y] - sum[i - 1][y] - sum[x][j - 1] + sum[i - 1][j - 1];
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }
}

// S5 2차원 배열의 합 누적합
//for (int row = i; row <= x; row++) {
//for (int col = j; col <= y; col++) {
//sum += map[row][col];
// 으로 그냥 범위에서 N^2으로 해왔는데 누적합으로 단축 할 수 있었다.
// K가 10000이라서 시간초과 우려해서 개선
//
// 누적합 배열은 현재값 + 위쪽 영역 합 + 왼쪽 영역합 - 겹치는 영역 합인데
// 특정영역 부터 까지의 합은
// 전체 큰 사각형 - 필요없는 위 - 필요없는 왼 + 두변 뺸거