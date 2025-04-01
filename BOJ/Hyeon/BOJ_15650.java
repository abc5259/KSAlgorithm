package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
    static int N, M;
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];

        comb(0, 0);
        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();

    static void comb(int idx, int depth) {
        if (M == depth) {
            for (int i : arr)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                comb(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
}

// S3 N과 M(2) 백트래킹 조합
// 걍 백트래킹 관련해서
// 방문 여부 visit 배열과 조합 메소드 사용
// 일단 값을 출력해야되는데 1 ~ N 까지의 숫자인데 이는 visit 배열의 인덱스로 처리가능하다.
// 만약 0번 인덱스가 t이면 1이 출력되어야하고 N이 4면 3번 인덱스까지 있고 3번인덱스 선택시 4를 출력하면된다.
// depth로 선택을 할 수 있고 idx로 인덱스를 관리하면된다.
// idx가 N보다 크지않게 조건을 걸어서 comb 재귀를 하면된다.