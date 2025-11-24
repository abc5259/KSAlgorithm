package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BOJ_18112 {
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int from = Integer.parseInt(br.readLine(), 2);
        int to = Integer.parseInt(br.readLine(), 2);

        dist = new int[2048];
        Arrays.fill(dist, -1);

        bfs(from, to);
    }

    static void bfs(int from, int to) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(from);
        dist[from] = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (poll == to) {
                System.out.println(dist[poll]);
                return;
            }

            int tmp = poll;
            int msb = 0;
            while (tmp != 1) {
                tmp /= 2;
                msb++;
            }

            for (int i = 0; i < msb; i++) {
                int next = poll ^ (1 << i);

                if (next < 2048 && dist[next] == -1) {
                    queue.offer(next);
                    dist[next] = dist[poll] + 1;
                }
            }

            if (poll + 1 < 2048 && dist[poll + 1] == -1) {
                queue.offer(poll + 1);
                dist[poll + 1] = dist[poll] + 1;
            }
            if (0 < poll - 1 && dist[poll - 1] == -1) {
                queue.offer(poll - 1);
                dist[poll - 1] = dist[poll] + 1;
            }
        }
    }
}
// G5 이진수 게임 BFS, 비트마스킹
// 1시간
// 일단 비트마스킹이라는 것을 알고 있었는데 그냥 문자열과 정수로 변환하면서 쓸 수 있을 줄 알고
// Integer.parseInt 와 Integer.toBinaryString 으로 시도했다가 틀렸었다.
// trouble shooting
// number formatting 문제가 있었다
// 일단 최단 거리 즉 최소 횟수를 구하기에 BFS가 적합하다고 생각 더해서 가중치도 모두 동일하게 1이었다
// 또 큐에 넣을 때 이미 방문한 숫자를 기준으로 하기에 중복방문 도 없다 생각했다
// 그런데 나는 문자열 단위로 했고 Map 을 통해서 거리를 재려고 했다 왜냐하면
// 1024까지 숫자가 가능한데 그 사이에 안쓰는 공간이 많다고 생각해서 특정 값만 사용하는 Map 과 그 밸류를 거리라고 생각했었다.
// msb 를 구해서 내가 맨 앞자리 빼고 다 보수 처리 해봐야 되니까 이를 비트마스킹 XOR 연산으로 해결하였고
// + 와 - 는 각각 조건문으로 동작 시켰다.