package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_18222 {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        arr = new long[65];
        arr[0]=1;

        for(int i=1; i<65; i++){
            arr[i] = arr[i-1]*2;
        }

        System.out.println(dq(k));
    }

    static long dq(long k){
        if(k==1)return 0;

        for(int i=0; i<65; i++){
            if(k<=arr[i])return 1 - dq(k - arr[i-1]);
        }

        return 0;
    }

}
