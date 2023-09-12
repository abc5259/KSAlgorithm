package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {
    static int[] val;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        val = new int[N];

        for(int i=0; i<N; i++){
            val[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;

        for(int i=N-1; i>=0; i--){
            if(val[i] <= K){
                cnt += K/val[i];
                K = K%val[i];
            }
        }

        System.out.println(cnt);
    }
}
