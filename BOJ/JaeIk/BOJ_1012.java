package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<int[]> q;
    static int T, N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            count = 0;

            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int f = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[f][b] = 1;
            }

            for(int k=0; k<N; k++){
                for(int c=0; c<M; c++){
                    if(map[k][c]==1 && !visited[k][c]){
                        bfs(k, c);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y){
        q = new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()){
            int cur_x = q.peek()[0];
            int cur_y = q.peek()[1];
            visited[x][y] = true;
            q.poll();

            for(int i=0; i<4; i++){
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];

                if(check(next_x, next_y) && map[next_x][next_y]==1 && !visited[next_x][next_y]){
                    q.add(new int[] {next_x, next_y});
                    visited[next_x][next_y] = true;
                }
            }

        }

    }

    static boolean check(int x, int y){
        return x>=0 && y>=0 && x<N && y<M;
    }
}
