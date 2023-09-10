package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11054 {
    static int n;
    static int[] arr;
    static Integer[] lis;
    static Integer[] lds;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr =  new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis = new Integer[n];
        lds = new Integer[n];

        for(int i=0; i<n; i++){
            LIS(i); LDS(i);
        }

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            max = Math.max(max, lds[i]+lis[i]);
        }

        System.out.println(max-1);
    }

    static int LIS(int n){
        if(lis[n]==null){
            lis[n] = 1;

            for(int i=n-1; i>=0; i--){
                if(arr[n] > arr[i]){
                    lis[n] = Math.max(lis[n], LIS(i)+1);
                }
            }
        }
        return lis[n];
    }

    static int LDS(int n){
        if(lds[n] == null){
            lds[n] = 1;

            for(int i=n+1; i<lds.length; i++){
                if(arr[n] > arr[i]){
                    lds[n] = Math.max(lds[n], LDS(i)+1);
                }
            }
        }
        return lds[n];
    }
}
