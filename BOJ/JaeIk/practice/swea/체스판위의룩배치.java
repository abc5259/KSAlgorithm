package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판위의룩배치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            char[][] map = new char[8][8];
            for(int i=0; i<8; i++){
                map[i] = br.readLine().toCharArray();
            }

            String result = check(map)? "yes": "no";

            System.out.println("#"+(tc+1)+" "+result);
        }
    }

    static boolean check(char[][] map){
        int rowCheck=0;

        for(int i=0; i<8; i++){
            rowCheck = 0;

            for(int j=0; j<8; j++){
                if(map[i][j] == 'O'){
                    rowCheck++;

                    int rowIdx = i+1;
                    int colIdx = j;

                    for(int k=rowIdx; k<8; k++){
                        if(map[k][colIdx] == 'O'){
                            return false;
                        }
                    }
                }
            }

            if(rowCheck!=1){
                return false;
            }
        }

        return true;
    }
}
