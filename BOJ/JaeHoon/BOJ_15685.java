package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15685 {
    static int N;
    static int[][] map;
    static int[][] dir = {{0, 1},{-1,0},{0,-1},{1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[101][101];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int x2 = x1 + dir[d][1];
            int y2 = y1 + dir[d][0];
            Queue<Dot> dotq = new LinkedList<>();
            Dot startDot = new Dot(x1, y1);
            dotq.add(startDot);
            solve(g, dotq, new Dot(x2, y2), startDot);
        }


        int sum = 0;
        int[][] d = {{0,1}, {1,1}, {1,0}};
        for(int y=0; y<101; y++) {
            for(int x=0; x<101; x++) {
                if(map[y][x] == 0) continue;
                boolean result = extracted(y, d, x);
                if(result) sum++;
            }
        }
        System.out.println(sum);
    }

    private static boolean extracted(int y, int[][] d, int x) {
        for(int dd=0; dd<3; dd++) {
            int ny = y + d[dd][0];
            int nx = x + d[dd][1];
            if(ny < 0 || ny >= 101 || nx < 0 || nx >= 101) return false;
            if(map[ny][nx] == 0) {
                return false;
            }
        }
        return true;
    }

    static class Dot {
        int x,y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void solve(int gen, Queue<Dot> dotQ, Dot baseDot, Dot startDot) {
        map[baseDot.y][baseDot.x] = 1;
        map[startDot.y][startDot.x] = 1;
        for(int g=1; g<=gen; g++) {
            int size = dotQ.size();
            Dot nxBaseDot = null;
            for(int i=0; i<size; i++) {
                Dot dot = dotQ.poll();
                Dot nextDot = rotateDot(baseDot.x, baseDot.y, dot.x, dot.y);
                map[dot.y][dot.x] = 1;
                map[nextDot.y][nextDot.x] = 1;
                dotQ.offer(dot);
                dotQ.offer(nextDot);
                if(dot.x == startDot.x && dot.y == startDot.y) {
                    nxBaseDot = nextDot;
                }
            }
            dotQ.offer(baseDot);
            baseDot = nxBaseDot;
        }
    }

    public static Dot rotateDot(int endX, int endY, int x, int y) {
        int nx = endX + (endY - y);
        int ny = endY + (x - endX);
        return new Dot(nx,ny);
    }
}
