package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0;
        int R = 0;
        int sum = arr[0];
        int min = Integer.MAX_VALUE;
        while (L <= R) {
            if(sum >= S) {
                sum-=arr[L];
                min = Math.min(R - L + 1,min);
                L++;
            }
            else {
                R++;
                if(R >= N) break;
                sum+=arr[R];
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}