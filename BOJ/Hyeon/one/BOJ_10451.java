package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10451 {
    static int[] arr;
    static boolean[] visit;
    static int cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            cycle = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visit = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                if (!visit[i]) {
                    dfs(i);
                    cycle++;
                }
            }
            sb.append(cycle).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        visit[start] = true;

        int next = arr[start];
        if (!visit[next]) {
            dfs(arr[start]);
        }
    }
}

// S3 순열 사이클 DFS
// 걍 풀었다 다시