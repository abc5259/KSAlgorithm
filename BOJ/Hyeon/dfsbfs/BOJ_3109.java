package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {
    static int R, C; // 행 과 열
    static char[][] pipe; // 파이프라인 배열
    static int[] dy = {-1, 0, 1}; // 갈 수있는 곳 열은 무조건 오른쪽으로 가서 +1
    // 행은 위 가운데 아래라서 해당 증감 델타를 가진다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        pipe = new char[R][C];

        String str;
        for (int i = 0; i < R; i++) {
            str = br.readLine();
            for (int j = 0; j < C; j++) {
                pipe[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                res++;
            }
        }
        System.out.println(res);
    }

    static int res;

    static boolean dfs(int y, int x) {
        int nx = x + 1;

        if (nx == C - 1) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];

            if (ny >= 0 && ny < R && pipe[ny][nx] != 'x') {
                pipe[ny][nx] = 'x';
                // x로 바꾸어버린다. 지나가면

                if (dfs(ny, nx)) {
                    return true;
                }
            }
        }
        return false;
    }
}

// G2 빵집 DFS 빽트래킹
// 어렵다 근데 문제를 이해를 하자면 오른쪽 위 가운데 아래로만 갈 수 있고 열이 C-1까지만
// 가게끔 하는 기저조건을 설정하고 dfs가 계속해서 가고
// 이게 행마다 1개씩 출발 할 수 있어서 행별로 반복문을 거쳐
// C-1까지 가면 +1을하고 아니면 그대로 해서 값을 출력한다.
// 이미 지나간 곳은 x로 바꿔버린다. 지났던 곳이라서.