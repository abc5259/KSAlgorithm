package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {
    static char[][] map;
    static int R,C;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        int[] start = new int[2];
        Queue<int[]> fireQ = new LinkedList<>();
        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'J') {
                    start[0] = i;
                    start[1] = j;
                }
                if(map[i][j] == 'F') {
                    fireQ.add(new int[] {i, j});
                }
            }
        }
        int answer = bfs(start, fireQ);
        System.out.println(answer == - 1 ? "IMPOSSIBLE" : answer);
    }

    public static int bfs(int[] start, Queue<int[]> fireQ) {
        boolean[][] isVisited = new boolean[R][C];
        isVisited[start[0]][start[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 1});

        while(!q.isEmpty()) {
            int size = fireQ.size();
            for(int i=0; i<size; i++) {
                int[] fire = fireQ.poll();

                for(int d=0; d<4; d++) {
                    int x = fire[0] + dx[d];
                    int y = fire[1] + dy[d];
                    if(x < 0 || x >= R || y < 0 || y >= C ) continue;
                    if(map[x][y] == 'F' || map[x][y] == '#') continue;

                    fireQ.offer(new int[]{x,y});
                    map[x][y] = 'F';
                }
            }

            int qs = q.size();
            for(int s=0; s<qs; s++) {
                int[] curr = q.poll();

                if(curr[0] == R - 1 || curr[1] == C - 1 || curr[0] == 0 || curr[1] == 0) {
                    return curr[2];
                }

                for(int i=0; i<4; i++) {
                    int x = curr[0] + dx[i];
                    int y = curr[1] + dy[i];

                    if(x < 0 || x >= R || y < 0 || y >= C || isVisited[x][y]) continue;
                    if(map[x][y] == 'F' || map[x][y] == '#') continue;

                    int cnt = curr[2] + 1;
                    if(x == 0 || x == R - 1 || y == 0 || y == C - 1) {
                        return cnt;
                    }
                    isVisited[x][y] = true;
                    q.offer(new int[]{x, y, cnt});
                }
            }
        }

        return -1;
    }
}
