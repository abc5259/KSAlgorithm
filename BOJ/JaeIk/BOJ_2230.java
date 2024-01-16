package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int start=0;
        int end = 0;
        while(end<n){
           if(arr[end]-arr[start] < m){
               end++;
               continue;
           }
           if(arr[end]-arr[start] == m){
               min = m;
               break;
           }
           if(arr[end]-arr[start] > m){
               min = Math.min(min, arr[end]-arr[start]);
               start++;
           }

        }
        System.out.println(min);

    }
}
