package BOJ.JaeIk.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {
    static int startRow, startCol;
    static boolean isStartCheck = false;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] distance;
    static boolean[][] visited;
    static int n, m;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        distance = new int[n][m];
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(!isStartCheck){
                    if(map[i][j] == 2){
                        isStartCheck = true;
                        startRow = i;
                        startCol = j;
                    }
                }
            }
        }

        bfs(startRow,startCol);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (!visited[i][j] && map[i][j] == 1)
                    sb.append(-1 + " ");
                else
                    sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int row, int col){
        Queue<Pair> queue = new LinkedList<>();
        Pair pair = new Pair(row, col);
        queue.add(pair);
        visited[row][col] = true;
        distance[row][col] = 0;

        while(!queue.isEmpty()){
            Pair current = queue.poll();
            int currentRow = current.row;
            int currentCol = current.col;

            for(int i=0; i<4; i++){
                int nextRow = currentRow + dr[i];
                int nextCol = currentCol + dc[i];

                if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<m && !visited[nextRow][nextCol]){
                    if(map[nextRow][nextCol] != 0){
                        visited[nextRow][nextCol] = true;
                        queue.add(new Pair(nextRow, nextCol));
                        distance[nextRow][nextCol] = distance[currentRow][currentCol]+1;
                    }
                }
            }
        }
    }
}

class Pair{
    int row;
    int col;

    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}