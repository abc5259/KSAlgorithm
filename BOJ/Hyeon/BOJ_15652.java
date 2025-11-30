package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        sb = new StringBuilder();

        dfs(1, 0);

        System.out.println(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == M) {
            for (int var : arr) {
                sb.append(var).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
// S3 N과 M(4) DFS 백트래킹
// 18분
// 백트래킹에 대해서 고민
// 중복을 허용하는 순열 문제를 통해서 DFS 를 깊게 가서 방문 여부로 판단하지않고 가지치기로 얻을 수 있는 값을 얻는다
// 이게 백트래킹 왜냐하면 기저 사례에 대해서 탈출 할경우의 값과 다시 dfs 재귀 호출 이전 스택영역의 메소드로 돌아와서
// 진행한다음 이를 이전 값 인덱스에 덮어써진다 왜냐하면 dfs 재귀를 돌릴 시 depth 에 대해서 + 1로 깊게 넣었다가 탈출하게 되면
// depth 에 대해선 값이 변경되지않는데
// 아무 생각없이 depth++ 증감식을 써버려서 depth 의 값이 변경된 채로 dfs 재귀 호출을 하게되어
// 스택 오버 플로우와 ArrayIndexOutOfBounds 가 발생
// 변수의 값을 증가시켰기 때문에 재귀하고 돌아와도 똑같다.