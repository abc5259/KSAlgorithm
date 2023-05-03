package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] S = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        int max = S[0] % 2 == 0 ? 1 : 0;
        int deleteCnt = S[0] % 2 == 0 ? 0 : 1;

        int L = 0;
        int R = 0;
        while (L <= R) {
            if(deleteCnt <= K) {
                R++;
                if(R >= N) break;

                if(S[R] % 2 != 0) deleteCnt++;
                max = Math.max(max, R - L + 1 - deleteCnt);
            }else {
                if(S[L] % 2 != 0) deleteCnt--;
                L++;
            }
        }

        System.out.println(max);
    }
}
