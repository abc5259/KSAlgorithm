package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15665_1 {
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
            int num = arr[i];
            if (before == num) {
                continue;
            }
            res[depth] = num;
            before = num;
            dfs(depth + 1);
        }
    }
}
// S2 N과 M(11) 백트래킹 DFS
// 8분
// 방문 여부가 아닌 이전 값을 저장해두는 방식
// 4 2
// 1 7 9 9 입력일 때
// 1 1 / 1 7 / 1 9 / 이후에는 현재 before 에는 9가 들어있는데 새로나온 num도 9이기에 continue 된다
// 그러면 반복문이 돌아가고 현재 i는 1로 num 이 7이고 before 는 1이라서 넘어가서 맨 첫자리에
// 7이 나오고 그대로 7 1/ 7 7 / 7 9 가 된다 그다음 같은 방식으로 9 9 까지 했다면
// 다시 before 에는 9가 있는데 i가 3일때의 9가 만나서 그냥 나가진다.