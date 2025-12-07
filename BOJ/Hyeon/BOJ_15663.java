package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15663 {
    static int N, M;
    static int[] arr;
    static int[] res;
    static boolean[] visitIdx;
    static boolean[][] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visitIdx = new boolean[N];
        visit = new boolean[M][10_001];
        res = new int[M];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

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

        Arrays.fill(visit[depth], false);

        for (int i = 0; i < N; i++) {
            if (visitIdx[i]) {
                continue;
            }
            int num = arr[i];

            if (visit[depth][num]) {
                continue;
            }

            visit[depth][num] = true;

            visitIdx[i] = true;
            res[depth] = num;
            dfs(depth + 1);
            visitIdx[i] = false;
        }
    }
}
// S2 N과 M(9) 백트래킹 DFS
// 36분
// 처음에는 그니까 이게 중복이 되면 안돼서 자릿수 에 대한 인덱스 방문 여부를 체크해야 했다
// 그래서 visitIdx 로 인덱스를 체크했더니 더해서
// 179 랑 179는 중복이다 하지만9의 인덱스가 3이랑 4는 각각 다르기에 visit 는 통과가 된다
// 그러면 한개 더 방문 여부 체크가 필요한 데 이는 바로 깊이 즉 자리와 그 값을 체크하면된다
// 최대값이 10000이니까 2차원 배열을 통해서 만약 0,1,2 인덱스로 인한 179 값을 얻고
// 0,1,3 인덱스로 179를 얻었을 때 3번째자리 depth가 2일 때는 둘다 9인데 이제 [2][9] 는 0,1,2일때
// 방문 처리가 돼서 0,1,3 이 안되어야 된다.
// 재귀가 돌아갈때마다 그 해당 depth 를 초기화해서 확인한다.
// 반복문으로 움직일떄를 거르기 위해