package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오목_판정 {
    static int[][] vector = {{1, -1}, {1, 0}, {1, 1}, {0, 1}};
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            map = new char[n][n];
            for(int i=0; i<n; i++){
                String line = br.readLine();
                map[i] = line.toCharArray();
            }

            boolean flag = false;
            explore : for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] == 'o'){
                        flag = check(i, j, n);

                        if(flag)break explore;
                    }
                }
            }

            String answer = (flag)?"YES":"NO";

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static boolean check(int row, int col, int size){

        for(int v=0; v<4; v++){
            for(int k=1; k<=4; k++){

                int nextRow = row + vector[v][0]*k;
                int nextCol = col + vector[v][1]*k;

                if(nextRow<0 || nextCol<0 || nextRow>=size || nextCol>=size || map[nextRow][nextCol] != 'o')break;

                if(map[nextRow][nextCol] == 'o' && k==4){
                    return true;
                }
            }
        }

        return false;
    }
}
