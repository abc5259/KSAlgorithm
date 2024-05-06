package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ladder1 {
    static int[] dr = {0, 0, 1};
    static int[] dc = {1, -1, 0};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++){
            br.readLine();

            map = new int[100][100];
            for(int i=0; i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int j=0; j<100; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for(int i=0; i<100; i++){
                if(map[0][i] == 1){
                    if(bfs(0, i)){
                        result = i;
                        break;
                    }
                }
            }

            System.out.println("#"+(tc+1)+" "+result);
        }
    }

    static boolean bfs(int row, int col){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[100][100];
        queue.add(new int[] {row, col});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowRow = now[0];
            int nowCol = now[1];

            if(map[nowRow][nowCol] == 2)return true;

            for(int i=0; i<3; i++){
                int nextRow = nowRow + dr[i];
                int nextCol = nowCol + dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=100 || nextCol>=100)continue;
                if(visited[nextRow][nextCol])continue;
                if(map[nextRow][nextCol] == 0)continue;

                if(nextCol != nowCol){
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[] {nextRow, nextCol});
                    break;
                }

                visited[nextRow][nextCol] = true;
                queue.add(new int[] {nextRow, nextCol});
            }
        }

        return false;
    }
}
