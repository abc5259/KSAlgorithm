package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4803 {
    static boolean[] isVisit;
    static ArrayList<ArrayList<Integer>> graph;
    static int vertexCnt,edgeCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;

            cnt++;
            graph = new ArrayList<>();
            isVisit = new boolean[N+1];
            for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }

            int treeCnt = 0;
            for(int i=1; i<=N; i++) {
                if(isVisit[i]) continue;
                vertexCnt = 0;
                edgeCnt = 0;
                dfs(i);
                if (edgeCnt == (vertexCnt - 1) * 2) treeCnt++;
            }

//            System.out.println();
            sb.append("Case " + cnt + ": ");
            if(treeCnt == 0) sb.append("No trees.");
            if(treeCnt == 1) sb.append("There is one tree.");
            if(treeCnt > 1) sb.append("A forest of " + treeCnt + " trees.");
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int x) {
        vertexCnt++; // 정점 갯수 카운트!
        edgeCnt += graph.get(x).size(); // graph[x].size == 해당 정점에 연결 된 간선의 수
        isVisit[x] = true; // 방문처리!
        for (int y : graph.get(x)) {
            if (isVisit[y]) continue; // 방문여부 확인!
            dfs(y);
        }
    }
}
