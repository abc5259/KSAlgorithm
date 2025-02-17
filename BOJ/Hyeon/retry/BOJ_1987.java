package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {

    static int R, C, res; // 행, 열, 최종값
    static int[][] bet; // 알파벳 2차원 입력
    static boolean[] visit; // 방문여부 - 알파벳 - 'A' 해서 알파벳 순서를 인덱스로 가지고 true로 만들어서 비교

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        bet = new int[R][C];
        res = 0;

        String str;
        for (int i = 0; i < R; i++) {
            str = br.readLine();
            for (int j = 0; j < C; j++) {
                bet[i][j] = str.charAt(j) - 'A';
            }
        }

        visit = new boolean[26];
        visit[bet[0][0]] = true;

        dfs(0, 0, 1);
        // 0,0이고 1칸으로 친다해서

        System.out.println(res);
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void dfs(int y, int x, int depth) {
        res = Math.max(res, depth);

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                int idx = bet[ny][nx];

                if (!visit[idx]) {
                    visit[idx] = true;
                    dfs(ny, nx, depth + 1);
                    visit[idx] = false;
                }
            }
        }
    }
}

// G4 알파벳 DFS 백트래킹
// 일단 4방탐색을 활용하고 dfs를 하면서 최대값을 구하기 위해 백트래킹을 사용한다.
// 다음 dfs까지 넘어갔다가 다시 원래의 dfs로 반환하고 그때의 최대값을 저장해서
// 반복해서 dfs를 하면서 비교한다.
// 일단 입력 알파벳은 정수 2차원 배열로 바꿔서 -'A'의 수고를 덜어
// 인덱스 연산이 편하게 하였고 알파벳 탐지여부는 해당 인덱스를 넣어서 알파벳의 순서에 맞게 true로 변경했다.