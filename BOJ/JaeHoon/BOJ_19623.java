package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_19623 {
    static int N;
    static int[] dp;
    static class Meeting {
        int start,end, cnt;

        public Meeting(int start, int end, int cnt) {
            this.start = start;
            this.end = end;
            this.cnt = cnt;
        }
    }
    static Meeting[] meetings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        dp = new int[N];
        meetings = new Meeting[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end, cnt);
        }

        Arrays.sort(meetings, (a,b) -> {
            if(a.end == b.end) {
                return a.start - b.start;
            }
            return a.end - b.end;
        });

        dp[0] = meetings[0].cnt;
        for(int i=1; i<N; i++) {
            if(meetings[i-1].end <= meetings[i].start) {
                dp[i] = dp[i-1] + meetings[i].cnt;
            }else {
                int idx = findIdx(i, i - 1);
                if(idx == -1) {
                    dp[i] = Math.max(dp[i-1], meetings[i].cnt);
                }else {
                    dp[i] = Math.max(dp[i-1], dp[idx] + meetings[i].cnt);
                }
            }
        }
        System.out.println(dp[N-1]);
    }

    static int findIdx(int target, int end) {
        int low = -1;
        int high = end;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if(meetings[mid].end <= meetings[target].start) {
                low = mid;
            }else {
                high = mid;
            }
        }

        return low;
    }
}
