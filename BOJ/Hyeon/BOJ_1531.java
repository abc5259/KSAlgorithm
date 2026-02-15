package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] picture = new int[100][100];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int ly = Integer.parseInt(st.nextToken()) - 1;
            int lx = Integer.parseInt(st.nextToken()) - 1;
            int ry = Integer.parseInt(st.nextToken()) - 1;
            int rx = Integer.parseInt(st.nextToken()) - 1;

            for (int r = ly; r <= ry; r++) {
                for (int c = lx; c <= rx; c++) {
                    picture[r][c]++;
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (picture[i][j] > M) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
// S5 투명 구현
// 18분
// 아니 문제를 못알아 들어서 푸는건 1분도 안됐는데 M개 이하의 부분이 덮여있으면
// 보이는거고 M개보다 크면 안보인다는거네 그래서 int 2차원 배열로 구성하고
// 해당 ly 부터 ry lx 부터 rx 까지 해서 칸을 색칠을 하고 그 색칠된게 M보다 커야 가려지는 부분이다 이말이다..
// 문제 이해만 15분 넘게썼다.