package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {
    static int R, C;
    static char[][] map;
    static int[][] time;
    static Queue<int[]> jihoonQ;
    static Queue<int[]> fireQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        time = new int[R][C];

        jihoonQ = new ArrayDeque<>();
        fireQ = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                time[i][j] = -1;
                if (map[i][j] == 'J') {
                    jihoonQ.offer(new int[]{i, j});
                    time[i][j] = 0;
                } else if (map[i][j] == 'F') {
                    fireQ.offer(new int[]{i, j});
                }
            }
        }
        System.out.println(bfs());
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static String bfs() {
        while (!jihoonQ.isEmpty()) {

            int size = fireQ.size();
            while (size-- > 0) {
                int[] fire = fireQ.poll();

                int cy = fire[0];
                int cx = fire[1];

                for (int i = 0; i < 4; i++) {
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];

                    if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                        continue;
                    }
                    if (map[ny][nx] == 'F' || map[ny][nx] == '#') {
                        continue;
                    }
                    fireQ.offer(new int[]{ny, nx});
                    map[ny][nx] = 'F';
                }
            }

            size = jihoonQ.size();
            while (size-- > 0) {
                int[] poll = jihoonQ.poll();

                int cy = poll[0];
                int cx = poll[1];

                for (int i = 0; i < 4; i++) {
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];

                    if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                        return String.valueOf(time[cy][cx] + 1);
                    }
                    if (time[ny][nx] == -1 && map[ny][nx] == '.') {
                        jihoonQ.offer(new int[]{ny, nx});
                        time[ny][nx] = time[cy][cx] + 1;
                    }
                }
            }


        }
        return "IMPOSSIBLE";
    }
}
// G3 BFS 불! 복습
// 33분
// 일단 2개의 BFS 를 태워야된다 지훈이와 불 근데 불이 먼저 움직이는게 더 좋은 풀이같다
// 왜냐하면 내가 기존에 풀었던 거는 사람이 움직이고 그다음에 그 자리에 불이 붙으면
// 사람이 BFS 를 돌릴때 불이 붙었는지에 대한 여부를 확인하고 4방 탐색을 했는데
// 이거보다 그냥 불부터 움직이면 애초에 그 자리를 사람이 안갈테니까 불이 먼저 움직이는게 나았고 또 더해서
// while 로 isEmpty 로 계속하다보면 계속 그 BFS 만 반복하기 떄문에 size 별로 이게 레벨별로 돌려야 되는
// BFS 였다. 즉 시간 단위 이동거리 별로 BFS 를 돌려야 하는데 습관처럼 while(!queue.isEmpty())를 쓰는순간
// 불이나 사람부터 다 가버린다.