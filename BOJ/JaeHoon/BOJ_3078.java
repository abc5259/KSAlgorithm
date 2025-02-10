package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] names = new String[N];
        int[][] sum = new int[N][21];
        for(int i=0; i<N; i++) {
            names[i] = br.readLine();
            sum[i][names[i].length()] = 1;
        }

        for(int i=1; i<N; i++) {
            for(int j=1; j<=20; j++) {
                sum[i][j] += sum[i-1][j];
            }
        }

        long result = 0;
        for(int i=0; i<N; i++) {
            int min = Math.min(i+K, N-1);
            int add;
            if(i != 0) add = sum[min][names[i].length()] - sum[i-1][names[i].length()] - 1;
            else add= sum[min][names[i].length()] - 1;
            System.out.println("add = " + add);
            if(add > 0) result += add;
        }
        System.out.println(result);
    }
}
