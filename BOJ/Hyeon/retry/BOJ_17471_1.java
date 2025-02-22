package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17471_1 {
    static int N; // 구역의 개수  1~6까지
    static int[] people; // 인구 분포
    static ArrayList<Integer>[] area; // 이거는 index 별로 각 구역을 나타내고 가장 처음 숫자는 각구역의 크기, 그 이후로는 인접한 구역이다
    static boolean[] select; // 부분집합을 선택했는지에 대한 배열 A와 B 선거구
    static int min; // 최소값 출력

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        people = new int[N + 1];
        area = new ArrayList[N + 1];
        select = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            area[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) { // i는 구역
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken()); // 이거는 인접 구역의 개수

            for (int j = 0; j < cnt; j++) {
                area[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        // 인접한 개수만큼 반복문 돌리고 입력

        min = Integer.MAX_VALUE;
        // 결과값 비교 만약 값이 안들어오면 -1출력 최소값
        // 그다음 부분집합 ? -> 두 선거구에 포함된 == 한 선거구는 포함 다른 선거구는 미포함 == true false로 구분
        subSet(1); //   1번 선거구 부터

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void subSet(int idx) {
        if (idx == N + 1) {
            check();
            return;
        }
        select[idx] = true;
        // 찬성 쪽에 고른 부분집합 == A
        subSet(idx + 1);

        select[idx] = false;
        // 반대 쪽에 고른 부분집합 == B
        subSet(idx + 1);
    }

    static boolean[] visit;

    static void check() {
        visit = new boolean[N + 1];

        int a = -1;
        for (int i = 1; i <= N; i++) {
            if (select[i]) {
                a = i;
                break;
            }
        }

        if (a == -1) return; // A 선거구의 구역이 0

        dfs(a, true);

        int b = -1;
        for (int i = 1; i <= N; i++) {
            if (!select[i]) {
                b = i;
                break;
            }
        }

        if (b == -1) return; // B 선거구의 구역이 0

        dfs(b, false);

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                return;
            }
        }
        // 모든 구역 방문 확인

        // 최소값 갱신
        int sumA = 0;
        int sumB = 0;

        for (int i = 1; i <= N; i++) {
            if (select[i]) {
                sumA += people[i];
            } else {
                sumB += people[i];
            }
        }
        min = Math.min(min, Math.abs(sumA - sumB));
    }

    static void dfs(int v, boolean sel) {
        visit[v] = true;

        for (int node : area[v]) {
            if (visit[node] || select[node] != sel) {
                continue;
            }
            dfs(node, sel);
        }
    }
}

// G3 게리맨더링 DFS
// 방식은 같다.