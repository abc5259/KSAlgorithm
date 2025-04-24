package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615 {
    final static int N = 19;
    static int[][] board;

    static int[] dy = {1, 0, 1, -1};
    static int[] dx = {0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[N][N];

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

                if (dol == 0) {
                    continue;
                }
                for (int n = 0; n < 4; n++) {
                    int py = i - dy[n];
                    int px = j - dx[n];

                    if (py >= 0 && px >= 0 && py < N && px < N && dol == board[py][px]) {
                        continue;
                    }

                    int cnt = 1;

                    int ny = i + dy[n];
                    int nx = j + dx[n];

                    while (ny >= 0 && nx >= 0 && ny < N && nx < N && dol == board[ny][nx]) {
                        cnt++;
                        ny += dy[n];
                        nx += dx[n];
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
}
// S1 오목 브루트포스
// 일단 바둑판 배열을 만들고 동작 방식에 있어서 0이면 continue를 하고 1이나 2일 때 따져봐야 한다.
// 바둑알이 6목이 되면 안되기에 이전 바둑알과 겹치는지 유무를 판단하고 안 겹치게 되면
// 이전 바둑알과 같은 색인지, 범위내에 있는지를 판단하고 진행한다.
// 다음 바둑알과 cnt 를 설정해서 5개로 하는거고 누적합을 통해서 nexty의 범위와 dol과 같은 색인지
// 여부를 판단해서 반복해서 출력하고 return 하거나 0을 출력한다.