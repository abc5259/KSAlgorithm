package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
    static int N, M;
    static int[] res;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = new int[M];
        sb = new StringBuilder();

        dfs(0, 1);
        System.out.println(sb);
    }

    static void dfs(int idx, int start) {
        if (idx == M) {
            for (int var : res) {
                sb.append(var).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            res[idx] = i;
            dfs(idx + 1, i + 1);
        }
    }
}
// S3 N과 M(2) 백트래킹 DFS
// 10분
// 일단 중복을 허용 하지 않고 M개 를 고르는거고 앞에 고른 수보다 커야 된다 이는
// 조합이라고 볼 수 있다
// 그리고 1, 2와 2,1 은 같은 거고 순서를 무시하기 떄문에 오름차순 정렬이라함은
// 앞수보다 더 큰 수가 계속해서 나와야된다.
// 그래서 start 로 현재의 수를기억 하고 이를 시작하는 반복문으로 재귀를 돌린다음
// 백트래킹으로 돌아왔을 때 다음 반복문의 증감으로 얻은 값을 덮어씌운다.