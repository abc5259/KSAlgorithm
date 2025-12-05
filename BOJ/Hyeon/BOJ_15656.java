package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15656 {
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
            for (int var : res) {
                sb.append(var).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            res[depth] = arr[i];
            dfs(depth + 1);
        }
    }
}
// S3 N과 M(7) 백트래킹 DFS
// 6분
// 근데 이게 문제가 각자리에 중복으로 쓸 수는 있는데 중복 수열은 안된대
// 근데 주어진 arr 배열은 숫자가 모두 다른 수라고 했거든 그래서 오름차순으로 만드는게 목표니까
// 애시당초 arr을 오름차순 해버리고 백트래킹 걸면 0부터 N-1 까지 인덱스를 돌리면 계쏙 반복하게 될 거라 생각하고
// 또 arr의 자리수를 기억할 필요가 없어서 그냥 i로 덮어씌우면 되다보니 depth 만 관리하면 되고
// 방문여부도 쓸모없어졌다 그런데 중복 수열이 되려면 어떻게 해야되지? 주어진 조건이 중복수열이 불가능하지않나??