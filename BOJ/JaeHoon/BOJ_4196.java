package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_4196 {
    static int N,M;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] finished;
    static int[] dx;
    static Stack<Integer> stack;
    static int sccTotal;
    static int id;
    static int[] sccArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            id = 0;
            stack = new Stack<>();
            finished = new boolean[N+1];
            dx = new int[N+1];
            sccTotal = 0;
            sccArr = new int[N+1];
            graph = new ArrayList<>();
            for(int i=0; i<N+1; i++) {
                graph.add(new ArrayList<>());
            }
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph.get(s).add(e);
            }

            for(int i=1; i<=N; i++) {
                if(dx[i] == 0) {
                    scc(i);
                }
            }

            int[] indegree = new int[sccTotal];
            for(int i=1; i<=N; i++) {
                for (int next: graph.get(i)) {
                    if(sccArr[i] != sccArr[next]) {
                        indegree[sccArr[next]]++;
                    }
                }
            }

            int cnt = 0;
            for(int i=0; i<sccTotal; i++) {
                if(indegree[i] == 0) {
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }

    static int scc(int idx) {
        dx[idx] = ++id;
        stack.push(idx);

        int parent = dx[idx];
        for(int next: graph.get(idx)) {
            if(dx[next] == 0) parent = Math.min(parent, scc(next));
            else if(!finished[next]) parent = Math.min(parent, dx[next]);
        }

        if(parent == dx[idx]) {
            while (true) {
                int top = stack.pop();
                sccArr[top] = sccTotal;
                finished[top] = true;
                if(top == idx) break;
            }
            sccTotal++;
        }

        return parent;
    }
}
