package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오목판정2 {
    static int[] dr = {0, 0, 1, -1, -1, 1, 1, -1};
    static int[] dc = {1, -1, 0, 0, -1, -1, 1, -1};
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());
            map = new char[n][n];

            for(int i=0; i<n; i++){
                map[i] = br.readLine().toCharArray();
            }

            String result = process()?"YES":"NO";

            System.out.println("#"+(tc+1)+" "+result);
        }
    }

    static boolean explore(int row, int col){
        for(int i=0; i<8; i++){
            boolean flag=false;

            int nextRow = row + dr[i];
            int nextCol = col + dc[i];

            if(nextRow<0 || nextCol<0 || nextRow>=map.length || nextCol>= map.length || map[nextRow][nextCol]=='.')continue;

            if(map[nextRow][nextCol] == 'o') {
                int sum = 2;
                flag = false;

                while (true) {
                    nextRow += dr[i];
                    nextCol += dc[i];

                    if (nextRow < 0 || nextCol < 0 || nextRow >= map.length || nextCol >= map.length) break;

                    if (map[nextRow][nextCol] == 'o') {
                        sum++;
                    } else break;

                    if(sum == 5){
                        flag = true;
                        break;
                    }
                }
            }

            if(flag)return true;
        }

        return false;
    }

    static boolean process(){
        for(int i=0; i< map.length; i++){
            for(int j=0; j< map.length; j++){
                if(map[i][j] == 'o'){
                    if(explore(i, j))return true;
                }
            }
        }

        return false;
    }
}
