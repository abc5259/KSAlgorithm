package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17099 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end, money);
        }
        Arrays.sort(meetings);

        int[] ends = new int[N];
        for (int i = 0; i < N; i++) {
            ends[i] = meetings[i].end;
        }

        int[] dp = new int[N];
        dp[0] = meetings[0].money;

        for (int i = 1; i < N; i++) {
            int idx = lowerBound(meetings, i);
            int money = meetings[i].money;
            if (idx != -1) {
                money += dp[idx];
            }
            dp[i] = Math.max(dp[i - 1], money);
        }
        System.out.println(dp[N - 1]);
    }

    private static int lowerBound(Meeting[] arr, int idx) {
        int lo = -1;
        int hi = idx;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            int x = arr[idx].start;
            if (arr[mid].end >= x) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;
        int money;

        public Meeting(int start, int end, int money) {
            this.start = start;
            this.end = end;
            this.money = money;
        }

        @Override
        public int compareTo(Meeting o) {
            return this.end - o.end;
        }
    }
}

// G3 Contest DP + 이분탐색
// 시간 초과발생 자바로는 불가능
// C++ 로 변환하니 되네...
// 이분탐색으로 -1을 구분하고 lo를 반환하는거로