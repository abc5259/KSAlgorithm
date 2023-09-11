package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1300 {
   static int N, K;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        int low = 0;
        int high = K;

        while(low+1 < high){
            int mid = (low+high)/2;

            if(check(mid)){
                low = mid;
            }else{
                high = mid;
            }
        }

        System.out.println(high);
    }

    static boolean check(int mid){
        int cnt=0;
        for(int i=1; i<=N; i++){
            cnt += Math.min(N, mid/i);
        }
        return cnt < K;
    }
}
