package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_19623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        meeting[] meetings = new meeting[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int man = Integer.parseInt(st.nextToken());
            meetings[i] = new meeting(start, end, man);
        }
        Arrays.sort(meetings);

        int[] dp = new int[N];
        dp[0] = meetings[0].man;

        for (int i = 1; i < N; i++) {
            int maxIdx = lowerBound(meetings, i);

            int curMan = meetings[i].man;
            if (maxIdx != -1) {
                curMan += dp[maxIdx];
            }
            dp[i] = Math.max(dp[i - 1], curMan);
        }
        System.out.println(dp[N - 1]);
    }

    private static int lowerBound(meeting[] meetings, int idx) {
        int lo = -1;
        int hi = idx;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (meetings[mid].end <= meetings[idx].start) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    static class meeting implements Comparable<meeting> {
        int start;
        int end;
        int man;

        public meeting(int start, int end, int man) {
            this.start = start;
            this.end = end;
            this.man = man;
        }

        @Override
        public int compareTo(meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}
