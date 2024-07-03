package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double[] arr = new double[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N+1];
        int ans = 0;
        for(int i=1; i<=N; i++) {

            int cnt = 0;

            double min = 2000000000;
            for(int j=i-1; j>=1; j--) {
                double[] p1 = {j, arr[j]};
                double[] p2 = {i, arr[i]};

                double l =  (p2[1] - p1[1]) / (p2[0] - p1[0]);
                if(l < min) {
                    cnt++;
                    min = l;
                }
            }

            double max = -2000000000;
            for(int j=i+1; j<=N; j++) {
                double[] p1 = {i, arr[i]};
                double[] p2 = {j, arr[j]};

                double l =  (p2[1] - p1[1]) / (p2[0] - p1[0]);
                if(l > max) {
                    cnt++;
                    max = l;
                }
            }
            ans = Math.max(ans, cnt);
            answer[i] = cnt;
        }
        System.out.println(ans);
    }
}
