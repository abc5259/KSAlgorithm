package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2667_2 {
    static boolean[][] visited;
    static List<Integer> result;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        visited = new boolean[n][n];
        result = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && map[i][j]==1){
                    result.add(bfs(map, n, i, j));
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for(int i=0; i<result.size(); i++){
            if(result.get(i)==0)continue;
            System.out.println(result.get(i));
        }
    }

    static int bfs(int[][] map, int n, int row, int col){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        visited[row][col] = true;
        int sum = 1;

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for(int i=0; i<4; i++){
                int nextRow = now[0] + dr[i];
                int nextCol = now[1] + dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=n || nextCol>=n)continue;
                if(visited[nextRow][nextCol])continue;
                if(map[nextRow][nextCol] != 1)continue;

                visited[nextRow][nextCol] = true;
                queue.add(new int[] {nextRow, nextCol});
                sum++;
            }
        }

        return sum;
    }
}
