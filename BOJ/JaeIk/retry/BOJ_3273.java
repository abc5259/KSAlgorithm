package BOJ.JaeIk.retry;

import java.util.*;
import java.io.*;

public class BOJ_3273 {
    static int N,X, cnt;
    static int arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int l=0; int r=N-1;
        while(l<r){
            int sum = arr[l] + arr[r];
            if(sum == X){
               cnt++; l++; r--;
            }
            else if(sum>X){
                r--;
            }
            else{
                l++;
            }
        }
        System.out.println(cnt);
    }
}
