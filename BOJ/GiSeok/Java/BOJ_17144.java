/**
 * 17144 - 미세먼지 안녕! [성공|01:10:01]
 * 골드4, BFS/구현/시뮬레이션, 시도1
 * 
 * 처음에 공기가 순환하는 것을 보고, 각각 하나의 for문으로 하여 총 8개의 for문으로 공기 순환을 구현했다.
 * 정답은 맞았지만 뭔가 아쉬운 코드였는데 큰돌님 강의를 통해 어차피 바람이 부는 구역은 고정되어 있으니 이 좌표들을 배열에 담으면 편리하게
 * 해당 로직을 구현할 수 있다는 것을 알게 되었다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17144 {
    // 시간제한 1초, 메모리제한 512MB
    // R*C [1*1]
    // 공청기는 항상 1번 열에 위치 크기는 두 행 차지

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
    static int[][] visited;
    static int R, C, T;
    static ArrayDeque<Integer> q = new ArrayDeque<>();

    static int[][] wy12 = new int[][]{ {0, -1, 0, 1}, {0, 1, 0, -1} };
    static int[][] wx12 = new int[][]{ {1, 0, -1, 0}, {1, 0, -1, 0} };

    static ArrayList<Pair> windSec1 = new ArrayList<>();
    static ArrayList<Pair> windSec2 = new ArrayList<>();

    static void windSectorFind(int y, int x, int sig) {
        int cnt = 0;

        int wy = y;
        int wx = x;
        
        while (true) {
            int ny = wy + wy12[sig][cnt];
            int nx = wx + wx12[sig][cnt];

            if (ny == y && nx == x) break;
            if (ny < 0 || nx < 0 || nx >= C || ny >= R) { cnt++; continue; }
            wy = ny; wx = nx;

            if (sig == 0) windSec1.add(new Pair(wy, wx));
            else windSec2.add(new Pair(wy, wx));

        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new int[R][C];

        int sig = 0;
        for (int y = 0; y < R; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < C; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] > 0) { q.add(y); q.add(x); visited[y][x] = map[y][x]; }
                else if (map[y][x] == -1) { 
                    if (sig == 0) windSectorFind(y, x, sig++);
                    else windSectorFind(y, x, sig);    
                }
            }
        }

        for (int t = 0; t < T; t++) {
            while (!q.isEmpty()) {
                int y = q.poll();
                int x = q.poll();

                int spread = visited[y][x] / 5;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                    if (map[ny][nx] == -1) continue;

                    map[ny][nx] += spread;
                    map[y][x] -= spread;
                }
            }

            for (int i = windSec1.size() - 1; i > 0; i--) {
                Pair p1 = windSec1.get(i);
                Pair p2 = windSec1.get(i - 1);

                map[p1.y][p1.x] = map[p2.y][p2.x];
            }

            map[windSec1.get(0).y][windSec1.get(0).x] = 0;

            for (int i = windSec2.size() - 1; i > 0; i--) {
                Pair p1 = windSec2.get(i);
                Pair p2 = windSec2.get(i - 1);

                map[p1.y][p1.x] = map[p2.y][p2.x];
            }

            map[windSec2.get(0).y][windSec2.get(0).x] = 0;

            // for (int y = upperY; y > 0; y--) {
            //     if (map[y][0] == -1) { map[y-1][0] = 0; continue; }
            //     map[y][0] = map[y-1][0];
            // }

            // for (int x = 0; x < C-1; x++)
            //     map[0][x] = map[0][x+1];

            // for (int y = 0; y < upperY; y++)
            //     map[y][C-1] = map[y + 1][C-1];

            // for (int x = C-1; x > 0; x--) {
            //     if (map[upperY][x-1] == -1) { map[upperY][x] = 0; continue; }
            //     map[upperY][x] = map[upperY][x-1];
            // }

            // //
            
            // for (int y = upperY+1; y < R-1; y++) {
            //     if (map[y][0] == -1) { map[y+1][0] = 0; continue; }
            //     map[y][0] = map[y+1][0];
            // }

            // for (int x = 0; x < C-1; x++)
            //     map[R-1][x] = map[R-1][x+1];

            // for (int y = R-1; y > upperY+1; y--)
            //     map[y][C-1] = map[y - 1][C-1];

            // for (int x = C-1; x > 0; x--) {
            //     if (map[upperY+1][x-1] == -1) { map[upperY+1][x] = 0; continue; }
            //     map[upperY+1][x] = map[upperY+1][x-1];
            // }


            for (int i = 0; i < R; i++)
                visited[i] = map[i].clone();

            for (int y = 0; y < R; y++) {
                for (int x = 0; x < C; x++) {
                    if (map[y][x] > 0) { q.add(y); q.add(x); }
                }
            }
        }

        int ret = 0;
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++)
                if (map[y][x] > 0) ret += map[y][x];
        }

        System.out.println(ret);
    }
}
