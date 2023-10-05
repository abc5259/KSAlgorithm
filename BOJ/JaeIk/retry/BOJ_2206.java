package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
    //동 서 남 북
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int length = 0;
    static char[][] board;
    static boolean[][][] visited;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[2][N][M];

        for(int i=0; i<N; i++){
            String input = br.readLine();

            for(int j=0; j<M; j++){
                board[i][j] = input.charAt(j);
            }
        }

        Queue<wall> q = new LinkedList<>();
        q.offer(new wall(0,0,1,false));

        while(!q.isEmpty()){
            wall cur = q.poll();

            if(cur.i==N-1 && cur.j==M-1){
                System.out.println(cur.count);
                return;
            }

            for(int i=0; i<4; i++){
                int newX = cur.i + dx[i];
                int newY = cur.j + dy[i];
                int newCount = cur.count + 1;

                if(newX<0 || newY<0 || newX>=N || newY>=M)continue;

                //벽이 없을 때
                if(board[newX][newY]=='0'){
                    //방문하지않았고 부순적없는
                    if(!visited[0][newX][newY] && !cur.destroyed){
                        q.offer(new wall(newX, newY, newCount, false));
                        visited[0][newX][newY] = true;
                    }
                    //방문하지않았고 부순적있는
                    else if(!visited[1][newX][newY] && cur.destroyed){
                        q.offer(new wall(newX, newY, newCount, true));
                        visited[1][newX][newY] = true;
                    }
                }
                //벽이 있을 때
                else{
                    if(!cur.destroyed){
                        q.offer(new wall(newX, newY, newCount, true));
                        visited[1][newX][newY] = true;
                    }
                }
            }

        }
        System.out.println(-1);
    }


    static class wall{
        int i;
        int j;
        int count;
        boolean destroyed;

        public wall(int i, int j, int count, boolean destroyed){
            this.i = i;
            this.j = j;
            this.count = count;
            this.destroyed = destroyed;
        }
    }
}
