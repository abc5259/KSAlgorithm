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
            int maxIdx = binarySearch(meetings, i);
            int curMan = meetings[i].man;

            if (maxIdx != -1) {
                curMan += dp[maxIdx];
            }
            dp[i] = Math.max(dp[i - 1], curMan);
        }
        System.out.println(dp[N - 1]);
    }

    private static int binarySearch(meeting[] meetings, int idx) {
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
//            if (this.end == o.end) {
//                return this.start - o.start;
//            }
            return this.end - o.end;
        }
    }
}

// G3 회의실 배정 4 이분탐색 + DP
// 진짜 어렵게 체화했다 DP의 개념을 복습할 수 있게 되었고 시간복잡도 계산을 고려했다
// 1. 이전 회의시간을 비교할 때 DP의 메모이제이션을 통해 누적한 man 이 인덱스에 따라 커지는데
// 주어진 회의 시작시간보다 작거나 같은 회의 종료시간의 DP만을 반환해야 한다는 것을  생각하고
// meeting 으로 클래스를 만들어서 배열로 관리 compare로 정렬
// binary 숙지 필요