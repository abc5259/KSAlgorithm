package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
    static long[] arr;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N];

        long high = 0;
        long low = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, arr[i]);
        }

        while(low+1 < high){
            long mid = (low+high)/2;

            if(check(mid)){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        System.out.println(low);

    }

    static boolean check(long m){
        int sum = 0;

        for(int i=0; i<N; i++){
            sum += arr[i]/m;
        }
        return M <= sum;
    }
}
