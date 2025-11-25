package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12851 {
    static final int LIMIT = 100_001;
    static int[] dist;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dist = new int[LIMIT];
        cnt = new int[LIMIT];

        Arrays.fill(dist, -1);

        if (N == K) {
            System.out.println(0 + "\n" + 1);
            return;
        }
        bfs(N, K);

        System.out.println(dist[K]);
        System.out.println(cnt[K]);
    }

    static void bfs(int from, int to) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(from);
        dist[from] = 0;
        cnt[from] = 1;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (dist[poll] > dist[to] && dist[to] != -1) {
                continue;
            }

            int[] tmp = {poll * 2, poll + 1, poll - 1};

            for (int i = 0; i < 3; i++) {
                if (0 > tmp[i] || tmp[i] >= LIMIT) {
                    continue;
                }

                if (dist[tmp[i]] == -1) {
                    queue.offer(tmp[i]);
                    dist[tmp[i]] = dist[poll] + 1;
                    cnt[tmp[i]] = cnt[poll];
                } else if (dist[tmp[i]] == dist[poll] + 1) {
                    cnt[tmp[i]] += cnt[poll];
                }
            }
        }
    }
}
// G4 숨바꼭질 2 BFS
// 1시간
// 일단 최단 시간을 구하는것이기에 BFS 라고 생각했다 위치에 있어서 범위 체크를 하고 방문했는지에 여부에 따라
// +1씩 증가해서 dist 방문 여부 및 이동 횟수를 가지는 배열을 쓰면된다 생각
// trouble shooting
// 근데 이게 방법의 개수도 구한다 그 즉슨
// 내가 4번만에 목적지에 갔다== dist[목적지] = 4인건데
// cnt[목적지] 개수 도 필요하다는 것이다 그래서
// 내가 만약 최단 경로로 dist[목적지] = 3 이라하면
// 내가 다른 길로 갔을 때 dist[목적지] 가 3이어야만 cnt[목적지]를 증가 시킬 수 있다
// 그런데 이 증가 하는 방식이 목적지에  진행하는 cnt[poll]을 더한다. 그래서 가짓수를 늘리고
// 큐에는 안넣고 한다
// 사실 이게 방문여부로만 체크를 하면 최초방문이후 같은 가짓수의 방문이더라도 막히는데
// 이를 막으면 안되고 조건을 걸어서 cnt 에 누적시키거나 큐에 넣거나 해야된다고생각한다.