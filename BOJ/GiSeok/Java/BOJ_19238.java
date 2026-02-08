package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19238 {
    // 임마 핵심은 손님들의 출발지는 다 다르지만,
    // 손님들의 도착지는 같을 수 있으며 누군가의 출발지가 누군가의 도착지 일 수 있다.
    // 즉, 출발지와 도착지를 따로 관리해야 함.
    // 도착지 같은 경우에 출발지와 묶어서 관리해야 함
    // 왜냐면, 두 손님이 같은 도착지일때 배열로 관리하려면 arrive[n+1][n+1][m]; 로 관리해줘야 함
    // 그래서 (출발지, 도착지) 쌍을 관리하는게 좋음.

    static int n, m;
    static int fuel;
    static int[][] map;
    static int[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Point {
        int y, x;
        int ay, ax;

        public Point(int y, int x, int ay, int ax) {
            this.y = y;
            this.x = x;
            this.ay = ay;
            this.ax = ax;
        }
    }

    static class Customer {
        Point point;
        int distance;

        public Customer(Point point, int distance) {
            this.point = point;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<Point> customers = new ArrayList<>();

        int[][] started = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) Arrays.fill(started[i], Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            // 출발지 손님 번호와 customers 인덱스 일치시켜 탐색하기 편하도록
            started[y1][x1] = i;
            customers.add(new Point(y1, x1, y2, x2));
        }

        boolean[] realVisited = new boolean[m];
        while (!isFinish(realVisited)) {
            PriorityQueue<Customer> pq = new PriorityQueue<>((o1, o2) -> {
                if (o1.distance == o2.distance) {
                    if (o1.point.y == o2.point.y) return o1.point.x - o2.point.x;
                    return o1.point.y - o2.point.y;
                }

                return o1.distance - o2.distance;
            });

            // 출발지 탐색하여 거리, 행, 열 순의 우선순위 큐로 정렬
            bfs(y, x);
            for (int i = 0; i < customers.size(); i++) {
                if (!realVisited[i]) {
                    Point point = customers.get(i);
                    pq.add(new Customer(point, visited[point.y][point.x]));
                }
            }

            // 손님 출발지 탐색 이후, 도착지 가는 과정
            if (pq.isEmpty()) {
                System.out.println(-1);
                return;
            }

            Customer poll = pq.poll();
            fuel -= poll.distance;
            if (fuel <= 0) {
                System.out.println(-1);
                return;
            }

            bfs(poll.point.y, poll.point.x);
            if (visited[poll.point.ay][poll.point.ax] == Integer.MAX_VALUE || fuel - visited[poll.point.ay][poll.point.ax] < 0) {
                System.out.println(-1);
                return;
            }
            fuel -= visited[poll.point.ay][poll.point.ax];

            // 방문 완료 후 해당 순번 손님 지우기
            realVisited[started[poll.point.y][poll.point.x]] = true;
            started[poll.point.y][poll.point.x] = Integer.MAX_VALUE;
            fuel += (visited[poll.point.ay][poll.point.ax] * 2);
            y = poll.point.ay;
            x = poll.point.ax;
        }

        System.out.println(fuel);
    }

    private static void bfs(int y, int x) {
        visited = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.add(y);
        q.add(x);
        visited[y][x] = 0;
        while (!q.isEmpty()) {
            int py = q.poll();
            int px = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = py + dy[i];
                int nx = px + dx[i];

                if (ny <= 0 || nx <= 0 || ny > n || nx > n) continue;
                if (visited[ny][nx] <= visited[py][px] + 1) continue;
                if (map[ny][nx] == 1) continue;

                q.add(ny);
                q.add(nx);
                visited[ny][nx] = visited[py][px] + 1;
            }
        }
    }

    private static boolean isFinish(boolean[] real) {
        for (int i = 0; i < m; i++) {
            if (!real[i]) return false;
        }
        return true;
    }
}
