package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651 {
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

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int depth) {

        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }


        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
}
// S3 N과 M(3) DFS
// 15분
// 중복 순열을 구하는 문제로 DFS 로 골랐던 거를 또 고를 수 있고 만일 기저조건이 통과하면 다음 값을 이전값에 덮어씌워서 다시 기저조건에
// 테스트 시킨다.
// 그냥 DFS 로 풀었고 덮어쓰기가 백트래킹 방식으로 허용이 되어서 그렇게 풀었다..
// 나는 처음에 main 에서 for 반복문을 돌려서 dfs 를 했고
// start 를 넣어줫는데 이는 DFS 반복문에서도 똑같이 중복되기 때문에 DFS 에서 기저조건을 설명하고
// 그후에 배열에 넣어서 덮어쓰기하는 백트래킹을 만들었다