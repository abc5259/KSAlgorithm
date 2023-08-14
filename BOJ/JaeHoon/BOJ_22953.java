package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22953 {
    static int N,K,C;
    static int[] cookerArr;
    static long MAX = 1000000L * 1000000 + 1;
    static long answer = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cookerArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            cookerArr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(answer);
    }
    public static void dfs(int sum) {
        if(sum == C) {
            System.out.println(Arrays.toString(cookerArr));
            long low = 0;
            long high = MAX;
            while (low + 1 < high) {
                long mid = (low + high) / 2;
                if(check(mid)) {
                    high = mid;
                }else {
                    low = mid;
                }
            }


            answer = Math.min(answer,high);
            return;
        }

        for(int i=0; i<N; i++) {
            if(cookerArr[i] > 1) {
                cookerArr[i] -= 1;
                dfs(sum + 1);
                cookerArr[i] += 1;
            }else {
                dfs(sum + 1);
            }
        }
    }

    private static boolean check(long target) {
        long sum = 0;
        for(int i=0; i<N; i++) {
            long makeCnt = target / cookerArr[i];
            sum += makeCnt;
        }

        return sum >= K;
    }

}
//1 100 5
//2