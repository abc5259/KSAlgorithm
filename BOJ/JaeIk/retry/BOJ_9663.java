package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
    static int count = 0;
    static int[] board;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n];

        recur(0);

        System.out.println(count);
    }

    static void recur(int depth){
        if(depth == n){
            count++;
            return;
        }

        for(int i=0; i<n; i++){
            board[depth] = i;
            if(check(depth)){
                recur(depth+1);
            }
        }
    }

    static Boolean check(int col){
        for(int i=0; i<col; i++){
            //col열의 행과 i열의 행이 일치할 경우 F
            if(board[col] == board[i])return false;

            //대각선에 놓여져 있는 경우 F
            //절댓값함수 꼭 사용해야한다
            else if(Math.abs(col-i) == Math.abs(board[col]-board[i]))return false;
        }

        return true;
    }
}
