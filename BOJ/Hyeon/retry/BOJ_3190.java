package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        // 좌표 격자에서 동서남북으로 움직이는데 이를 나타내는 좌표평면

        int K = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 2;
        }
        // 사과가 들어있는 곳을 2로 표현해서 구분한다.
        // 아무것도 없는 빈공간은 0이다.

        ArrayDeque<Rotate> change = new ArrayDeque<>();

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            change.offer(new Rotate(time, dir));
        }
        // 방향을 정해두는 덱을 만들고 이를 class로 설계하여 넣는다.
        // 이는 time이라는 정수를 비교하여 dir을 변경해주는 자료구조이다.
        // 맨앞부터 비교해서 해당 께 수행되면 출력되는 과정에서 다 할경우는 방향전환이 없다.

        int time = 0;
        // 시작시간
        int y = 1, x = 1, dir = 1;
        // 시작 좌표이고 dir은 방향인데 북 동 남 서 시계방향으로 델타를 만들어서 1로 설정

        ArrayDeque<Point> snake = new ArrayDeque<>();
        // 뱀의 좌표 위치 겹치면 안되기 때문 그리고 머리가 들어가고 꼬리가 나가기에 덱을 사용
        snake.offer(new Point(y, x));
        map[y][x] = 1;
        // 시작 좌표 뱀이 있어서 1로 표현

        while (true) {
            time++;

            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny < 1 || nx < 1 || ny > N || nx > N || map[ny][nx] == 1) {
                break;
            }
            if (map[ny][nx] == 0) {
                Point p = snake.poll();
                map[p.y][p.x] = 0;
            }
            // 만약 빈공간이면 사과가 아니여서 꼬리부분을 0으로 만들고 머리부분을 새롭게 자료구조에 추가한다.

            while (!change.isEmpty()) {
                if (time != change.peek().time) {
                    break;
                } else {
                    Rotate r = change.poll();
                    if (r.dir.equals("L")) {
                        dir = dir - 1 < 0 ? 3 : dir - 1;
                    } else {
                        dir = dir + 1 > 3 ? 0 : dir + 1;
                    }
                }
            }
            // 그다음에 방향 덱 자료구조를 확인해서 time 이 일치할 경우 방향을 회전하고 아니면 종료한다.

            map[ny][nx] = 1;
            snake.offer(new Point(ny, nx));
            y = ny;
            x = nx;
            // 변경된 좌표를 반환해서 다시 loop를 돌게하고
            // 뱀의 좌표를 덱에 추가하고
            // 방문한 좌표를 1로 만든다.
        }
        System.out.println(time);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Rotate {
        int time;
        String dir;

        public Rotate(int time, String dir) {
            this.time = time;
            this.dir = dir;
        }
    }
}

// G4 뱀 자료구조, 시뮬레이션
// 개어렵게 풀었다 오래 걸림
// 일단 여러가지의 동작과정에 대한 것을 글로 서술하고 시작한다