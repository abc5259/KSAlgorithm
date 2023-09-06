package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992 {
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        quadTree(0,0,n);

        System.out.println(sb);
    }

    static void quadTree(int row, int col, int size){
        if(check(row, col, size)){
            sb.append(map[row][col]);
            return;
        }

        int newSize = size/2;

        sb.append('(');

        quadTree(row, col, newSize);
        quadTree(row, col+newSize, newSize);
        quadTree(row+newSize, col, newSize);
        quadTree(row+newSize, col+newSize, newSize);

        sb.append(')');
    }

    static boolean check(int row, int col, int size){
        int val = map[row][col];

        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(val != map[i][j])return false;
            }
        }
        return true;
    }

}
