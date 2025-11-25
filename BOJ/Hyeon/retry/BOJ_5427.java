package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_5427 {
    static int w, h;
    static char[][] building;
    static boolean[][] visited;
    static ArrayDeque<int[]> people;
    static ArrayDeque<int[]> fire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            building = new char[h][w];
            visited = new boolean[h][w];
            people = new ArrayDeque<>();
            fire = new ArrayDeque<>();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    building[i][j] = line.charAt(j);
                    if (building[i][j] == '@') {
                        people.offer(new int[]{i, j});
                        visited[i][j] = true;
                    } else if (building[i][j] == '*') {
                        fire.offer(new int[]{i, j});
                    }
                }
            }

            int res = bfs();
            sb.append(res == -1 ? "IMPOSSIBLE" : res).append("\n");
        }
        System.out.println(sb);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs() {
        int cnt = 0;

        while (!people.isEmpty()) {
            int fireSize = fire.size();

            for (int s = 0; s < fireSize; s++) {
                int[] curFire = fire.poll();

                int fy = curFire[0];
                int fx = curFire[1];

                for (int i = 0; i < 4; i++) {
                    int ny = fy + dy[i];
                    int nx = fx + dx[i];

                    if (ny < 0 || nx < 0 || ny >= h || nx >= w) {
                        continue;
                    }
                    if (building[ny][nx] != '#' && building[ny][nx] != '*') {
                        fire.offer(new int[]{ny, nx});
                        building[ny][nx] = '*';
                    }
                }
            }

            int peopleCnt = people.size();
            for (int s = 0; s < peopleCnt; s++) {

                int[] curSang = people.poll();

                int cy = curSang[0];
                int cx = curSang[1];

                for (int i = 0; i < 4; i++) {
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];

                    if (ny < 0 || nx < 0 || ny >= h || nx >= w) {
                        return cnt + 1;
                    }

                    if (building[ny][nx] == '.' && !visited[ny][nx]) {
                        people.offer(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}
// G4 불 BFS
// 1시간 30분
// 최단 거리를 구하고 가중치가 1인 문제이기 때문에 BFS 를 고려했다 . 다른 풀이는 잘 모르겠다.
// 상근이와 불 모두 4방향으로 탐색하기 때문에 2개의 큐를 각각 썼다 왜냐하면 가중치가 같기때문에 같은 큐로 사용못했다
// 그리고 사람이 움직이는 시간이 정답이기에 사람단위로 레벨별 BFS 를 사용했다
// 근데 상근이는 불이 올 자리에도 못가기때문에 불 부터 움직이고 불이 있는곳에 상근이가 못가게 했다
// 나는 상근이가 먼저 도착해서 탈출하면 불이 바로뒤에있어도 탈출할 수 이쓸줄알았는데 탈출전에 불이 상근이를 덮친다고 하다
// 일단 풀이 방법에 있어서 자꾸 문제가 생겼다 테스트케이스는 통과했는데
// trouble shooting
// 상근이 이동 -> 불 순서였는데 상근이가 이동하자마자 불이 부틍ㄹ 수 있어서 판단이 안됨