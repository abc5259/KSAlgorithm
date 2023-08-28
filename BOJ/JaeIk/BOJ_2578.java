package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578 {
    static int count=0;
    static int map[][] = new int[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (count < 25) {
            for(int i=0; i<5; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<5; j++){
                    //체크되면 -1로 변환
                    if(map[i][j] == Integer.parseInt(st.nextToken()))map[i][j] = -1;
                    if(checkBingo(i, j))break;
                }
            }
            count++;
        }

        System.out.println(count+1);

    }

    static Boolean checkBingo(int x, int y){
        int row=0, cols=0, diag1=0, diag2=0;

        for(int i=0; i<5; i++){
            row += map[i][y];
            cols += map[x][i];
            diag1 += map[i][i];
            diag2 += map[i][5-i-1];
        }

        if(row==-5 || cols==-5 || diag1==-5 || diag2==-5)return true;

        return false;
    }
}
