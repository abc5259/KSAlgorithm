package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683 {
    static int N,M;
    static int[][] map;
    static List<int[]> cctvs = new ArrayList<>();
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static int[] selects;
    static int min = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 5) cctvs.add(new int[]{i, j});
            }
        }

        selects = new int[cctvs.size()];

        solve(0);
        System.out.println(min);
    }

    static void solve(int depth) {
        if(depth == cctvs.size()) {
            int[][] copyMap = map.clone();
            for(int i=0; i<N; i++) {
                copyMap[i] = map[i].clone();
            }

            int idx = 0;
            for(int[] cctv: cctvs) {
                int num = map[cctv[0]][cctv[1]];
                int pick = selects[idx++];
                changeMap(cctv, num, pick, copyMap);
            }

            int cnt = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(copyMap[i][j] == 0) cnt++;
                }
            }

            min = Math.min(min, cnt);
            return;
        }

        int[] pos = cctvs.get(depth);
        if(map[pos[0]][pos[1]] == 1) {
            for(int i=0; i<4; i++) {
                selects[depth] = i;
                solve(depth+1);
            }
        }
        else if(map[pos[0]][pos[1]] == 2) {
            for(int i=0; i<2; i++) {
                selects[depth] = i;
                solve(depth+1);
            }
        }
        else if(map[pos[0]][pos[1]] == 3) {
            for(int i=0; i<4; i++) {
                selects[depth] = i;
                solve(depth+1);
            }
        }
        else if(map[pos[0]][pos[1]] == 4) {
            for(int i=0; i<4; i++) {
                selects[depth] = i;
                solve(depth+1);
            }
        }
        else if(map[pos[0]][pos[1]] == 5) {
            for(int i=0; i<1; i++) {
                selects[depth] = i;
                solve(depth+1);
            }
        }
    }

    private static void changeMap(int[] cctv, int num, int pick, int[][] copyMap) {
        if(num == 1) {
            change(cctv, dir[pick], copyMap);
        }
        else if(num == 2) {
            if(pick == 0) {
                change(cctv, dir[0], copyMap);
                change(cctv, dir[1], copyMap);
            }
            else if(pick == 1) {
                change(cctv, dir[2], copyMap);
                change(cctv, dir[3], copyMap);
            }
        }
        else if(num == 3) {
            if(pick == 0) {
                change(cctv, dir[3], copyMap);
                change(cctv, dir[0], copyMap);
            }
            else if(pick == 1) {
                change(cctv, dir[0], copyMap);
                change(cctv, dir[2], copyMap);
            }
            else if(pick == 2) {
                change(cctv, dir[2], copyMap);
                change(cctv, dir[1], copyMap);
            }
            else if(pick == 3) {
                change(cctv, dir[1], copyMap);
                change(cctv, dir[3], copyMap);
            }
        }
        else if(num == 4) {
            if(pick == 0) {
                change(cctv, dir[3], copyMap);
                change(cctv, dir[0], copyMap);
                change(cctv, dir[2], copyMap);
            }
            else if(pick == 1) {
                change(cctv, dir[0], copyMap);
                change(cctv, dir[2], copyMap);
                change(cctv, dir[1], copyMap);
            }
            else if(pick == 2) {
                change(cctv, dir[2], copyMap);
                change(cctv, dir[1], copyMap);
                change(cctv, dir[3], copyMap);
            }
            else if(pick == 3) {
                change(cctv, dir[1], copyMap);
                change(cctv, dir[3], copyMap);
                change(cctv, dir[0], copyMap);
            }
        }
        else if(num == 5) {
            change(cctv, dir[0], copyMap);
            change(cctv, dir[1], copyMap);
            change(cctv, dir[2], copyMap);
            change(cctv, dir[3], copyMap);
        }
    }

    public static void change(int[] cctvPos, int[] dir, int[][] arr) {
        int nx = cctvPos[0];
        int ny = cctvPos[1];
        while (nx + dir[0] >= 0 && nx + dir[0] < N && ny + dir[1] >= 0 && ny + dir[1] < M) {
            nx += dir[0];
            ny += dir[1];
            if(arr[nx][ny] == 6) break;
            arr[nx][ny] = 9;
        }
    }
}
