package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];
        int[] count = new int[1000010];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            count[Integer.parseInt(st.nextToken())]++;
            count[Integer.parseInt(st.nextToken())]--;
        }

        for(int i=1; i<count.length; i++) {
            count[i] += count[i-1];
        }

        int l = 0;
        int r = 0;
        int[] answer = new int[2];

        int sum = 0;
        while (l <= r) {
            if(r > 1000000) break;

            if(sum == K) {
                answer[0] = l;
                answer[1] = r;
                break;
            }
            else if(sum < K) {
                sum += count[r++];
            }
            else {
                sum -= count[l++];
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
