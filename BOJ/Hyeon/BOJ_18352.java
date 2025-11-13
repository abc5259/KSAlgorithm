package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18352 {
    static ArrayList<Integer>[] adj;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        dis = new int[N + 1];
        Arrays.fill(dis, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[A].add(B);
        }

        bfs(X);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (dis[i] == K) {
                sb.append(i).append("\n");
            }
        }
        int len = sb.length();
        System.out.println(len != 0 ? sb : -1);
    }

    static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        dis[start] = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int next : adj[poll]) {
                if (dis[next] != -1) {
                    continue;
                }
                queue.offer(next);
                dis[next] = dis[poll] + 1;
            }
        }
    }
}
// S2 특정 거리의 도시 찾기 BFS
// 25분
// 일단 입력값이 굉장히 컸다 그리고 단방향 그래프 였고 가중치는 모두 1로 통일 되어있엇다
// 그래서 BFS 라고 생각해서 풀었고
// 간선이 희소 하기 때문에 adj 인접 리스트를 사용했다
// 그래서 배열을 초기화하고 어레이 리스트를 만들어둔다음 간선을 연결하고
// X 에서 시작하기에 BFS 돌린다음에 dis 라고 거리에 대한 배열을 만들어서
// 이는 X 에서만 따지면 되기때문에 1차원 배열로 사용하였고 -1 로 초기화 하여 방문여부를 판단하면서
// 동시에거리 까지 쟀다 dis 에 대해서는 플러드필처럼 +1 로 퍼져나가게 하였고
// 문제 조건인 오름차순 또한 그냥 dis 배열의 인덱스를 뽑기에 그냥 반복문으로 처리했다