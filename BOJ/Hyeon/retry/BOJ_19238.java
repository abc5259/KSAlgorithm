package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_19238 {
    static int N, fuel;
    static boolean[][] wall;
    static Map<Start, int[]> person;
    static int taxiY, taxiX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        wall = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    wall[i][j] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        taxiY = Integer.parseInt(st.nextToken()) - 1;
        taxiX = Integer.parseInt(st.nextToken()) - 1;

        person = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int startY = Integer.parseInt(st.nextToken()) - 1;
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int endY = Integer.parseInt(st.nextToken()) - 1;
            int endX = Integer.parseInt(st.nextToken()) - 1;

            person.put(new Start(startY, startX), new int[]{endY, endX});
        }


        for (int i = 0; i < M; i++) {
            int dist = searchPerson();

            if (dist == -1 || fuel < dist) {
                System.out.println(-1);
                return;
            }
            fuel -= dist;

            int[] des = person.get(new Start(taxiY, taxiX));
            person.remove(new Start(taxiY, taxiX));

            dist = go(taxiY, taxiX, des[0], des[1]);

            if (dist == -1 || fuel < dist) {
                System.out.println(-1);
                return;
            }
            fuel += dist;

            taxiY = des[0];
            taxiX = des[1];
        }
        System.out.println(fuel);
    }

    static class Node implements Comparable<Node> {
        int y;
        int x;
        int dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist == o.dist) {
                if (this.y == o.y) {
                    return this.x - o.x;
                }
                return this.y - o.y;
            } else {
                return dist - o.dist;
            }
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1}; // 반시계

    static class Start {
        int y;
        int x;


        Start(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Start start = (Start) o;
            return y == start.y && x == start.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }

    }

    static int searchPerson() {
        boolean[][] visit = new boolean[N][N];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(taxiY, taxiX, 0));
        visit[taxiY][taxiX] = true;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int cy = poll.y;
            int cx = poll.x;
            int dist = poll.dist;

            if (person.containsKey(new Start(cy, cx))) {
                taxiY = cy;
                taxiX = cx;

                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || wall[ny][nx] || visit[ny][nx]) {
                    continue;
                }
                visit[ny][nx] = true;
                pq.offer(new Node(ny, nx, dist + 1));
            }
        }
        return -1;
    }

    static int go(int startY, int startX, int endY, int endX) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startY, startX, 0});

        boolean[][] visit = new boolean[N][N];
        visit[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];
            int dist = poll[2];

            if (cy == endY && cx == endX) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || wall[ny][nx] || visit[ny][nx]) {
                    continue;
                }
                visit[ny][nx] = true;
                queue.offer(new int[]{ny, nx, dist + 1});
            }
        }
        return -1;
    }
}
// G2 스타트 택시 시뮬레이션 BFS
// 1시간 18분 + 20분
// trouble shooting
// 1. 탑승자들의 정보를 저장하려했다 왜냐하면 M개라서 O(N)이면 시간 초과가 발생할거 같아서
// 일단 Map<int[], int[] > 사용해서 get으로 O(1) 하려했는데 int[] 는 배열 객체잖아
// 근데 key랑 비교할때 주소값 보는데 참조값과 내부값에 대한 동일성 동등성때문에 제대로된
// 비교가 안되어서 Class 를 통해서 equals 를 배정했다.
// 2. BFS 탐색 순서
// 상 좌 하 우 를 통한 4방 탐색이 행 번호 열번호 순서가 될 줄 알았는데 벽이 없을때는 괜찮은데
// 벽이 있으면 돌아가는 경로 때문에 큐에 들어가는 순서가 꼬일 수 있다.벽때메 막히면 아래 사람이 먼저 나올테니,,
// -> 큐 넣을때부터 정렬되도록 Comparable 구현한 PQ에 저장.
// 아무생각없이 StringTokenizer 대신에 charAt 해버려서 개고생함
// Map 의 키는 배열을 쓰지않는데 Class 나 Integer 로 비교