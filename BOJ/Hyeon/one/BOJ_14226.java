package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_14226 {
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        visit = new boolean[1001][1001];
        bfs(S);
    }

    static void bfs(int s) {
        Queue<Emoji> queue = new ArrayDeque<>();
        visit[0][1] = true;
        queue.offer(new Emoji(0, 1, 0));

        while (!queue.isEmpty()) {
            Emoji poll = queue.poll();

            if (poll.total == s) {
                System.out.println(poll.time);
                return;
            }

            queue.offer(new Emoji(poll.total, poll.total, poll.time + 1));

            if (poll.copy != 0 && poll.total + poll.copy <= s && !visit[poll.copy][poll.total + poll.copy]) {
                visit[poll.copy][poll.total + poll.copy] = true;
                queue.offer(new Emoji(poll.copy, poll.total + poll.copy, poll.time + 1));
            }

            if (poll.total >= 1 && !visit[poll.copy][poll.total - 1]) {
                visit[poll.copy][poll.total - 1] = true;
                queue.offer(new Emoji(poll.copy, poll.total - 1, poll.time + 1));
            }
        }
    }

    static class Emoji {
        final int copy;
        final int total;
        final int time;

        public Emoji(int copy, int total, int time) {
            this.copy = copy;
            this.total = total;
            this.time = time;
        }
    }
}

// G4 이모티콘 BFS
// 다시해보기