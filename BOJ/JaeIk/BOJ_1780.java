package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {
    static int mone=0;
    static int one=0;
    static int zero=0;
    static StringTokenizer st;
    static int n;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paper(0,0,n);

        System.out.println(mone);
        System.out.println(zero);
        System.out.println(one);

    }

    static void paper(int row, int col, int size){
        if(check(row, col, size)){
            if(map[row][col] == -1)mone++;
            else if(map[row][col] == 1)one++;
            else if(map[row][col] == 0)zero++;

            //return 너무 당연하게도 필수!!!!!!!!!!
            return;
        }

        int newSize = size/3;

        paper(row, col, newSize); paper(row, col+newSize, newSize); paper(row, col+newSize*2, newSize);

        paper(row+newSize, col, newSize); paper(row+newSize, col+newSize, newSize); paper(row+newSize, col+newSize*2, newSize);

        paper(row+newSize*2, col, newSize); paper(row+newSize*2, col+newSize, newSize); paper(row+newSize*2, col+newSize*2, newSize);
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
