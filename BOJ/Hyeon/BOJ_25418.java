package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_25418 {
    static int A, K;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cnt = new int[K + 1];
        Arrays.fill(cnt, -1);

        bfs();
    }

    static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(A);
        cnt[A] = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                int poll = queue.poll();
                if (poll == K) {
                    System.out.println(cnt[poll]);
                    return;
                }

                int doublePoll = poll * 2;
                if (doublePoll >= 0 && doublePoll <= K && cnt[doublePoll] == -1) {
                    queue.offer(doublePoll);
                    cnt[doublePoll] = cnt[poll] + 1;
                }
                int plusPoll = poll + 1;
                if (plusPoll >= 0 && plusPoll <= K && cnt[plusPoll] == -1) {
                    queue.offer(plusPoll);
                    cnt[plusPoll] = cnt[poll] + 1;
                }
            }
        }
    }
}
// S3 정수 a를 k로 만들기 BFS
// 22분
// 일단 걍 풀었다 2가지의 경우의수와 같은 가중치로 인해
// 최단 횟수를 구하는 문제.