package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17837 {
    static ArrayDeque<Integer>[][] map;
    static int[][] color;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static Point[] points;
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new ArrayDeque[N][N];
        color = new int[N][N];
        points = new Point[K];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = new ArrayDeque<>();
            }
        }

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            points[i] = new Point(i, x-1, y-1, dir-1);
            map[points[i].x][points[i].y].offerFirst(i);
        }

        boolean isGameOver = false;

        int turn = 0;
        while (!isGameOver) {
            turn++;
            if(turn > 1000) {
                turn = -1;
                break;
            }

            for(int i=0; i<K; i++) {
                Point curr = points[i];
                int nextX = curr.x + dx[curr.dir];
                int nextY = curr.y + dy[curr.dir];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || color[nextX][nextY] == 2) {
                    //체스판을 벗어나는 경우거나 파란색이라면

                    //방향을 반대로
                    curr.oppositeDir();
                    nextX = curr.x + dx[curr.dir];
                    nextY = curr.y + dy[curr.dir];

                    if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || color[nextX][nextY] == 2) {
                        //체스판을 벗어나는 경우거나 파란색이라면 이동하지 않고 가만히 있는다.
                       continue;
                    }
                    else if(color[nextX][nextY] == 0) {
                        white(curr, nextX, nextY);
                    }
                    else if(color[nextX][nextY] == 1) { //빨간색이라면
                        red(curr, nextX, nextY);
                    }
                }
                else if(color[nextX][nextY] == 0) {
                    white(curr, nextX, nextY);
                }
                else if(color[nextX][nextY] == 1) { //빨간색이라면
                    red(curr, nextX, nextY);
                }

                if(map[nextX][nextY].size() >= 4) {
                    isGameOver = true;
                    break;
                }
            }

        }
        System.out.println(turn);
    }
    public static void white(Point curr, int x, int y) {
        Stack<Integer> stack = new Stack<>();
        while (map[curr.x][curr.y].peekFirst() != curr.index) {
            int horse = map[curr.x][curr.y].pollFirst();
            points[horse].x = x;
            points[horse].y = y;
            stack.push(horse);
        }
        int horse = map[curr.x][curr.y].pollFirst();
        points[horse].x = x;
        points[horse].y = y;
        stack.push(horse);

        while (!stack.isEmpty()) {
            map[x][y].offerFirst(stack.pop());
        }
    }
    public static void red(Point curr, int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        while (map[curr.x][curr.y].peekFirst() != curr.index) {
            int horse = map[curr.x][curr.y].pollFirst();
            points[horse].x = x;
            points[horse].y = y;
            queue.offer(horse);
        }
        int horse = map[curr.x][curr.y].pollFirst();
        points[horse].x = x;
        points[horse].y = y;
        queue.offer(horse);

        while (!queue.isEmpty()) {
            map[x][y].offerFirst(queue.poll());
        }
    }
    static class Point {
        int index,x,y,dir;
        //오 왼 위 아
        public Point(int index, int x, int y, int dir) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public void oppositeDir() {
            switch (dir) {
                case 0:
                    dir = 1;
                    break;
                case 1:
                    dir = 0;
                    break;
                case 2:
                    dir = 3;
                    break;
                case 3:
                    dir = 2;
                    break;
                default:
                    break;
            }

        }
    }
}
