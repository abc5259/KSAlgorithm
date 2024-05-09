package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문1_2 {
    static char[][] map;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++){
            n = Integer.parseInt(br.readLine());

            map = new char[8][8];
            for(int i=0; i<8; i++){
                map[i] = br.readLine().toCharArray();
            }

            int answer = 0;
            for(int i=0; i<8; i++){
                for(int j=0; j<=8-n; j++){
                    if(isPalindromeA(i, j, j+n)){
                        answer++;
                    }

                    if(isPalindromeB(i, j, j+n)){
                        answer++;
                    }
                }
            }

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static boolean isPalindromeA(int row, int startCol, int endCol){
        int sum = 0;

        for(int i=startCol; i<startCol+n/2; i++){
            char a = map[row][i];
            char b = map[row][startCol+endCol-i-1];
            if(a == b){
                sum++;
            }
        }

        return sum == n/2;
    }

    static boolean isPalindromeB(int col, int startRow, int endRow){
        int sum = 0;

        for(int i=startRow; i<startRow+n/2; i++){
            char a = map[i][col];
            char b = map[startRow+endRow-i-1][col];
            if(a == b){
                sum++;
            }
        }

        return sum == n/2;
    }
}
