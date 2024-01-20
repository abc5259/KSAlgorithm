package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int sum = 0;
        int answer1 = 0;
        int answer2 = 0;
        int start = 0;
        int end = n-1;
        int min = Integer.MAX_VALUE;
        while(start<end){
            sum = arr[start]+arr[end];

            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                answer1 = arr[start];
                answer2 = arr[end];
            }
            if(sum>0){
                end--;
            }else{
                start++;
            }
        }

        System.out.println(answer1+" "+answer2);
    }
}

