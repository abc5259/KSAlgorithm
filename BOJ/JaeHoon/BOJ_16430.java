package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_16430 {
    static int R, C;
    static char[][] map;
    static Queue<Point> q = new LinkedList<>();
    static String go;
    static int[] start;
    static int[] dx = {1,1,1,0,0,0,-1,-1,-1};
    static int[] dy = {-1,0,1,-1,0,1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        start = new int[2];
        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                char c = s.charAt(j);
                map[i][j] = s.charAt(j);
                if(c == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
                else if(c == 'R') {
                    q.offer(new Point(i,j));
                }
            }
        }
        go = br.readLine();

        int result = solve();
        if(result != -1) {
            System.out.println("kraj " + result);
            return;
        }

        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int solve() {
        int cnt = 0;
        for(int i=0; i<go.length(); i++) {
            cnt++;
            int dIdx = go.charAt(i) - '0' - 1;
            int nx = start[0] + dx[dIdx];
            int ny = start[1] + dy[dIdx];

            if(nx >= R) nx = R-1;
            if(ny >= C) ny = C-1;

            if(map[nx][ny] == 'R') { //미친 아두이노 만나면 게임 종료
                return cnt;
            }

            map[start[0]][start[1]] = '.';
            map[nx][ny] = 'I';
            start[0] = nx;
            start[1] = ny;

            int size = q.size();
            Map<Point, Integer> pointMap = new HashMap<>();
            for(int k=0; k<size; k++) {
                Point curr = q.poll();

                int idx = findIdx(curr.x, curr.y);
                int nnx = curr.x + dx[idx];
                int nny = curr.y + dy[idx];
                if(nnx >= R) nnx = R-1;
                if(nny >= C) nny = C-1;

                if(nnx == start[0] && nny == start[1]) return cnt;

                map[curr.x][curr.y] = '.';
                Point next = new Point(nnx, nny);
                pointMap.put(next, pointMap.getOrDefault(next, 0) + 1);
            }

            for(Entry<Point, Integer> entries : pointMap.entrySet()) {
                if(entries.getValue() == 1) {
                    Point p = entries.getKey();
                    map[p.x][p.y] = 'R';
                    q.offer(p);
                }
            }
        }

        return -1;
    }

    static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    static int findIdx(int x, int y) {
        int minDir = Integer.MAX_VALUE;
        int minIdx = -1;

        for(int d=0; d<9; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx >= R) nx = R-1;
            if(ny >= C) ny = C-1;

            int dir = Math.abs(start[0] - nx) + Math.abs(start[1] - ny);
            if(dir < minDir) {
                minDir = dir;
                minIdx = d;
            }
        }

        return minIdx;
    }
}
