package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_247 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer1=0;
        int answer2=0;
        int gap = Integer.MAX_VALUE;
        int sum=0;
        int temp=0;
        int l = 0; int r = N-1;

        while(l<r){
            sum = arr[l] + arr[r];
            temp = Math.abs(sum);

            if(temp<gap){
                gap = temp;
                answer1 = arr[l];
                answer2 = arr[r];
            }

            if(sum>0){
                r--;
            }else{
                l++;
            }
        }

        System.out.println(answer1+" "+answer2);
    }
}
