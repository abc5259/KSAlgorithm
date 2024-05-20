package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16918 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int r,c;
    static boolean[][] check;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for(int i=0; i<r; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] == 'O'){
                    check[i][j] = true;
                }
            }
        }

        for(int i=0; i<n/2; i++){

        }
    }

    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] == 'O'){
                    queue.add(new int[] {i, j});
                    check[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            check[now[0]][now[1]] = false;
            map[now[0]][now[1]] = '.';

            for(int i=0; i<4; i++){
                int nextRow = now[0] + dr[i];
                int nextCol = now[1] + dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=r || nextCol>=c)continue;

                map[nextRow][nextCol] = 'O';
            }
        }
    }
}
