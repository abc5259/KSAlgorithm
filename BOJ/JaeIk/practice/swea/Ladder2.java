package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ladder2 {
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

           //List<Integer>
            int min = Integer.MAX_VALUE;
            int result = 0;
            for(int i=0; i<100; i++){
                if(map[0][i] == 1){
                    int path = bfs(0, i);

                    if(path <= min){
                        min = path;
                        result = i;
                    }
                }
            }

            System.out.println("#"+(tc+1)+" "+result);
        }
    }

    static int bfs(int row, int col){
        int path = 1;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[100][100];
        queue.add(new int[] {row, col});

        while(!queue.isEmpty()){
            path++;

            int[] now = queue.poll();
            int nowRow = now[0];
            int nowCol = now[1];

            if(nowRow == 99)break;

            for(int i=0; i<3; i++){
                int nextRow = nowRow + dr[i];
                int nextCol = nowCol + dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=100 || nextCol>=100)continue;
                if(visited[nextRow][nextCol])continue;
                if(map[nextRow][nextCol] != 1)continue;

                if(nextCol != nowCol){
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[] {nextRow, nextCol});
                    break;
                }

                visited[nextRow][nextCol] = true;
                queue.add(new int[] {nextRow, nextCol});
            }
        }

        return path;
    }
}
