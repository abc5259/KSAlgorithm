/**
 * 14502 - 연구소 [성공|00:49:25]
 * 골드4, 완전탐색/DFS, 시도1
 * 
 * 
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14502 {
    // 시간제한 2초, 메모리제한 512MB
    // 연구소 N*M, 1*1 크기의 정사각형으로 이루어짐
    // 빈 칸: 0
    // 벽: 1
    // 바이러스: 2
    // 새로 세울 수 있는 벽은 무조건 3개
    // 3 <= N, M <= 8
    // 최대 8*8 크기의 맵에 3개의 벽을 세우는 경우의 수 64C3 = 41664
    // 거기에 매번 바이러스를 퍼뜨리는 DFS = 8*8
    // 퍼뜨린 후 안전영역 검사 8*8
    // 41664 * (64 + 64) = 5332992 완탐으로 가능할듯

    static class Pair {
        int y, x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N, M;
    static int[][] map;
    static int[][] copymap;
    
    static int ret = 0;

    static void dfs(Pair p) {
        for (int i = 0; i < 4; i++) {
            int ny = p.y + dy[i];
            int nx = p.x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            if (copymap[ny][nx] == 1 || copymap[ny][nx] == 2) continue;
            
            copymap[ny][nx] = 2;
            dfs(new Pair(ny, nx));
        }

    } 

    static void combi(Pair p, int depth) {
        if (depth == 3) {

            copymap = new int[N][M];
            for (int i = 0; i < N; i++)
                copymap[i] = map[i].clone();

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (copymap[y][x] == 2) dfs(new Pair(y, x));
                }
            }

            int cnt = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (copymap[y][x] == 0) cnt++;
                }
            }

            ret = Math.max(cnt, ret);
            return;
        }

        for (int y = p.y; y < N; y++) {
            for (int x = (p.y != y ? 0 : p.x + 1); x < M; x++) {
                if (map[y][x] == 1 || map[y][x] == 2) continue;

                Pair np = new Pair(y, x);

                map[np.y][np.x] = 1;
                combi(np, depth + 1);
                map[np.y][np.x] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++)
                map[y][x] = Integer.parseInt(st.nextToken());
        }

        combi(new Pair(0, -1), 0);
        System.out.println(ret);
    }
}
