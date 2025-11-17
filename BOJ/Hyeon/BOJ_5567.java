package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5567 {
    static int n;
    static ArrayList<Integer>[] adj;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        dis = new int[n + 1];
        Arrays.fill(dis, -1);

        bfs();

        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (dis[i] == -1) {
                continue;
            }
            if (dis[i] <= 2) {
                sum++;
            }
        }

        System.out.println(sum);
    }

    static void bfs() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        dis[1] = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (dis[poll] == 2) {
                continue;
            }

            for (int partner : adj[poll]) {
                if (dis[partner] != -1) {
                    continue;
                }
                queue.offer(partner);
                dis[partner] = dis[poll] + 1;
            }
        }
    }
}
// S2 결혼식 BFS
// 15분
// 일단 문제를 접근할떄 N 명의 사람이 있고 1번 부터 시작해서
// 1번과의 친구 즉 거리가 1이고 1번과의 친구와 친구 면 거리가 2라는 뜻이다
// 가중치가 친구 관계에 따라 1씩 늘어나기때문에 모든 가중치가 같아서 BFS 라고 생각했고
// 방문 여부를 dis 로 거리로 나타냈다
// 또 n은 500 * 500 까지 되는데 여기서 간선의 수는 10000개 뿐이라서 희소 그래프로 인접 리스트를 사용했다
// 시간복잡도 계산은 1초까지여서 간으했다
// trouble shooting
// 내가 총 거리를 반환하였다 사람의 수를 구해야했는데.