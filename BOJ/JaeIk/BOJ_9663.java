package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_9663{
    private static int arr[];
    private static int count=0;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        nQueen(0);

        System.out.println(count);
    }

    private static void nQueen(int depth){
        if(depth == n){
            count++;
            return;
        }

        for(int i=0; i<n; i++){
            arr[depth] = i;
            if(Possibility(depth)){
                nQueen(depth+1);
            }
        }
    }

    private static Boolean Possibility(int col){
        for(int i=0; i<col; i++){
            if(arr[col]==arr[i])return false;
            else if(Math.abs(col-i)==Math.abs(arr[col] - arr[i]))return false;
        }

        return true;
    }
}