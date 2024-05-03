package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정사각형방 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];

            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            int num = Integer.MAX_VALUE;
            List<int[]> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    int result = bfs(map, n, i, j);

                    if(result >= max){
                        max = result;
                        list.add(new int[] {max, i, j, map[i][j]});
                    }
                }
            }

            for(int i=0; i<list.size(); i++){
                if(list.get(i)[0] == max){
                    num = Math.min(list.get(i)[3], num);
                }
            }

            System.out.println("#"+(tc+1)+" "+num+" "+max);
        }
    }

    static int bfs(int[][] map, int n, int row, int col){
        int path = 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(new int[] {row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int nowRow = now[0];
            int nowCol = now[1];

            for(int i=0; i<4; i++){
                int nextRow = nowRow + dr[i];
                int nextCol = nowCol + dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=n || nextCol>=n)continue;
                if(map[nextRow][nextCol] == map[nowRow][nowCol]+1){
                    path++;
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[] {nextRow, nextCol});
                }
            }
        }

        return path;
    }
}
