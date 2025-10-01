package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2644 {
    static ArrayList<Integer>[] adj;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        dis = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }

        bfs(p1);
        System.out.println(dis[p2] - 1);
    }

    static void bfs(int v) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.offer(v);
        dis[v] = 1;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int val : adj[poll]) {
                if (dis[val] == 0) {
                    queue.offer(val);
                    dis[val] = dis[poll] + 1;
                }
            }
        }
    }
}
// S2 촌수 계산 bfs
// 15분
// 일단 방문 여부를 visit 으로 당연시 하게 쓰고 있었는데 이게 플로드필 같이 촌수에 대한 값을 저장해야 했다
// 그래서 나는 visit 을 int 로 바꾸고 거리가 늘어나기에 dis 라고 배열을 만들었다
// 정점의 개수로 만들었고 해당 정점의 값이 0인지 아닌지로 방문여부를 따졌다
// 그리고 p1 로 bfs 를 태워서 dis 라는 방문여부 배열을 오나성 시키고 그다음
// p2 의 값에서 1을 빼서 했다 왜냐면 처음부터 1로 시작했기 때문