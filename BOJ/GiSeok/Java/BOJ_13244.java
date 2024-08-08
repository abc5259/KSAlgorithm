/**
 * 13244 - Tree (영어 문제) [실패|00:50:07]
 * 
 * 트리의 특징
 * 1. E = V - 1
 * 2. 노드들은 하나로 엮여있다.
 * 
 * 하나의 노드에서 모든 노드들에 방문할 수 있어야 하고 동시에 E = V - 1이여야 함.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13244 {
    // 시간제한 2초, 메모리제한 512MB

    // 테스트케이스
    // N 노드 갯수
    // M 엣지 갯수
    // v1 -> v2 ...

    // 트리인지 그래프인지 구분해라
    // 테스트 케이스 1 <= T <= 10
    // 1 <= N <= 1000
    // M <= 10^6

    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    static int T;
    static int N;
    static int M;

    static int circle(int v) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(v);
        visited[v] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int v1 = q.poll();

            for (int v2 : adj.get(v1)) {
                if (visited[v2]) continue;
                visited[v2] = true;
                q.add(v2);
                cnt++;
            }
        }

        return cnt;
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            
            adj = new ArrayList<>();
            for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
            visited = new boolean[N];
            parent = new int[N];

            M = Integer.parseInt(br.readLine());
            int root = -1;
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int v1 = Integer.parseInt(st.nextToken()) - 1;
                int v2 = Integer.parseInt(st.nextToken()) - 1;

                adj.get(v1).add(v2);
                adj.get(v2).add(v1);
                if (root == -1) root = v1;
            }

            if (circle(root) != N || M != N - 1) System.out.println("graph");
            else System.out.println("tree");
        }
    }
}
