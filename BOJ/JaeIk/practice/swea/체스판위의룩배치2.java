package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class 체스판위의룩배치2 {
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            map = new char[8][8];

            for(int i=0; i<8; i++){
                map[i] = br.readLine().toCharArray();
            }

            String answer = process()?"no":"yes";

            int sum = 0;
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    if(map[i][j]=='O')sum++;
                }
            }

            answer = (Objects.equals(answer, "yes") && sum==8)?answer:"no";

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static boolean explore(int row, int col){
        for(int i=0; i<2; i++){
            int nextRow = row;
            int nextCol = col;
            while(true){
                nextRow += dr[i];
                nextCol += dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=8 || nextCol>=8)break;

                if(map[nextRow][nextCol] == 'O'){
                    return true;
                }
            }
        }

        return false;
    }

    static boolean process(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(map[i][j] == 'O'){
                    if(explore(i, j))return true;
                }
            }
        }

        return false;
    }
}
