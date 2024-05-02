package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }

        System.out.println(bfs(map, n, m));

    }

    static int bfs(int[][] map, int n, int m){
        Queue<int[]> queue = new LinkedList<>();
        int[][] path = new int[map.length][map[0].length];
        queue.add(new int[] {0,0});
        path[0][0] = 1;

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for(int i=0; i<4; i++){
                int nextRow = now[0] + dr[i];
                int nextCol = now[1] + dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=n || nextCol>=m)continue;
                if(map[nextRow][nextCol]==0 || path[nextRow][nextCol]>1)continue;

                queue.add(new int[] {nextRow, nextCol});
                path[nextRow][nextCol] = path[now[0]][now[1]] + 1;
            }

        }

        return path[n-1][m-1];
    }
}
