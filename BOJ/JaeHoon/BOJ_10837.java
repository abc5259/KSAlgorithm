package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10837 {
    static int K,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<C; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int aScore = 0, bScore = 0;

            for(int j=1; j<=K; j++) {

                int aRestScore = K - j + 1;
                if(aScore + aRestScore < bScore) break;

                if(aScore < N) aScore++;

                aRestScore -= 1;
                if(aScore + aRestScore < bScore) break;

                int bRestScore = K - j + 1;
                if(bScore + bRestScore < aScore) break;

                if(bScore < M) bScore++;

                bRestScore -= 1;
                if(bScore + bRestScore < aScore) break;
            }

            if(aScore == N && bScore == M) sb.append(1+"\n");
            else sb.append(0+"\n");
        }
        System.out.println(sb);
    }
}
