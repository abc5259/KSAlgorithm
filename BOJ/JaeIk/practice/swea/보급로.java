package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 보급로 {
    static int INF = 10000;
    static int[][] time;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] map;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            time = new int[size][size];

            for(int i=0; i<size; i++){
                Arrays.fill(time[i], INF);
            }

            for(int i=0; i<size; i++){
                String line = br.readLine();

                for(int j=0; j<size; j++){
                    map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                }
            }

            int answer = bfs(0, 0);

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static int bfs(int startRow, int startCol){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startRow, startCol});
        time[startRow][startCol] = map[startRow][startCol];

        while(!queue.isEmpty()){

            int[] current = queue.poll();
















































































































































































































































































































































































































































            int currentRow = current[0];
            int currentCol = current[1];

            for(int i=0; i<4; i++){
                int nextRow = currentRow + dr[i];
                int nextCol = currentCol + dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=size || nextCol>=size)continue;
                if(time[nextRow][nextCol] < time[currentRow][currentCol]+map[nextRow][nextCol])continue;
                time[nextRow][nextCol] = time[currentRow][currentCol] + map[nextRow][nextCol];
                queue.add(new int[] {nextRow, nextCol});

            }
        }

        return time[size-1][size-1];
    }
}
