package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15666 {
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
            before = num;
            res[depth] = num;
            dfs(depth + 1, i);
        }
    }
}
// S2 N과 M(12) 백트래킹 DFS
// 15분
// 조합을 구하는건데 인덱스 중복이 된다.
// 그래서 입력이 중복이 있기 때문에 before 을 두고 점검한다.
// 오름차순이기 때문에 반복문의 시작을 start 에서 하게 하고 같은 인덱스가 나와도 되기에
// i + 1 이 아닌 i 를 넘긴다.