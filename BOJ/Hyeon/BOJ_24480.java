package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_24480 {
    static ArrayList<Integer>[] adjList;
    static int[] visit;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i], Collections.reverseOrder());
        }
        visit = new int[N + 1];

        dfs(R);
        for (int i = 1; i <= N; i++) {
            sb.append(visit[i]).append("\n");
        }
        System.out.println(sb);
    }

    static int cnt = 1;

    static void dfs(int v) {
        visit[v] = cnt;

        for (Integer i : adjList[v]) {
            if (visit[i] == 0) {
                cnt++;
                dfs(i);
            }
        }
    }
}

// S2 깊이 우선 탐색 2 알고리즘 수업 DFS
// 내림차순 한거랑 DFS의 전반적인 구조만 복습하는 문제로 쉽게 풀었다
// 계쏙해서 인접리스트 ArrayList<Integer>[] a 로
// 어레이 리스트 배열에 인티저 배열을 사용하는 것이다.
// 정점을 1개만 넘겨도 된다면 이방법이 괜찮은거 같다.
// 방문여부는 필수이다.