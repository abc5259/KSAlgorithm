package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
    static int[] map;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        map = new int[101];
        cnt = new int[101];

        for (int i = 1; i <= 100; i++) {
            map[i] = i;
        }
        Arrays.fill(cnt, -1);

        while (snake + ladder-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map[u] = v;
        }

        bfs();
        System.out.println(cnt[100]);
    }

    static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        cnt[1] = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = poll + i;

                if (next > 100) {
                    continue;
                }

                next = map[next];

                if (cnt[next] == -1) {
                    queue.offer(next);
                    cnt[next] = cnt[poll] + 1;
                }
            }
        }
    }
}
// G5 뱀과 사다리 게임 BFS 복습
// 20분
// 일단 최단거리를 구하는 거고 좌표가 주어지고 가중치가 모두 1로 동일하기에 BFS 라고 판단했다
// 더해서 map 에 사다리와 뱀의 좌표를 기입해두고 cnt 배열을 통해서 방문 여부와 함께 이동 횟수도 측정했다
// cnt 를 -1로 초기화 하고 처음을 0으로 시작하고 그다음 방문 여부 체크 시 -1 일때만 큐에 넣게 했다
// 그리고 ArrayDeque 에서 offer 와 poll 만쓰기에 Queue 인터페이스로만 사용하고
// 맨처음이 1로 시작해서 bfs 내에서 1로 넣고 또 사다리와 이거에 대한 좌표를 격자형대신 배열로 해서
// 길게 늘여진 1부터 100이라고 생각했다. 그리고 방문여부가 중요했는데
// 방문 했을 경우 와 100이상이면 continue 하고
// 지름길 즉 길이 없는 경우는 그냥 큐에 넣고 cnt 는 +1 하고
// 지름길이 있으면 지름길에 대한 방문여부가 있는지 확인하고 큐에 넣고 해당 길과 지름길로 간 길 두개다 방문여부 체크를 해야된다.