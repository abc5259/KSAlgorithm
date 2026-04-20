package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1799 {
    static int n, black, white;
    static int[][] map;
    static boolean[] right_down;
    static boolean[] left_down;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        right_down = new boolean[n * 2];
        left_down = new boolean[n * 2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        dfs(0, 1, 0);

        System.out.println(black + white);
    }

    static void dfs(int idx, int color, int cnt) {
        if (idx >= n * n) {
            if (color == 0) {
                black = Math.max(black, cnt);
            } else {
                white = Math.max(white, cnt);
            }
            return;
        }

        int r = idx / n;
        int c = idx % n;

        if ((r + c) % 2 != color || map[r][c] == 0) {
            dfs(idx + 1, color, cnt);
            return;
        }

        int r1 = r - c + n;
        int l1 = r + c;

        if (!right_down[r1] && !left_down[l1]) {
            right_down[r1] = true;
            left_down[l1] = true;

            dfs(idx + 1, color, cnt + 1);

            right_down[r1] = false;
            left_down[l1] = false;
        }

        dfs(idx + 1, color, cnt);
    }
}
// P5 비숍 백트래킹
// 55분
// 비숍이 갈 수 있는 곳은 대각선 2개 밖에 없다 그래서 우하향과 좌하향 2개를 visit 배열로 만들어서
// 체크니까 검정색과 하얀색은 대각선으로 겹칠 수가 없다 그래서 검은색 하얀색 2개의 dfs 를 태우고 이는
// N이 10까지 가능하니까 즉 체스판은 100개고 검정색 기준으로 체크하냐 안하냐 2의 50승 이고 2개다 2의 50승 더하면 된다.
// 그리고 좌표에 있어서는 그냥 체스판을 1개의 배열 인덱스로 고려해서 0,0 이면 인덱스 0 이고 N이 5일때 4,0 은 인덱스 4 1,0이면 인덱스 5이런 느낌이다
// 인덱스 / N 이 y좌표 인덱스 % N 이  x 좌표가 된다.
// 그래서 같은 색이 아니거나 map 으로 못가는건 다음 차례로 넘기고 같은 색 타일일 경우에는
// 우하향은 항상 차이가 같은데 이는 음수 인덱스도 가능해서 n 을 더해가지고 1,2,3,4,5 까지 가능하다 n이 3기준 근데 좌하향은 더해도 같다고 해서
// r + c 로 해서 하면 0,1,2,3,4 까지돼서 둘다 그냥 2N의 범위로 가져서 방문 여부 확인해서 dfs 백트래킹 진행한다.