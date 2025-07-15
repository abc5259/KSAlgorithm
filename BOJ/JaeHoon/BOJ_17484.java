package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17484 {
    static int[][] arr;
    static int N, M;
    static int[] dx = {0, 1, 1, 1};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<M; i++) {
            q.offer(new int[] {0, i, arr[0][i], 0});
        }
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] curr = q.poll();

            for(int d=1; d<=3; d++) {
                if(curr[3] == d) continue;
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];
                if(nx < 0 || ny < 0 || ny >= M) continue;
                if(nx == N) {
                    min = Math.min(min, curr[2]);
                    continue;
                }
                q.offer(new int[]{nx, ny, curr[2] + arr[nx][ny], d});
            }
        }

        return min;
    }

    // 0 -> 무방향
    // 1 -> 아래
    // 2 -> 오 대각선
    // 3 -> 왼 대각선
}
