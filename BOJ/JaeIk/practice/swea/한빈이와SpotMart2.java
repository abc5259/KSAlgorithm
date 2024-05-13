package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한빈이와SpotMart2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] weight = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }

            int max = -1;
            for(int i=0; i<n-1; i++) {
                for(int j=i+1; j<n; j++) {
                    if(weight[i]+weight[j] <= m) {
                        max = Math.max(max, weight[i]+weight[j]);
                    }
                }
            }

            System.out.println("#"+(tc+1)+" "+max);
        }
    }
}
