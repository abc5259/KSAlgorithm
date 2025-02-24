package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
    static int N, M;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];

        perm(0);
        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();

    static void perm(int depth) {
        if (depth == M) {
            for (int p : arr) {
                sb.append(p).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                perm(depth + 1);
                visit[i] = false;
            }
        }
    }
}

// S3 N과 M (1) 백트래킹
// 일단 순열 문제다
// 순열이랑 조합의 차이를 이해하고 백트래킹으로 분석해보자
// 순열은 중복 숫자 상관없이
// 계속해서 출력한다 Permutation 그래서 조합이랑 다르게 방문여부만 확인하고 이전 숫자도 가져오기 때문에
// 반복문으로 사용해보는게 편할 것이다.
