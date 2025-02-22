package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17471 {
    static int N; // 구역의 개수  1~6까지
    static int[] people; // 인구 분포
    static ArrayList<Integer>[] area; // 이거는 index 별로 각 구역을 나타내고 가장 처음 숫자는 각구역의 크기, 그 이후로는 인접한 구역이다
    static boolean[] select; // 부분집합을 선택했는지에 대한 배열 A와 B 선거구
    static int min; // 최소값 출력

    public static void main(String[] args) throws IOException {
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

    static void check() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        boolean[] visit = new boolean[N + 1];
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
            int num = queue.poll();
            for (int node : area[num]) {
                if (!visit[node] && select[node]) {
                    visit[node] = true;
                    queue.offer(node);
                }
            }
        }

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
            int num = queue.poll();
            for (int node : area[num]) {
                if (!visit[node] & !select[node]) {
                    queue.offer(node);
                    visit[node] = true;
                }
            }
        }

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
}
// G3 BFS 부분집합 게리맨더링
// 진짜 어려웠다.
// 일단 순서대로 시뮬레이션 화 해보면
// 선거구를 나눠야하는데 2개로 나눠야한다.
// 이는 부분집합을 활용하면 되고
// 2개로 나눠졌을 때
// 이어져있는지를 확인해야한다. 이어져있는지 확인을 하려면 bfs를 해서 어레이리스트가 가지고 있는지를 확인한다.
// 어레이리스트가 가지고 있지않으면 연결이 안된채로 끝난다.
// 그리고 최소값을 구해서 절대값을 통해 리턴한다.