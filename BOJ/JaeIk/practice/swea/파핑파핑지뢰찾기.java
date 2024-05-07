package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 파핑파핑지뢰찾기 {
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dc = {1, -1, 0, 0, -1, 1, -1, 1};
    static char[][] map;
    static int[][] state;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());

            map = new char[n][n];
            for(int i=0; i<n; i++){
                map[i] = br.readLine().toCharArray();
            }

            state = new int[n][n];
            updateState();

            int count = 0;
            visited = new boolean[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j] && state[i][j]==0){
                        bfs(i, j);
                        count++;
                    }
                }
            }


            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j] && state[i][j]!=-1){
                        count++;
                    }
                }
            }

            System.out.println("#"+(tc+1)+" "+count);
        }
    }

    static void bfs(int row, int col){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()){

            int[] now = queue.poll();
            int nowRow = now[0];
            int nowCol = now[1];

            for(int i=0; i<8; i++){
                int nextRow = nowRow + dr[i];
                int nextCol = nowCol + dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=n || nextCol>=n)continue;
                if(visited[nextRow][nextCol])continue;
                if(state[nextRow][nextCol] == -1)continue;

                visited[nextRow][nextCol] = true;

                if(state[nextRow][nextCol] == 0){
                    queue.add(new int[] {nextRow, nextCol});
                }
            }
        }
    }

    static void updateState(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == '*') {
                    state[i][j]=-1;
                    continue;
                }

                for(int k=0; k<8; k++){
                    int nextRow = i + dr[k];
                    int nextCol = j + dc[k];

                    if(nextRow<0 || nextCol<0 || nextRow>=n || nextCol>=n)continue;

                    if(map[nextRow][nextCol] == '*'){
                        state[i][j]++;
                    }
                }
            }
        }
    }
}
