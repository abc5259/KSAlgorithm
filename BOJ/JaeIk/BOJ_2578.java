package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2578 {
    static int bingoCnt=0;
    static int cnt=0;
    static int map[][] = new int[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int t=0; t<5; t++){
            st = new StringTokenizer(br.readLine());
            for(int y=0; y<5; y++){
                int input = Integer.parseInt(st.nextToken());
                for(int i=0; i<5; i++){
                    for(int j=0; j<5; j++){
                        if(input == map[i][j]){
                            map[i][j]=-1;
                            cnt++;

                            checkRow(); checkCols(); checkLeftDiag(); checkRightDiag();

                            if(bingoCnt>=3){
                                System.out.println(cnt);
                                return;
                            }

                            bingoCnt=0;
                        }
                    }
                }
            }
        }
    }

    static void checkRow(){
        for(int i=0; i<5; i++){
            int sum=0;
            for(int j=0; j<5; j++){
                sum += map[i][j];
                if(sum == -5){
                    bingoCnt++;
                }
            }
        }
    }

    static void checkCols(){
        for(int i=0; i<5; i++){
            int sum=0;
            for(int j=0; j<5; j++){
                sum += map[j][i];
                if(sum == -5){
                    bingoCnt++;
                }
            }
        }
    }

    static void checkLeftDiag(){
        int sum=0;
        for(int i=0; i<5; i++){
            sum += map[i][i];
            if(sum == -5){
               bingoCnt++;
            }
        }
    }

    static void checkRightDiag(){
        int sum=0;
        for(int i=0; i<5; i++){
            sum += map[i][5-i-1];
            if(sum == -5){
                bingoCnt++;
            }
        }
    }
}
