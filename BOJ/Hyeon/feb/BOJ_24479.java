package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_24479 {
    static ArrayList<Integer>[] arrayLists;
    static int[] visit;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 1. 일단 입력부터 받고 생각
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 2. 간선을 받는 인접리스트 생성
        arrayLists = new ArrayList[N + 1];

        // 3. 인접리스트 초기화
        for (int i = 1; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        // 4. 입력을 인접리스트로 만든다.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arrayLists[from].add(to);
            arrayLists[to].add(from);
        }

        // 5. 오름차순으로 인접 정점들을 정렬한다.

        for (int i = 1; i <= N; i++) {
            Collections.sort(arrayLists[i]);
        }
        // 6. 방문 여부 확인 + 순서까지 표기
        visit = new int[N + 1];// 정점 만큼

        // 7. dfs 실행
        dfs(R);

        // 9. visit 배열에 순서를 저장해둬서 이를 출력 순서가 없을 경우 0을 출력
        for (int i = 1; i <= N; i++) {
            sb.append(visit[i]).append("\n");
        }
        System.out.println(sb);
    }

    static int cnt = 1; // 순서탐지 처음은 1로 시작

    static void dfs(int v) {
        // 6. 방문 여부 확인을 위한 visit 배열에 그리고 순서까지 저장
        visit[v] = cnt;

        // 등록되어있는 인접리스트에서 다음에 갈 수 있는 곳을 찾는다
        for (Integer i : arrayLists[v]) {
            // visit가 0이면 다음에 갈 곳으로 정해진것이고
            if (visit[i] == 0) {
                // 순서를 1늘리고
                cnt++;
                // 재귀한다.
                dfs(i);
            }
        }
    }
}

// S2 깊이 우선 탐색 1 알고리즘 수업
// 걍 쉽게 생각하면된다 끝까지 계속해서 재귀해서 탐색하는 dfs이다.
// 방문 여부를 확인하고 다음에 갈 수 있는 곳을 찾아서 재귀하고 다시 돌아오고 이를 반복한다.