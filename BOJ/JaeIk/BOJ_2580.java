package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_2580{
    private static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0,0);
    }

    private static void sudoku(int row, int col){
        if(col==9){
            sudoku(row+1,0);
            return;
        }
        if(row==9){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);

            System.exit(0);
        }

        if(arr[row][col]==0){
            for(int i=1; i<=9; i++){
                if(possibility(row, col, i)){
                    arr[row][col]=i;
                    sudoku(row, col+1);
                }
            }
            //만약 sudoku(row, col+1)의 possibility 검사 결과가 false이면
            //탐색중이던 곳을 0으로 초기화 후 실행중이던 sudoku함수객체를 끝낸다
            //더 이상 탐색이 유망하지 않다고 판단 후 다시 탐색을 시작한다
            arr[row][col]=0;
            return;
        }

        //arr[row][col]=0이 아닐때도 다음칸 탐색해야함
        sudoku(row,col+1);
    }

    private static Boolean possibility(int row, int col, int value){
        //같은 행에 value가 있는지 확인
        for(int i=0; i<9; i++){
            if(arr[row][i]==value)return false;
        }

        //같은 열에 value가 있는지 확인
        for(int i=0; i<9; i++){
            if(arr[i][col]==value)return false;
        }

        //같은 3*3행렬에 value가 있는지 확인
        int set_row = (row/3)*3;
        int set_col = (col/3)*3;

        for(int i=set_row; i<set_row+3; i++){
            for(int j=set_col; j<set_col+3; j++){
                if(arr[i][j]==value)return false;
            }
        }

        return true;
    }
}