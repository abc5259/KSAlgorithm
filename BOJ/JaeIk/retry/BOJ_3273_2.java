package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());

        int start = 0;
        int end = n-1;
        int count = 0;

        while(start<end){
            if(arr[start]+arr[end] < x){
                start++;
            }
            if(arr[start]+arr[end] == x){
                start++;
                end--;
                count++;
            }
            if(arr[start]+arr[end] > x){
                end--;
            }
        }

        System.out.println(count);
    }
}
