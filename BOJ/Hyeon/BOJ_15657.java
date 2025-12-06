package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657 {
    static int N, M;
    static int[] arr;
    static int[] res;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        res = new int[M];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int val : res) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            res[depth] = arr[i];
            dfs(depth + 1, i);
        }
    }
}
// S3 N과 M(8) 백트래킹 DFS
// 16분
// 쉽게 풀었다
// 문제 자체는 일단 계속되는 같은 패러다임인데 N은 다 다른 자연수라서 중복 수열은 아니라 생각했고
// M개를 고른 순열인데 여기서 같은 수를 여러번 골라도 되지만 오름차순 정렬이 필요하다 해서
// 이러면 중복으로 숫자는 선택 가능한데 오름차를 지키는 조합도 아니고 순열도 아닌거 같았다 중복조합이다.
// 이전 값의 시작하는 인덱스를 기억해야되기때문에 파라미터로 start 를 쓰고 depth 까지 2개의 인자를 관리한다.
// start 를 i 로 넘겨줌으로 써 i 보다 작은 수는 보지 않고, i 와 같은수까지 중복 허용한다
