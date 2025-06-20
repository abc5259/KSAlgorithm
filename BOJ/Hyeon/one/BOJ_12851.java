package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {
    static int N, K;
    static int[] time = new int[100001];
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println((N - K) + "\n1");
            return;
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        sb.append(min).append("\n").append(cnt);
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        time[N] = 1;
        queue.offer(N);

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (min < time[poll]) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int res;
                if (i == 0) {
                    res = poll + 1;
                } else if (i == 1) {
                    res = poll - 1;
                } else {
                    res = poll * 2;
                }

                if (res < 0 || res > 100000) {
                    continue;
                }

                if (res == K) {
                    min = time[poll];
                    cnt++;
                }

                if (time[res] == 0 || time[res] == time[poll] + 1) {
                    time[res] = time[poll] + 1;
                    queue.offer(res);
                }
            }
        }
    }
}

// G4 숨바꼭질 2 BFS
// retry 필요