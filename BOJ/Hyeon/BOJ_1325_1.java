package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1325_1 {
    static ArrayList<Integer>[] adj;
    static int[] res;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        res = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[B].add(A);
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            Arrays.fill(visit, false);
            res[i] = dfs(i);
            max = Math.max(max, res[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (max == res[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static int dfs(int idx) {
        visit[idx] = true;

        int cnt = 1;
        for (int next : adj[idx]) {
            if (!visit[next]) {
                cnt += dfs(next);
            }
        }
        return cnt;
    }
}
// S1 효율적인 해킹 DFS 최적화 메모리 관리
// 와 금방 풀었는데 이게 시간초과를 해결하는 과정이 너무 험난했다
// 처음에는 가장 긴 경로르르 구하는 건줄알았는데 알고보니 연결된 노드의 개수였다 즉
// 섬의 개수이다.
// 시간 초과 원인 1
// for 문에서 매번 visit 배열을 재 생성하는거 10000번의 객체 생성과 가비지 컬렉션의 비용이 누적
// Arrays.fill 로 해결

// 시간 초과 원인 2
// 정적 변수로 선언된 정적 배열에 직접 접근
// 재귀 호출 마다 Heap 메모리에 참조 연산 발생
// cnt 라는 지역변수에 누적해서 반환하고 이를 반복문에서 1번만 저장