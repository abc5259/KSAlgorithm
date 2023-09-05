package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580 {
    static int board[][] = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    static void sudoku(int row, int col){
        //row열이 꽉차면 row+1탐색
        if(col == 9){
            sudoku(row+1, 0);
            return;
        }

        //전부 꽉차면 출력하고 리턴
        if(row == 9){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++) {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            //프로그램 바로 끝낼수 있음
            System.exit(0);
        }

        //지금 칸이 0이면 check 수행
        if(board[row][col] == 0){
            for(int i=1; i<=9; i++){
                if(check(row, col, i)){
                    //체크 통과하면 보드에 i 추가
                    board[row][col] = i;
                    sudoku(row, col+1);
                }
            }
            //만약 sudoku함수에서 다음 칸이 유망하지 않아서 반환되면 다시 0으로 초기화
            board[row][col] = 0;
            return;
        }

        //위 조건문에서 체크 통과 못하면 다음 칸 탐색
        sudoku(row, col+1);
    }

    static Boolean check(int row, int col, int val){
        //행 체크
        for(int i=0; i<9; i++){
            if(board[row][i] == val)return false;
        }

        //열 체크
        for(int i=0; i<9; i++){
            if(board[i][col] == val)return false;
        }

        //3*3 체크
        int s_row = (row/3)*3;
        int s_col = (col/3)*3;

        for(int i=s_row; i<s_row+3; i++){
            for(int j=s_col; j<s_col+3; j++){
                if(board[i][j] == val)return false;
            }
        }
        return true;
    }
}
