package BOJ.Hyeon.retry;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 전체 구역을 2개의 선거구 < = 부분집합 <= select[] 에 선택, 비선택을 true, false 로 기록 <= 두 개의 선거구는 선택된 구역, 비선택된 구역 나눈 개념
// 그래프 이므로 나뉘어진 선거구 내의 구역이 모두 연결 여부
//    <= 각 선거구의 임의의 한 구역부터 출발 모든 구역에 갈 수 있는 지 완탐 (bfs, dfs)
//    <= 완탐을 통해 visit 배열 1개에 갈 수 있는 곳을 모두 기록
//    <= 완탐 이후 visit 배열 확인
// 모두 연결되어 있다면 인구수의 차를 계산, min 처리
// dfs
public class BOJ_17471_1 {
    static int N, min;
    static int[][] matrix; // i, j 정점번호는 아니다.
    static boolean[] select; // 부분집합 처리용도
    static boolean[] visit; // 모든 구역이 연결되어 있는 지 확인 용도

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new int[N + 1][N + 1]; // 어차피 맨 앞이 더미 <= 그 자리에 인구수를 저장
        select = new boolean[N + 1];
        visit = new boolean[N + 1];

        // 인구수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            matrix[i][0] = Integer.parseInt(st.nextToken());
        }

        // 정점별 연결
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 인접한 정점 수
            for (int j = 1; j <= n; j++) {
                int v = Integer.parseInt(st.nextToken());
                matrix[i][j] = v;  // matrix[i][v] = true 와 비교
            }
        }

        // 풒이
        min = Integer.MAX_VALUE;

        subset(1);

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static void subset(int srcIdx) {
        // 기저조건
        if (srcIdx == N + 1) {
            // 부분집합 경우의 수 1개 완성 <= select 배열에 true, false 기록
            check();
            return;
        }

        select[srcIdx] = true;
        subset(srcIdx + 1);
        select[srcIdx] = false;
        subset(srcIdx + 1);
    }

    // v 정점에서 갈 수 있는 다른 정점 방문 visit에 기록
    static void dfs(int v, boolean sel) {
        visit[v] = true;

        for (int i = 1; i <= N; i++) {
            int adj = matrix[v][i];
            if (adj == 0 || visit[adj] || select[adj] != sel) continue;

            dfs(adj, sel);
        }
    }


    // 나뉘어진 2 개 선거구가 유효 ( 적어도 1개 이상, 다 연결 )
    // 유효하다면 두 선거구의 인구수를 계산, 차이의 최소값 처리
    static void check() {
        // visit 배열을 이용해서 연결여부 확인
        Arrays.fill(visit, false);

        // A 선거구 ( select 배열 true 인 구역 )
        // 선거구에 속한 구역 1개를 선택 완탐 진행 => 갈 수 있는 곳에 visit 기록
        int a = -1;
        for (int i = 1; i <= N; i++) {
            if (select[i]) {
                a = i;
                break;
            }
        }

        if (a == -1) return; // A 선거구의 구역이 0

        dfs(a, true);

        // B 선거구 ( select 배열 false 인 구역 )
        // 선거구에 속한 구역 1개를 선택 완탐 진행 => 갈 수 있는 곳에 visit 기록
        int b = -1;
        for (int i = 1; i <= N; i++) {
            if (!select[i]) {
                b = i;
                break;
            }
        }

        if (b == -1) return; // B 선거구의 구역이 0

        dfs(b, false);

        // 두 선거구 모두 연결 확인
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) return; // 어떤 선거구의 구역이 연결 X
        }

        // A, B 선거구의 인구수를 계산, 최소값 갱신
        int sumA = 0;
        int sumB = 0;

        for (int i = 1; i <= N; i++) {
            if (select[i]) sumA += matrix[i][0];
            else sumB += matrix[i][0];
        }

        min = Math.min(min, Math.abs(sumA - sumB));
    }
}
