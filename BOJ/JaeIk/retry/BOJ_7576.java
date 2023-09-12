package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<int[]> q = new LinkedList<>();
    static int days=0;
    static int[][] map;
    static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1){
                    q.add(new int[] {i,j});
                }
            }
        }


        bfs();

    }

    static boolean checkRange(int x, int y){
        return x>=0 && y>=0 && x<N && y<M;
    }

    private static boolean checkZero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    return true;
            }
        }
        return false;
    }

    static int bfs(){
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int cur_x = temp[0];
            int cur_y = temp[1];

            for(int i=0; i<4; i++){
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];

                if(checkRange(next_x, next_y))continue;
                if(map[next_x][next_y] == 0){
                    map[next_x][next_y] = map[cur_x][cur_y] + 1;
                    q.add(new int[] {next_x, next_x});

                }
            }
        }

        int max = Integer.MIN_VALUE;

        if(checkZero())return -1;
        else {
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    max = Math.max(max, map[i][j]);
                }
            }

            return max-1;
        }
    }
}
