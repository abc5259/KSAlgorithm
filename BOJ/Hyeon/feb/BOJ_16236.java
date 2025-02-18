package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16236 {
    static int N;
    static int[][] fish;
    static int cury, curx; // 아기 상어 현재 위치
    static int remain = 2; // 크기 증가까지 남은 물고기 수
    static int size = 2; // 아기 상어 크기

    static int[] dy = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        fish = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                fish[i][j] = Integer.parseInt(st.nextToken());
                if (fish[i][j] == 9) {
                    cury = i; // 아기 상어 초기 위치 저장
                    curx = j;
                    fish[i][j] = 0; // 상어 위치는 빈칸으로 처리
                }
            }
        }

        int res = 0;

        while (true) {
            // BFS를 통해 가장 가까운 물고기를 먹고 이동한 거리 반환
            int cnt = bfs(cury, curx);
            if (cnt == 0) { // 더 이상 먹을 수 있는 물고기가 없으면 종료
                break;
            }
            res += cnt; // 이동 거리 누적
            remain--; // 먹은 물고기 수 감소
            if (remain == 0) { // 크기 증가 조건 확인
                size++;
                remain = size;
            }
        }

        System.out.println(res);
    }

    static int bfs(int y, int x) {
        boolean[][] visit = new boolean[N][N]; // 방문 배열 초기화
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt((Node o) -> o.depth)
                .thenComparingInt(o -> o.y)
                .thenComparingInt(o -> o.x)); // 우선순위: 거리 > 위쪽 > 왼쪽

        queue.offer(new Node(y, x, 0));
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // 먹을 수 있는 물고기를 찾은 경우
            if (fish[node.y][node.x] > 0 && fish[node.y][node.x] < size) {
                fish[node.y][node.x] = 0; // 물고기를 먹음
                cury = node.y; // 상어 위치 갱신
                curx = node.x;
                return node.depth; // 이동 거리 반환
            }

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visit[ny][nx] && fish[ny][nx] <= size) {
                    visit[ny][nx] = true;
                    queue.offer(new Node(ny, nx, node.depth + 1));
                }
            }
        }

        return 0; // 더 이상 먹을 수 있는 물고기가 없으면 거리 반환값은 0
    }

    static class Node {
        int y;
        int x;
        int depth;

        public Node(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
}
