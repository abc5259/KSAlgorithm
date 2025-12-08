package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15664 {
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

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        sb = new StringBuilder();
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
        int before = -1;

        for (int i = start; i < N; i++) {
            int num = arr[i];
            if (before == num) {
                continue;
            }
            res[depth] = num;
            before = num;
            dfs(depth + 1, i + 1);
        }
    }
}
// S2 N과 M(10) 백트래킹 DFS
// 5분
// 오름차순을 지키고 또 출력되는 숫자가 앞의 수보다 커야되기떄문에 이전 인덱스를 기억해서 진행해야된다
// before 을 통해 arr 의 자리의 인덱스 가 다를떄 값이 같은 경우를 제거한다
// 가지치기 할 떄 마다 before 을 초기화 하고 반복문 돌릴 때 이전값이 arr[i]와 같다면 continue 로 넘긴다.