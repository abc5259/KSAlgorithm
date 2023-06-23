package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        boolean[] dist = new boolean[1001];
        int[] waterDist = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int d = Integer.parseInt(st.nextToken());
            dist[d] = true;
            waterDist[i] = d;
        }
        Arrays.sort(waterDist);
        int cnt = 0;
        for(int i=0; i<N; i++) {
            if(!dist[waterDist[i]]) continue;
            cnt++;
            for(int j=0; j<L; j++) {
                if(waterDist[i]+j > 1000) break;
                dist[waterDist[i]+j] = false;
            }
        }
        System.out.println(cnt);
    }
}