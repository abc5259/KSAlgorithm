package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] star = new int[K][2];
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            star[i][0] = x;
            star[i][1] = y;
        }

        int answer = 0;
        for(int[] a: star) {
            for(int[] b: star) {
                int minX = a[0];
                int maxX = a[0] + L;

                int minY = b[1];
                int maxY = b[1] + L;

                int sum = 0;
                for(int[] s: star) {
                    if(s[0] >= minX && s[0] <= maxX && s[1] >= minY && s[1] <= maxY) {
                        sum++;
                    }
                }
                answer = Math.max(answer,sum);
            }
        }
        System.out.println(answer);

    }
}
