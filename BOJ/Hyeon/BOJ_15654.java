package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654 {
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
        res = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

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
            res[idx] = arr[i];
            visit[i] = true;

            dfs(idx + 1);

            visit[i] = false;
        }
    }
}
// S3 N과 M(5) DFS 백트래킹
// 25분
// 일단 계속해서 비슷한 분류의 문제를 푸는데 현재 문제는 중복 되지 않은 순열을 구하는 문제였다
// 오름차순 정렬이기에 주어진 arr 배열을 오름차순 해서 dfs 를 돌렸다
// 기저사례를 idx 의 값이 M 일때 ArrayOutOfBounds 전에 탈출시켜서 값을 구하고 다시 백트래킹 하여서
// 다음 반복문의 값으로 덮어쓴다.
// trouble shooting
// if (idx > 0 && res[idx - 1] == arr[i]) {
//                continue;
// 이렇게 하면 이전 값만 처리가 된다.. 띄워졌을 경우 놓치니까 안됨.
// 중복 여부를 판단하기 위한 방문 여부 배열을 둔다.
// 백 트래킹으로 탈출하면 false 로 체크해둔다.