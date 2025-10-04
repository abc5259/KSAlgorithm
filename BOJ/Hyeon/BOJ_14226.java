package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_14226 {
    static int S;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        visit = new boolean[1001][1001];
        System.out.println(bfs());
    }

    static int bfs() {
        ArrayDeque<Emoji> queue = new ArrayDeque<>();
        queue.offer(new Emoji(1, 0, 0));
        visit[1][0] = true;

        while (!queue.isEmpty()) {
            Emoji poll = queue.poll();

            if (poll.cnt == S) {
                return poll.time;
            }

            int tmp = poll.cnt + poll.copy;
            if (poll.copy > 0 && tmp < 1001 && !visit[tmp][poll.copy]) {
                queue.offer(new Emoji(tmp, poll.time + 1, poll.copy));
                visit[tmp][poll.copy] = true;
            }
            // 붙여넣기 부터?
            queue.offer(new Emoji(poll.cnt, poll.time + 1, poll.cnt));
            // 그담 복사
            tmp = poll.cnt - 1;
            if (poll.cnt > 2 && poll.copy < 1001 && !visit[tmp][poll.copy]) {
                queue.offer(new Emoji(tmp, poll.time + 1, poll.copy));
                visit[tmp][poll.copy] = true;
            }
            // 그담 마이너스
        }
        return 0;
    }

    static class Emoji {
        int cnt;
        int time;
        int copy;

        public Emoji(int cnt, int time, int copy) {
            this.cnt = cnt;
            this.time = time;
            this.copy = copy;
        }
    }
}

// G4 이모티콘 BFS
// 50분
// 다시해보기