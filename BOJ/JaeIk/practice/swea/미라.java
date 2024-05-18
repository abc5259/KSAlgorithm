package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미라 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++){
            int T = Integer.parseInt(br.readLine());

            char[][] input = new char[16][16];
            for(int i=0; i<16; i++){
                input[i] = br.readLine().toCharArray();
            }

            int[] start = new int[2];
            int[] end = new int[2];
            map = new int[16][16];

            for(int i=0; i<16; i++){
                for(int j=0; j<16; j++){
                    map[i][j] = Character.getNumericValue(input[i][j]);

                    if(map[i][j]==2){
                        start[0]=i; start[1]=j;
                    }
                    if(map[i][j]==3){
                        end[0]=i; end[1]=j;
                    }
                }
            }



            int answer = bfs(start, end)?1:0;

            System.out.println("#"+T+" "+answer);
        }
    }

    static boolean bfs(int[] start, int[] end){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[16][16];
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int row = now[0];
            int col = now[1];

            if(row==end[0] && col==end[1])return true;

            for(int i=0; i<4; i++){
                int nextRow = row+dr[i];
                int nextCol = col+dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=15 || nextCol>=15)continue;
                if(visited[nextRow][nextCol])continue;
                if(map[nextRow][nextCol] == 1)continue;


                visited[nextRow][nextCol] = true;
                queue.add(new int[] {nextRow, nextCol});

            }
        }

        return false;
    }
}
