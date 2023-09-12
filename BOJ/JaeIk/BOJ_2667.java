package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667 {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<int[]> q = new LinkedList();
    static boolean[][] visited;
    static int apt_cnt=0;
    static int[] apts;
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        apts = new int[N*N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]==false && map[i][j]==1){
                    apt_cnt++;
                    bfs(i,j);
                }
            }
        }

        Arrays.sort(apts);
        System.out.println(apt_cnt);
        for(int i=0; i<apts.length; i++){
            if(apts[i] != 0){
                System.out.println(apts[i]);
            }
        }
    }

    static void bfs(int x, int y){
        q.offer(new int[] {x,y});
        visited[x][y] = true;
        apts[apt_cnt]++;

        while(!q.isEmpty()){
            int xidx = q.peek()[0];
            int yidx = q.peek()[1];
            q.poll();

            for(int i=0; i<4; i++){
                int xnext = xidx + dx[i];
                int ynext = yidx + dy[i];

                if(check(xnext, ynext) && map[xnext][ynext]==1 && !visited[xnext][ynext]){
                    q.add(new int[] {xnext, ynext});
                    visited[xnext][ynext] = true;
                    apts[apt_cnt]++;
                }
            }
        }
    }

    static boolean check(int x, int y){
        return x>=0 && y>=0 && x<N && y<N;
    }

}
