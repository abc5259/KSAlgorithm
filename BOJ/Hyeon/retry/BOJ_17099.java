package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
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
        Arrays.sort(meetings, Comparator.comparingInt(m -> m.start));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int maxProfit = 0;
        for (Meeting meet : meetings) {
            // 현재 회의 시작 이전에 끝난 회의들 수익 반영
            while (!pq.isEmpty() && pq.peek()[0] < meet.start) {
                maxProfit = Math.max(maxProfit, pq.poll()[1]);
            }

            pq.offer(new int[]{meet.end, maxProfit + meet.money});
        }

        // 남은 회의들 중 최대 수익 구하기
        while (!pq.isEmpty()) {
            maxProfit = Math.max(maxProfit, pq.poll()[1]);
        }

        System.out.println(maxProfit);
    }

    static class Meeting {
        int start;
        int end;
        int money;

        public Meeting(int start, int end, int money) {
            this.start = start;
            this.end = end;
            this.money = money;
        }
    }
}
