/**
 * 17822 - 원판 돌리기 [성공|01:46:08]
 * 골드2, 구현/시뮬레이션, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_17822 {
    // 시간제한 1초, 메모리제한 512MB

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[][] round;
    static int n, m, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        round = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                round[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int T = 0; T < t; T++) {
            st = new StringTokenizer(br.readLine());
            int xi = Integer.parseInt(st.nextToken());
            int di = Integer.parseInt(st.nextToken());
            int ki = Integer.parseInt(st.nextToken());

            // 회전
            for (int x = xi-1; x < n; x+=xi) {
                for (int k = 0; k < ki; k++) {
                    if (di == 0) {
                        int tmp = round[x][m-1];
                        for (int i = m-1; i > 0; i--) {
                            round[x][i] = round[x][i-1];
                        }
                        round[x][0] = tmp;
                    } else {
                        int tmp = round[x][0];
                        for (int i = 0; i < m-1; i++) {
                            round[x][i] = round[x][i+1];
                        }
                        round[x][m-1] = tmp;
                    }
                }
            }

            // 숫자 지우기
            ArrayDeque<Integer> xy = new ArrayDeque<>();
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    for (int d = 0; d < 4; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d] < 0 ? m-1 : x + dx[d] >= m ? 0 : x + dx[d];

                        if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

                        if (round[ny][nx] != 0 && round[ny][nx] == round[y][x]) {
                            xy.add(y);
                            xy.add(x);
                            xy.add(ny);
                            xy.add(nx);
                        }
                    }
                }
            }

            if (xy.isEmpty()) {
                int sum = 0;
                int cnt = 0;
                for (int y = 0; y < n; y++) {
                    for (int x = 0; x < m; x++) {
                        sum += round[y][x];
                        if (round[y][x] != 0) cnt++;
                    }
                }

                double avg = (double)sum / (double)cnt;
                for (int y = 0; y < n; y++) {
                    for (int x = 0; x < m; x++) {
                        if (round[y][x] != 0) {
                            if ((double)round[y][x] < avg) round[y][x] += 1;
                            else if ((double)round[y][x] > avg) round[y][x] -= 1;
                        }
                    }
                }
            } else {
                while (!xy.isEmpty()) {
                    int y = xy.poll();
                    int x = xy.poll();

                    round[y][x] = 0;
                }
            }
        }

        int ret = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                ret += round[y][x];
            }
        }

        System.out.println(ret);
    }
}
