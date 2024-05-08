package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class nQueen2트 {
    static int count;
    static int n;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());
            count = 0;

            map = new int[n];
            dfs(0);

            System.out.println("#"+(tc+1)+" "+count);
        }
    }

    static void dfs(int row){
        if(row==n){
            count++;
            return;
        }

        for(int col=0; col<n; col++){
            //(row, col)에 룩 배치
            map[row] = col;

            if(possible(row)){
                dfs(row+1);
            }
        }
    }

    static boolean possible(int row){
        //row는 무조건 다르므로, col, diag만 확인해줌

        for(int i=0; i<row; i++){
            //열 확인
            if(map[i] == map[row])return false;

            //대각선 확인
            else if(Math.abs(row-i) == Math.abs(map[row]-map[i]))return false;
        }

        return true;
    }
}
