package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BA {
    final static int N = 19;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int dol = board[i][j];
                if (board[i][j] == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int ny = i - dy[d];
                    int nx = j - dx[d];
                    if (ny >= 0 && ny < N && nx >= 0 && nx < N && board[ny][nx] == dol) {
                        continue;
                    }

                    int cnt = 1;

                    ny = dy[d] + i;
                    nx = dx[d] + j;

                    while (ny >= 0 && ny < N && nx >= 0 && nx < N && board[ny][nx] == dol) {
                        cnt++;
                        ny += dy[d];
                        nx += dx[d];
                    }

                    if (cnt == 5) {
                        System.out.println(dol);
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    static int[] dy = {1, 0, 1, -1};
    static int[] dx = {0, 1, 1, 1};
}
