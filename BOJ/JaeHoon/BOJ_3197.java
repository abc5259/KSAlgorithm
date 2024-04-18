package BOJ.JaeHoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3197 {
    static char[][] map;
    static List<int[]> swanPositions = new ArrayList<>();
    static boolean[][] isVisited;
    static int R,C;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<int[]> waters = new LinkedList<>();
    static Queue<int[]> startQ = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        isVisited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'L') {
                    swanPositions.add(new int[]{i,j});
                    map[i][j] ='.';
                }
                if(map[i][j] == '.') {
                    waters.add(new int[]{i,j});
                }
            }
        }

        startQ.add(swanPositions.get(0));
        isVisited[swanPositions.get(0)[0]][swanPositions.get(0)[1]] = true;

        int cnt = 0;

        while (!check()) {
            melt();
            cnt++;
        }

        System.out.println(cnt);
    }

    static public void melt() {

        int size = waters.size();

        for(int i=0; i<size; i++) {
            int[] curr = waters.poll();

            for(int d=0; d<4; d++) {
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                if(map[nx][ny] == 'X') {
                    map[nx][ny] = '.';
                    waters.add(new int[]{nx,ny});
                }
            }
        }

    }

    static public boolean check() {

        Queue<int[]> newStartQ = new LinkedList<>();

        while (!startQ.isEmpty()) {
            int[] curr = startQ.poll();

            for(int d=0; d<4; d++) {
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if(nx < 0 || nx >= R || ny < 0 || ny >= C || isVisited[nx][ny]) continue;

                isVisited[nx][ny] = true;

                if(nx == swanPositions.get(1)[0] && ny == swanPositions.get(1)[1]) return true;
                if(map[nx][ny] == '.') {
                    startQ.add(new int[]{nx,ny});
                }
                if(map[nx][ny] == 'X') {
                    newStartQ.add(new int[]{nx,ny});
                }

            }
        }

        startQ = newStartQ;

        return false;
    }
}
