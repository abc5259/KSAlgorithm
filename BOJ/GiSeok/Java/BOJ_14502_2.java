/**
 * 14502 - 연구소 [성공]
 * 골드4, 조합/DFS, 시도1
 * 
 * 이전 풀이에 비해 다른점 *
 * 1. 조합을 재귀가 아닌 3중 for문으로 구현하였음.
 * 2. wallList, virusList 배열을 통해 벽을 세울 수 있는 위치와 바이러스가 시작하는 위치를 저장
 * 3. map에 벽을 세우고 virusList를 기반으로 map에 dfs 탐색을 함.
 *  -> visited 배열을 통해 0이면서 방문 한 곳 == 바이러스가 퍼진 곳으로 로직 작성
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14502_2 {

    static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Pair> wallList = new ArrayList<>();
    static ArrayList<Pair> virusList = new ArrayList<>();
    static int N, M;
    static int ret = 0;

    static void dfs(Pair p) {
        visited[p.y][p.x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = p.y + dy[i];
            int nx = p.x + dx[i];

            if (nx < 0 || ny < 0 || ny >= N || nx >= M) continue;
            if (visited[ny][nx]) continue;
            if (map[ny][nx] != 0) continue;

            dfs(new Pair(ny, nx));
        }
    }

    static int research() {
        visited = new boolean[N][M];
        for (Pair p : virusList)
            dfs(p);

        int cnt = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 0 && !visited[y][x]) cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 0) wallList.add(new Pair(y, x));
                else if (map[y][x] == 2) virusList.add(new Pair(y, x));
            }
        }

        for (int i = 0; i < wallList.size(); i++) {
            for (int j = i + 1; j < wallList.size(); j++) {
                for (int z = j + 1; z < wallList.size(); z++) {
                    map[wallList.get(i).y][wallList.get(i).x] = 1;
                    map[wallList.get(j).y][wallList.get(j).x] = 1;
                    map[wallList.get(z).y][wallList.get(z).x] = 1;
                    ret = Math.max(ret, research());
                    map[wallList.get(i).y][wallList.get(i).x] = 0;
                    map[wallList.get(j).y][wallList.get(j).x] = 0;
                    map[wallList.get(z).y][wallList.get(z).x] = 0;
                }
            }
        }

        System.out.println(ret);
    }
}
