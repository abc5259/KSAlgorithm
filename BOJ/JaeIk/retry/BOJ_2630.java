package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
    static int whiteArea = 0;
    static int blueArea = 0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[size][size];
        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        fold(0, 0, size);

        System.out.println(whiteArea+"\n"+blueArea);
    }

    static void fold(int row, int col, int size){
        boolean flag = true;
        int firstColor = map[row][col];

        check :for(int i=row; i<row+size; i++){
                    for(int j=col; j<col+size; j++){
                        if(map[i][j] != firstColor){
                            flag = false;
                            break check;
                        }
                    }
                }

        if(flag){
            if(firstColor == 1){
                blueArea++;
            }else whiteArea++;
            return;
        }

        fold(row, col, size/2);
        fold(row, col+size/2, size/2);
        fold(row+size/2, col, size/2);
        fold(row+size/2, col+size/2, size/2);
    }
}
