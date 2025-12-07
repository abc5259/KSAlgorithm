package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15663_1 {
    static int N, M;
    static int[] arr;
    static int[] res;
    static boolean[] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visit = new boolean[N];
        res = new int[M];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int val : res) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;

        for (int i = 0; i < N; i++) {
            if (visit[i]) {
                continue;
            }

            if (before == arr[i]) {
                continue;
            }

            before = arr[i];

            visit[i] = true;
            res[depth] = arr[i];
            dfs(depth + 1);
            visit[i] = false;
        }
    }
}
// S2 N과 M(9) 백트래킹 DFS
// 40분
// before 라는 이전 값을 기억해서 만약 0,1,2 인덱스에서 179를 꼽았을 때
// 0,1,3인덱스에서도 똑같은 수 즉 179를 꼽지 않기 위해 before 에 마지막 수를 저장해서 비교한다
// 혼자서 해결 못했다.
