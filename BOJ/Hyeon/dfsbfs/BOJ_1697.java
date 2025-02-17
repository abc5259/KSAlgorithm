package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1697 {
    static int N, K;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new int[100001];

        if (N == K) {
            System.out.println(0);
            return;
        }
        System.out.println(bfs(N));
    }


    static int bfs(int from) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(from);
        visit[from] = 1;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (n == K) {
                return visit[n] - 1;
            }
            int[] arr = new int[]{n - 1, n + 1, n * 2};
            for (int i = 0; i < 3; i++) {
                if (arr[i] >= 0 && arr[i] <= 100000 && visit[arr[i]] == 0) {
                    visit[arr[i]] = visit[n] + 1;
                    queue.offer(arr[i]);
                }
            }
        }
        return 0;
    }
}

// S1 숨바꼭질 BFS
// BFS를 활용하고 n-1 n+1 n*2의 경우의수에서 BFS 탐색하여 최적의 값을 위한 최단거리를 구하는 것이다.
// visit 배열을 통해 방문여부와 거리를 동시에 저장한다 => int 배열 사용
// BFS로 탐색하며 해당 3개의 조건을 배열로 만들어서 비교하고
// 방문 여부를 확인한다음
// 다음값을 추가하고 값을 누적해서 더한다.