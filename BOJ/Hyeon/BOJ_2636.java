package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {
    static int r, c;
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<int[]> cheese;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        int size = 0;

        while (true) {
            visit = new boolean[r][c];
            cheese = new ArrayList<>();

            bfs();

            if (cheese.isEmpty()) {
                break;
            }

            melting();
            cnt++;
            size = cheese.size();
        }
        System.out.println(cnt + "\n" + size);
    }

    private static void melting() {
        for (int[] pair : cheese) {
            map[pair[0]][pair[1]] = 0;
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= r || nx >= c || visit[ny][nx]) {
                    continue;
                }
                if (map[ny][nx] == 0) {
                    queue.offer(new int[]{ny, nx});
                } else {
                    cheese.add(new int[]{ny, nx});
                }
                visit[ny][nx] = true;
            }
        }
    }
}
// G4 치즈 BFS
// 27분
// 일단 내가 생각하기에는 0인 공기부분과 치즈가 맞닿아 있으면 그 자리를 기억하고 그 자리를 0으로 만들고
// 그런 갯수를 반환해서 이 개수가 0이되면 그때 탈출한다고 생각했는데
// map의 크기는 10000까지되고 각 좌표별로 4방향을 탐색하고 더해서 이게 모든 치즈가 다 차있다면 적어도
// 50번의 횟수는 반복되어야 하기에 이러면 시간초과가 발생할 거 같았다
// 그래서 플러드필을 통해서 공기로 퍼져나가다가 치즈를 만나면 리스트에 따로 그 좌표를 추가하고
// 방문 여부만 따졌고 공기는 계속해서 큐에 넣어서 진행했다
// 그런데 이때 내가 내부의 빈공간은 입구가 없으면 하면 안되기에 r과 c 영역내의 반복문을 돌리지 않았다
// 그래서 melting 으로 녹여야되는 치즈좌표로 치즈를 녹이고 이 값의 size 를 기억해서 반환하는데