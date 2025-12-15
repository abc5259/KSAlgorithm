package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16940 {
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        ans = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bfs() && ans[0] == 1 ? 1 : 0);
    }

    static boolean bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visit[1] = true;
        int idx = 1;

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int cnt = 0;

            for (int next : adj[poll]) {
                if (visit[next]) {
                    continue;
                }
                visit[next] = true;
                cnt++;
            }

            for (int i = idx; i < idx + cnt; i++) {
                if (!visit[ans[i]]) {
                    return false;
                }
                queue.offer(ans[i]);
            }
            idx += cnt;
        }
        return true;
    }
}
// G3 BFS 스페셜 저지 BFS 복습
// 33분
// 일단 BFS 를 전제로 하는 문제여서 쉽게 접근했는데 더해서 각 레벨 별로 순서가 바뀔 수 있는 문제여서
// 주어진 ans 배열과 현재의 bfs 에서 인덱스로 접근하여
// 연결되어 방문 안된 노드를 모두 방문 처리하고갯수를 센다 즉 해당 레벨 별의 노드 갯수를 세고
// idx 라는 값으로 계속해서 인덱스를 저장해서 현재 갯수 만큼 반복해서
// 그게 다 방문 처리가 되어있으면 수를 큐에 넣어서 진행 시키고 인덱스는 그 개수만큼 증가한다
// 만약 1개라도 방문 한적 없는 수가 나올 경우 이는 해당 레벨의 값과 주어진 BFS 의 노드가 다르기에 틀렸다
// trouble shooting
// ans[0]이 1이 아닐 수 있었다.. 이건 어떻게 고민하는 거냐 도대체
// 당연히 1부터 주어진다 생각하지 이 문제에서 시작 정점은 1이다 라고 말했는데.