package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
    static int n,m;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static char[][] maze;
    static boolean visited[][][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new char[n][m];
        visited = new boolean[2][n][m];

        //문자타입으로 입력받아야한다
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = input.charAt(j);
            }
        }

        Queue<wall> q = new LinkedList<>();
        q.offer(new wall(0,0,1,false));

        while(!q.isEmpty()){
            wall now = q.poll();

            if (now.i == n - 1 && now.j == m - 1) {
                System.out.println(now.count);
                return;
            }

            for(int i=0; i<4; i++){
                int newX = now.i + dx[i];
                int newY = now.j + dy[i];
                int newCount = now.count+1;

                if(newX<0||newY<0||newX>=n||newY>=m)continue;

                //벽이 없을 때
                if(maze[newX][newY]=='0'){
                    if(!visited[0][newX][newY] && !now.destroyed){
                        q.offer(new wall(newX, newY, newCount, false));
                        visited[0][newX][newY] = true;
                    }
                    else if(!visited[1][newX][newY] && now.destroyed){
                        q.offer(new wall(newX, newY, newCount, true));
                        visited[1][newX][newY] = true;
                    }
                }
                //벽이 있을 때
                else{
                    if(!now.destroyed){
                        q.offer(new wall(newX, newY, newCount, true));
                        visited[1][newX][newY]=true;
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
