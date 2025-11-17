package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_21736 {
    static int N, M;
    static char[][] campus;
    static boolean[][] visit;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visit = new boolean[N][M];

        int y = 0, x = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = str.charAt(j);
                if (campus[i][j] == 'I') {
                    y = i;
                    x = j;
                }
            }
        }
        bfs(y, x);

        System.out.println(sum == 0 ? "TT" : sum);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs(int y, int x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) {
                    continue;
                }
                if (campus[ny][nx] == 'X') {
                    continue;
                }
                if (campus[ny][nx] == 'P') {
                    sum++;
                }
                queue.offer(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }
    }
}
// S2 헌내기는 친구가 필요해 BFS
// 11분
// 일단 N X M 모양의 캠퍼스에서 상하좌우로 4방향 탐색하는 문제이다 그리고 이동하는 거에 대해서 사람을 만나는거고
// 최초 만나는게 중요한거니까 BFS의 최초 방문시 재방문은 없다는 것을 이용해서 풀었다
// 그리고 방문 여부를 나타내는 것도 cnt 로 인트 배열쓰려고 했는데 거리가 필요없어서 그냥 boolean 타입으로 정리했다.
// sum 정적 변수로 연산해서 계산했다.