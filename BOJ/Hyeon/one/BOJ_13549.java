package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_13549 {
    static final int MAX = 100_001;
    static int N, K;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[MAX];
        Arrays.fill(time, -1);

        bfs();
    }

    static void bfs() {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        time[N] = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (poll == K) {
                System.out.println(time[K]);
                return;
            }

            int tmp = poll * 2;
            if (tmp < MAX && time[tmp] == -1) {
                time[tmp] = time[poll];
                queue.offerFirst(tmp);
            }

            tmp = poll - 1;
            if (tmp >= 0 && time[tmp] == -1) {
                time[tmp] = time[poll] + 1;
                queue.offerLast(tmp);
            }

            tmp = poll + 1;
            if (tmp < MAX && time[tmp] == -1) {
                time[tmp] = time[poll] + 1;
                queue.offerLast(tmp);
            }
        }
    }
}

// G5 숨바꼭질 3 BFS
// 접근이 신기했다 visit을 쓰지않고 했음 이유는 -1로 전체 초기화해서