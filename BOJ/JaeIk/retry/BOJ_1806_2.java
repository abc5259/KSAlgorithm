package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1806_2 {
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //Arrays.sort(arr);

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;


        while(start<=end && end<=n){
            if(sum>=s && min>end-start){
                min = end-start;
            }

            if(sum<s){
                sum += arr[end++];
            }else{
                sum -= arr[start++];
            }
        }

        min = (min==Integer.MAX_VALUE) ? 0 : min;

        System.out.println(min);
    }
}
