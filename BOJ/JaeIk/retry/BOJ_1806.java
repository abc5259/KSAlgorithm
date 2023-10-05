package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1806 {
    static int N,S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int min = Integer.MAX_VALUE;
        int l = 0; int r = 0;
        int sum = 0;

        while(l<=N && r<=N){
            if(sum >= S && min>r-l){
                min = r-l;
            }
            if(sum < S)sum += arr[r++];
            else sum -= arr[l++];
        }

        if(min == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);
    }
}
