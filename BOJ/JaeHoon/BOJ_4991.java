package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4991 {
    static int W, H;
    static char[][] map;
    static int[] start;
    static boolean[][] isVisited;
    static int[][] dist;
    static int[][] list;
    static boolean[] isUsed;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int cleanTotal;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if(W == 0 || H == 0) break;

            list = new int[11][2];
            map = new char[H][W];
            answer = Integer.MAX_VALUE;
            cleanTotal = 1;
            for(int i=0; i<H; i++) {
                String s = br.readLine();
                for(int j=0; j<W; j++) {
                    map[i][j] = s.charAt(j);
                    if(map[i][j] == 'o') {
                        start = new int[]{i,j};
                        list[0][0] = i;
                        list[0][1] = j;
                        map[i][j] = '.';
                    }
                    if(map[i][j] == '*') {
                        list[cleanTotal][0] = i;
                        list[cleanTotal][1] = j;
                        cleanTotal++;
                    }
                }
            }
//            System.out.println("cleanTotal = " + cleanTotal);
            dist = new int[cleanTotal][cleanTotal];
            isUsed = new boolean[dist.length];

            solveDist();
            sb.append(answer).append("\n");
        }
//        System.out.println(Arrays.deepToString(dist));
        System.out.println(sb);
    }

    public static void solveDist() {

        int N = dist.length;
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                int d = bfs(list[i], list[j]);
                if(d == -1) {
                    answer = -1;
                    return;
                }
                dist[i][j] = dist[j][i] = d;
            }
        }

        solve(1, 0, 0);
    }

    public static void solve(int depth, int prev, int sum) {
        if(depth == dist.length) {
            answer = Math.min(sum, answer);
            return;
        }

        for(int i=1; i<dist.length; i++) {
            if(isUsed[i]) continue;

            isUsed[i] = true;
            solve(depth + 1, i, sum + dist[prev][i]);
            isUsed[i] = false;
        }
    }

    public static int bfs(int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>();
        isVisited = new boolean[H][W];
        isVisited[start[0]][start[1]] = true;
        q.offer(new int[]{start[0], start[1], 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for(int i=0; i<4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if(nx < 0 || nx >= H || ny < 0 || ny >= W || isVisited[nx][ny]) continue;
                if(map[nx][ny] == 'x') continue;

                if(nx == end[0] && ny == end[1]) return curr[2] + 1;

                isVisited[nx][ny] = true;
                q.offer(new int[]{nx, ny, curr[2] + 1});
            }
        }

        return -1;
    }


}
