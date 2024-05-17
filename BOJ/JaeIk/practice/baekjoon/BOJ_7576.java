package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static int[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    queue.add(new int[] {i,j});
                    visited[i][j] = 0;
                }
            }
        }

        bfs(queue, visited);

        int day = 0;
        total : for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 0){
                    day = -1;
                    break total;
                }
                day = Math.max(day, visited[i][j]);
            }
        }

        System.out.println(day);
    }

    static void bfs(Queue<int[]> queue, int[][] visited){
        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for(int i=0; i<4; i++){
                int nextRow = now[0] + dr[i];
                int nextCol = now[1] + dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=map.length || nextCol>=map[0].length)continue;
                if(map[nextRow][nextCol]==-1 || map[nextRow][nextCol]==1)continue;

                visited[nextRow][nextCol] = visited[now[0]][now[1]] + 1;
                map[nextRow][nextCol] = 1;
                queue.add(new int[] {nextRow, nextCol});
            }
        }
    }
}
