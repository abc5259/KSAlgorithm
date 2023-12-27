package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int n, m;
    //동 서 북 남
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] distance;
    static int[][] graph;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distance = new int[n][m];
        graph = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();

            for(int j=0; j<m; j++){
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(distance[n-1][m-1]);

    }

    static void bfs(){
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(0, 0));
        visited[0][0] = true;
        distance[0][0] = 1;

        while(!queue.isEmpty()){
            Coordinate current = queue.poll();
            int row = current.row;
            int col = current.col;

            for(int i=0; i<4; i++){
                int nextRow = row + dx[i];
                int nextCol = col + dy[i];

                if(nextRow>=0 && nextCol>=0 && nextRow<n && nextCol<m){
                    if(graph[nextRow][nextCol]==1 && !visited[nextRow][nextCol]){
                        queue.add(new Coordinate(nextRow, nextCol));
                        distance[nextRow][nextCol] = distance[row][col] + 1;
                        visited[nextRow][nextCol] = true;
                    }
                }
            }

        }

    }
}

class Coordinate{
    int row;
    int col;

    Coordinate(int row, int col){
        this.row = row;
        this.col = col;
    }
}
