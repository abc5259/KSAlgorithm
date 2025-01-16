package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1911 {
    static int N,L;
    static Pool[] pools;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        pools = new Pool[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pools[i] = new Pool(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(pools, (a,b) -> a.start - b.start);

        int cnt = 0;
        int start = 0;
        for(int i=0; i<N; i++) {

            int dif = pools[i].end - Math.max(pools[i].start, start);
            if(dif <= 0) continue;

            int needCnt = dif / L;
            if(dif % L != 0) needCnt++;

            start = Math.max(pools[i].start, start) + L * needCnt;
            cnt += needCnt;
        }
        System.out.println(cnt);
    }
    static class Pool {
        int start, end;

        public Pool(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
