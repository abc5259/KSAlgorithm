package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n+1];
            sticker[0][0] = sticker[1][0] = 0;

            for (int idx = 0; idx < 2; idx++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++)
                    sticker[idx][j] = Integer.parseInt(st.nextToken());
            }
            
            for (int j = 2; j <= n; j++) {
                sticker[0][j] += Math.max(sticker[1][j - 2], sticker[1][j - 1]);
                sticker[1][j] += Math.max(sticker[0][j - 2], sticker[0][j - 1]);
            }

            System.out.println(Math.max(sticker[0][n], sticker[1][n]));
        }
    }
}
