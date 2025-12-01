package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10451 {
    static int N, cnt;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            cnt = 0;

            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visit = new boolean[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!visit[i]) {
                    dfs(i);
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        if (visit[start]) {
            return;
        }

        visit[start] = true;
        dfs(arr[start]);
    }
}
// S3 순열 사이클 DFS
// 10분
// 그냥 풀었다. 섬의 개수를 구하는 것과 같은 맥락 그래서 BFS 로도 가능
// 커넥티드 컴포넌트
// 인덱스로 파고들어서 사이클을 발견하면 기저사례를 통해 탈출하게 끔한다.
// 탈출 조건을 걸고 방문여부를 확인하고 dfs 로 재귀해서 들어가는데 이떄 인덱스로 dfs 를 시작해서 재귀시
// 배열의 값으로 dfs 재귀를 들어간다.