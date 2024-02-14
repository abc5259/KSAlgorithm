package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2149 {
    static int row, col;
    static char[][] answer;
    static char[][] arr;
    static String crypt;
    static String key;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        key = br.readLine();
        crypt = br.readLine();

        row = crypt.length()/key.length();
        col = key.length();
        arr = new char[row+1][col];
        answer = new char[row][col];

        for(int i=0; i<col; i++){
            arr[0][i] = key.charAt(i);
        }

        int cryptIdx=0;
        for(int i=1; i<=row; i++){
            for(int j=0; j<col; j++){
                arr[i][j] = crypt.charAt(cryptIdx++);
            }
        }

        //String to Char
        char[] keyArr = key.toCharArray();
        Arrays.sort(keyArr);

        for(int i=0; i<keyArr.length; i++){
            for(int j=0; j<col; j++){
                if(keyArr[i]==arr[0][j]){

                }
            }

        }
    }

    //만약 key에 같은 알파벳이 있으면 정렬 시 왼쪽이 앞으로
    static void rearrange(int j){
        for(int i=0; i<row; i++){
            answer[i][j] = arr[i+1][j];
        }
    }

}
