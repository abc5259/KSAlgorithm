/**
 * 12851 - 숨바꼭질 2 [성공|00:23:44]
 * 골드4, BFS, 시도1
 * 
 * 가중치가 같은 그래프
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_12851 {
    // 시간제한 2초
    // 수빈이 점 N (0 <= N <= 100,000)
    // 동생 점 K (0 <= K <= 100,000)
    // 수빈이는 걷거나 순간이동 가능
    // 걷기 -> 1초에 N-1, N+1
    // 순간이동 -> 1초에 2*N

    static int N, K;
    static int[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int ret = 0;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited = new int[100001];
        q.add(N);
        visited[N] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == K) { ret++; continue; }

            for (int next : new int[]{now-1, now+1, 2*now}) {
                if (next < 0 || next > 100000) continue;
                if (visited[next] != 0 && visited[next] < visited[now] + 1) continue;

                visited[next] = visited[now] + 1;
                q.add(next);
            }
        }

        System.out.println(visited[K] - 1);
        System.out.println(ret);
    }
}
