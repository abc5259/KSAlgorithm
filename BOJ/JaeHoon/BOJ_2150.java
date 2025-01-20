package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2150 {
    static int V;
    static int E;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] finished;
    static int[] d;
    static Stack<Integer> stack = new Stack<>();
    static List<List<Integer>> SCC = new ArrayList<>();
    static int id;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());
        finished = new boolean[V+1];
        d = new int[V+1];
        for(int i=1; i<=E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
        }

        for(int i=1; i<=V; i++) {
            if(d[i] == 0) {
                scc(i);
            }
        }

        SCC.sort((a,b) -> {
            return a.get(0) - b.get(0);
        });

        StringBuilder sb = new StringBuilder();
        for(List<Integer> list : SCC) {
            for(Integer i : list) {
                sb.append(i).append(" ");
            }
            sb.append("-1\n");
        }
        System.out.println(SCC.size());
        System.out.print(sb);
    }

    static int scc(int idx) {
        d[idx] = ++id;
        stack.push(idx);

        int parent = d[idx];
        for(int next: graph.get(idx)) {
            if(d[next] == 0) parent = Math.min(parent, scc(next));
            else if(!finished[next]) parent = Math.min(parent, d[next]);
        }

        if(parent == d[idx]) {
            List<Integer> g = new ArrayList<>();
            while (true) {
                int top = stack.pop();
                finished[top] = true;
                g.add(top);
                if(top == idx) break;
            }
            g.sort((a,b) -> a - b);
            SCC.add(g);
        }

        return parent;
    }
}
