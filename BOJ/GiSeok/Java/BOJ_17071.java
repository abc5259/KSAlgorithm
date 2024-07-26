/**
 * 17071 - 숨바꼭질 5 [실패|01:35:20]
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_17071 {
    // 수빈이 N (0 <= N <= 500,000)
    // 동생  K (0 <= K <= 500,000)
    // 수빈이 n-1, n+1, n*2
    // 동생은 가속이 붙음
    // 1초 후 k+1
    // 2초 후 k+1+2
    // 3초 후 k+1+2+3
    // 수빈이가 0, 50만보다 큰 좌표로 이동 x

    static int[][] visited = new int[2][500001];
    static int N, K;
    static boolean ok;
    static int acc = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) { System.out.println(0); System.exit(0); }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[0][N] = 1;
        q.push(N);

        while (!q.isEmpty()) {
            K += acc;
            if (K > 500000) break;
            if (visited[acc % 2][K] > 0) {
                ok = true;
                break;
            }

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int x = q.poll();

                for (int nx : new int[]{x + 1, x - 1, x * 2}) {
                    if (nx < 0 || nx > 500000 || visited[acc % 2][nx] > 0) continue;
                    visited[acc % 2][nx] = visited[(acc + 1) % 2][x] + 1;
                    if (nx == K) {
                        ok = true; break;
                    }
                    q.push(nx);
                }
                if (ok) break;
            }
            if (ok) break;
            acc++;
        }

        if (ok) System.out.println(acc);
        else System.out.println(-1);
    }
}
