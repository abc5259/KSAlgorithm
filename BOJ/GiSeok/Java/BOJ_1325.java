/**
 * 1325 - 효율적인 해킹 [실패]
 * 실버1, 그래프이론
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {
    // N개의 컴퓨터로 이루어짐
    // 한 번의 해킹으로 여러 개의 컴퓨터를 해킹할 수 있는 컴퓨터를 해킹
    // A가 B를 신뢰하면 B를 통해 A도 해킹 가능
    // B -> A 그래프로 표현 가능

    // 시간제한 5초
    // N = 10000
    // M = 100000
    // 단순하게 모든 정점에서 모두 dfs,bfs를 통해 갯수를 구하는 작업 
    // 11만 * O(V+E) = 11만 * 10^4 = 11억

    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] count;
    static int ret = 0;
    static int N, M;
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adj[v1].add(v2);
        }

        count = new int[N+1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = true;

            while (!q.isEmpty()) {
                int idx = q.poll();

                for (int next : adj[idx]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                        ret = Math.max(ret, ++count[next]);
                    }
                }
            }
        }

        for (int i = 1; i < count.length; i++)
            if (ret == count[i]) bw.write(i + " ");
        bw.flush();
        bw.close();
    }
}
