package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    static int N,C;
    static int home[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new int[N];
        int low = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            home[i] = Integer.parseInt(br.readLine());
            if(i>1){
                low = Math.min(home[i] - home[i-1], low);
            }
        }

        Arrays.sort(home);

        int high = home[N-1] - home[0] + 1;

        while(low+1 < high){
            int mid = (low+high)/2;
            if(check(mid)){
                low = mid;
            }else{
                high = mid;
            }
        }
        System.out.println(low);
    }

    static boolean check(int mid){
        int pos = home[0];
        int cnt = 1;

        for(int i=0; i<N; i++){
            if(home[i]-pos >= mid){
                cnt++;
                pos = home[i];
            }
        }
        return cnt >= C;
    }
}
