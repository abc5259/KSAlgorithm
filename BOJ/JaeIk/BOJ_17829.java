package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17829 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        arr = new int[size][size];
        for(int i=0; i<size; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<size; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = dq(0, 0, size);

        System.out.print(answer);
    }

    static int dq(int row, int col, int size){
        if(size == 2){
            return getSecondMax(row, col, size);
        }

        List<Integer> pooled = new ArrayList<>();

        pooled.add(dq(row, col, size/2));
        pooled.add(dq(row, col+size/2, size/2));
        pooled.add(dq(row+size/2, col, size/2));
        pooled.add(dq(row+size/2, col+size/2, size/2));

        pooled.sort(Collections.reverseOrder());

        return pooled.get(1);
    }

    static int getSecondMax(int row, int col, int size){
        List<Integer> list = new ArrayList<>();

        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                list.add(arr[i][j]);
            }
        }

        list.sort(Collections.reverseOrder());

        return list.get(1);
    }
}
