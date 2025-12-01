package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
    static int N, M;
    static int[] res;
    static boolean[] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = new int[M];
        visit = new boolean[N];

        sb = new StringBuilder();

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int idx) {
        if (idx == M) {
            for (int var : res) {
                sb.append(var).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i]) {
                continue;
            }
            res[idx] = i + 1;
            visit[i] = true;
            dfs(idx + 1);
            visit[i] = false;
        }
    }
}
// S1 N과 M(1) 백트래킹 DFS
// 5분
// 순열을 구하는 것이다 중복되는 수열을 구하지말고 중복없이 고른다.
// 그래서 방문 여부를 통해서 내가 이전에 고른 값에 대한 여부를 판단해서 재귀하고
// 다시 기저사례를 만나 탈출한다음 백트래킹으로 그 값의 방문여부를 취소하고 다음 단계로 넘어간다.
// 중복을 막아야 하기 떄문에 visit 를 사용했다.
