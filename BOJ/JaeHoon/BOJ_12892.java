package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_12892 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Gift[] gifts = new Gift[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            gifts[i] = new Gift(p, v);
        }

        Arrays.sort(gifts, (a,b) -> a.p - b.p);

        int l = 0;
        int r = 0;
        long sum = gifts[0].v;
        long max = sum;
        while (l <= r) {
            if(gifts[r].p - gifts[l].p >= D) {
                sum -= gifts[l].v;
                l++;
                if(l >= N) break;
            }else {
                r++;
                if(r >= N) break;
                sum += gifts[r].v;
            }

            if(gifts[r].p - gifts[l].p < D) max = Math.max(max, sum);
        }

        System.out.println(max);
    }
    static class Gift {
        int p,v;

        public Gift(int p, int v) {
            this.p = p;
            this.v = v;
        }
    }
}
