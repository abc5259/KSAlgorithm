package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_3 {
    //동 서 남 북
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static Queue<Vtx> queue = new LinkedList<>();
    static int result;
    static boolean flag = true;
    static boolean[][] visited;
    static int[][] matrix;
    static int m,n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(matrix[i][j] == 1){
                    queue.offer(new Vtx(i, j, 0));
                }
            }
        }



        System.out.println( bfs());
    }

    static int bfs(){
        while(!queue.isEmpty()){
            Vtx current = queue.poll();
            int row = current.row;
            int col = current.col;
            int depth = current.depth;

            visited[row][col] = true;

            for(int i=0; i<4; i++){
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];

                if(nextRow>=0 && nextCol>=0 && nextRow<n && nextCol<m){
                    if(!visited[nextRow][nextCol]){
                        if(matrix[nextRow][nextCol] == 0){
                            visited[nextRow][nextCol] = true;
                            matrix[nextRow][nextCol] = 1;
                            queue.offer(new Vtx(nextRow, nextCol, depth+1));
                        }
                    }
                }
            }
            result = depth;

        }
        if(hasZero())return -1;

        return result;
    }

    static boolean hasZero(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0)return true;
            }
        }
        return false;
    }
}

class Vtx{
    int row;
    int col;
    int depth;

    Vtx(int row, int col, int depth){
        this.row = row;
        this.col = col;
        this.depth = depth;
    }
}