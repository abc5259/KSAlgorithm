package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
    static int n, m;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        long low = 1, high = (long)1e10 + 7;

        while(low+1 < high){
            long mid = (low+high)/2;

            if(check(mid))low=mid;
            else high=mid;
        }
        System.out.println(low);

    }

    static Boolean check(long mid){
        long cnt = 0;
        for(int i=0; i<n; i++){
            cnt += arr[i]/mid;
        }
        return cnt>=m;
    }
}

