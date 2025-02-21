package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17471 {
    static int N;
    static ArrayList<Integer>[] area;
    static boolean[] select; // 부분집합
    static boolean[] visit; // 방문 여부
    static int[] people; // 인구수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        area = new ArrayList[N + 1];
        select = new boolean[N + 1];
        visit = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        people = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            area[i] = new ArrayList<>();
            for (int j = 0; j < cnt; j++) {
                area[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        min = Integer.MAX_VALUE;
        subSet(1);

        System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
    }

    static int min;

    static void subSet(int idx) {
        // 기저 조건
        if (idx == N + 1) {
            // 부분집합 완성 < select true , false 기록
            check();
            return;
        }

        select[idx] = true;
        subSet(idx + 1);

        select[idx] = false;
        subSet(idx + 1);
    }

    // 나뉘어진 두 개의 선거구 ( 다 연결되었는지?)
    // 두 선거구의 인구수를 계산 최소값 처리
    static void check() {
        //visit 배열을 통해서 연결 여부 확인
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.fill(visit, false);
        // A 선거구
        //select 의 true
        // 선거구에 속한 구역 1개를 선택 완탐
        for (int i = 1; i <= N; i++) {
            if (select[i]) {
                visit[i] = true;
                queue.offer(i);
                break;
            }
        }
        if (queue.isEmpty()) {
            return;
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int i = 0; i < area[v].size(); i++) {
                int adj = area[v].get(i);
                if (visit[adj] || !select[adj]) {
                    continue;
                }
                visit[adj] = true;
                queue.offer(adj);
            }
        }
        // B 선거구
        //select 의 false
        // 선거구에 속한 구역 1개를 선택 완탐
        for (int i = 1; i <= N; i++) {
            if (!select[i]) {
                visit[i] = true;
                queue.offer(i);
                break;
            }
        }
        if (queue.isEmpty()) {
            return;
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int i = 0; i < area[v].size(); i++) {
                int adj = area[v].get(i);
                if (visit[adj] || select[adj]) {
                    continue;
                }
                visit[adj] = true;
                queue.offer(adj);
            }
        }

        // 두선거구 연결 확인
        for (int i = 1; i <= N; i++) {
            if (!visit[i])
                return;
        }
        // A B 선거구의 인구수를 계산, 최소값 갱신
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
}

// 가능한 선거구로 나누고 < 부분집합, 두 개의 선거구 선택과 비선택으로 나눈다.
// 임의의 한 구역부터 출발 모든 구역에 갈 수 있는지 dfs bfs
// 완탐을 통해 visit 배열 1개 기록
// 탐색 이후 visit 배열 확인

// 그때의 인구마다 비교해서 작은 값을 구하자