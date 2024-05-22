package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303 {
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[m][n];
        for(int i=0; i<m; i++){
            map[i] = br.readLine().toCharArray();
        }

        int w = 0;
        int b = 0;
        visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && map[i][j] == 'W'){
                    int power = bfs(map, n, m, i, j, 'W');
                    w += power*power;
                }
                else if(!visited[i][j] && map[i][j] == 'B'){
                    int power = bfs(map, n, m, i, j, 'B');
                    b += power*power;
                }
            }
        }

        System.out.println(w+" "+b);

    }

    static int bfs(char[][] map, int n, int m, int row, int col, char c){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { row, col});
        visited[row][col] = true;
        int sum = 0;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowR = now[0];
            int nowC = now[1];

            sum ++;

            for(int i=0; i<4; i++){
                int nextR = nowR + dr[i];
                int nextC = nowC + dc[i];

                if(nextR<0 || nextC<0 || nextR>=m || nextC>=n)continue;
                if(visited[nextR][nextC])continue;

                if(map[nextR][nextC] == c){
                    visited[nextR][nextC] = true;
                    queue.add(new int[] {nextR, nextC});
                }
            }
        }

        return sum;
    }
}
