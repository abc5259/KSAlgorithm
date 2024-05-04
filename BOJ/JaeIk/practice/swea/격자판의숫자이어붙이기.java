package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class 격자판의숫자이어붙이기 {
    static boolean[][] visited;
    static HashSet<Integer> set;
    static int[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc =  {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            map = new int[4][4];
            set = new HashSet<>();

            for(int i=0; i<4; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    dfs(String.valueOf(map[i][j]), i, j, 0);
                }
            }

            System.out.println("#"+(tc+1)+" "+set.size());
        }


    }

    static void dfs(String num, int row, int col, int depth){
        if(depth == 6){
            set.add(Integer.valueOf(num));
            return;
        }

        for(int i=0; i<4; i++){
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];

            if(nextRow<0 || nextCol<0 || nextRow>=4 || nextCol>=4)continue;

            dfs(num+map[nextRow][nextCol], nextRow, nextCol, depth+1);
        }
    }
}
