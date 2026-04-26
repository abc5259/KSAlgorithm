package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3197 {
    static int R, C;
    static char[][] map;
    static boolean[][] visit;
    static int endY = -1, endX = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];

        Queue<Node> waterQ = new ArrayDeque<>();
        Queue<Node> swanQ = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] != 'X') {
                    waterQ.offer(new Node(i, j));
                }

                if (map[i][j] == 'L') {
                    if (swanQ.isEmpty()) {
                        swanQ.offer(new Node(i, j));
                        visit[i][j] = true;
                    } else {
                        endY = i;
                        endX = j;
                    }
                }
            }
        }
        Queue<Node> nextWaterQ = new ArrayDeque<>();
        Queue<Node> nextSwanQ = new ArrayDeque<>();

        int day = 0;

        while (true) {

            if (moveSwan(swanQ, nextSwanQ)) {
                System.out.println(day);
                break;
            }

            meltIce(waterQ, nextWaterQ);

            swanQ = nextSwanQ;
            nextSwanQ = new ArrayDeque<>();

            waterQ = nextWaterQ;
            nextWaterQ = new ArrayDeque<>();

            day++;
        }
    }

    static boolean moveSwan(Queue<Node> swanQ, Queue<Node> nextSwanQ) {
        while (!swanQ.isEmpty()) {
            Node cur = swanQ.poll();

            if (cur.y == endY && cur.x == endX) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C || visit[ny][nx]) {
                    continue;
                }

                visit[ny][nx] = true;

                if (map[ny][nx] == 'X') {
                    nextSwanQ.offer(new Node(ny, nx));
                } else {
                    swanQ.offer(new Node(ny, nx));
                }
            }
        }
        return false;
    }

    static void meltIce(Queue<Node> waterQ, Queue<Node> nextWaterQ) {
        while (!waterQ.isEmpty()) {
            Node cur = waterQ.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }

                if (map[ny][nx] == 'X') {
                    map[ny][nx] = '.';
                    nextWaterQ.offer(new Node(ny, nx));
                }
            }
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class Node {

        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
// P5 백조의 호수 BFS
// 1시간 10분
// R, C가 최대 1500 으로 BFS를 돌리면 무조건 시간 초과
// 방문했던 곳을 초기화 안하고 큐를 최신화-> 최대 1번씩만 방문 그래서 O(R*C)
// 백조 이동 얼음 만나면 내일 탐색을 위해 nextSwanQ에 물이면 오늘 계속 가기 위해 swanQ에
// 얼음 발견하면 물로 바꾸고 내일 다시 주변을 녹이기 시작 nextWaterQ
// 하루 ++ 마다 swanQ = nextSwanQ waterQ = nextWaterQ 로 최신화