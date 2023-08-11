package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static int n,m;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1)q.add(new int[]{i,j});
            }
        }

        System.out.println(bfs());
    }

    static int bfs(){
        while(!q.isEmpty()){
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = x+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m)continue;
                if(map[nx][ny]==0){
                    map[nx][ny] = map[x][y]+1;
                    q.add(new int[] {nx, ny});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        if(isZero())return -1;
        else{
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j]>max)max=map[i][j];
                }
            }
            return max-1;
        }
    }

    static boolean isZero(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0)return true;
            }
        }
        return false;
    }
}
