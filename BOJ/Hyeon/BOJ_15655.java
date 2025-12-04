package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15655 {
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

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        res = new int[M];
        sb = new StringBuilder();

        dfs(0, 0);

        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int var : res) {
                sb.append(var).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            res[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }
}
// S3 N과 M(6) 백트래킹
// 20분
// 문제는 이해를 잘 했어 먼저
// 오름차순 정렬이 되어야 하고 + 조합이어야 돼 중복이 없이 고르는 거니까
// 그래서 나는 백트래킹 이라고 생각했고
// 그런데 중복이 없어야 되니까 visit 를 통해서 해야된다고 생각했어
// 그래서 이전의 인덱스와 또 다음의 인덱스의 방문 여부로 가지치기를 하고
// 그런다음 false 처리 하는거로 이해했는데 이게
// 내가 가진 수보다 더 큰 수가 다음에 나와야되니까 현재 삽입한 i 보다
// 더 큰수를 넣게 하기 위해 반복문의 시작을 i + 1 로 바꿨꺼든
// start 변수를 통해서 방문 여부를 확인할 필요가없음
// 왜냐하면 start  이전값은 쓰이지 않기 떄문