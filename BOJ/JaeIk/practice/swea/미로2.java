package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로2 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++){
            int T = Integer.parseInt(br.readLine());

            int[] start = new int[2];
            map = new int[100][100];
            for(int i=0; i<100; i++){
                String line = br.readLine();

                for(int j=0; j<100; j++){
                    map[i][j] = Character.getNumericValue(line.charAt(j));

                    if(map[i][j] == 2){
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }

            int answer = bfs(start[0], start[1])?1:0;

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static boolean bfs(int row, int col){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[100][100];
        queue.add(new int[] {row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowRow = now[0];
            int nowCol = now[1];

            if(map[nowRow][nowCol] == 3)return true;

            for(int i=0; i<4; i++){
                int nextRow = nowRow + dr[i];
                int nextCol = nowCol + dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=100 || nextCol>=100)continue;
                if(visited[nextRow][nextCol])continue;

                if(map[nextRow][nextCol]!=1){
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[] {nextRow, nextCol});
                }
            }
        }
        return false;
    }
}
