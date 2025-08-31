package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1446 {
    static int N, D;
    static Load[] loads;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        // 차를 타고 D킬로미터 길이의 고속도로를 지남
        // N: 지름길의 개수 1<= N <=12
        // D: 고속도로의 길이 1<= D <=10000
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        loads = new Load[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            loads[i] = new Load(a, b, c);
        }
//        Arrays.sort(loads, (a,b) -> {
//            if(a.start == b.start) {
//                if(a.end == b.end) {
//                    return a.cost - b.cost;
//                }
//                return a.end - b.end;
//            }
//            return a.start - b.start;
//        });

        int[] dp = new int[D+1];
        dp[0] = 0;

        for(int i=1; i<=D; i++) {
            dp[i] = i;
            for(Load load : loads) {
                if(i < load.end) continue;
                dp[i] = Math.min(dp[i], dp[load.start] + load.cost + i - load.end);
            }
        }
        System.out.println(dp[D]);
    }

    public static void dfs(int depth, int currentDist, int cost) {
        if(currentDist == D) {
            min = Math.min(min, cost);
            return;
        }
        if(currentDist > D) {
            return;
        }
        if(depth == N) {
            min = Math.min(min, cost + (D - currentDist));
            return;
        }

        if(currentDist <= loads[depth].start) {
            dfs(depth+1, loads[depth].end, cost + loads[depth].cost + (loads[depth].start - currentDist));
        }
        if(depth + 1 < N) {
            dfs(depth+1, loads[depth+1].start, cost + Math.max(0, loads[depth+1].start - currentDist));
        }else {
            dfs(depth+1, D, cost + D - currentDist);
        }
    }

    static class Load {
        int start, end, cost;

        public Load(final int start, final int end, final int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
