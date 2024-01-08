package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1135 {
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int N;
    static int[] cntArr;
    static int[] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        cntArr = new int[N];
        depth = new int[N];
        for(int i=0; i<N; i++) {
            tree.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int node = Integer.parseInt(st.nextToken());
            if(node == -1) continue;
            tree.get(node).add(i);
        }

        System.out.println(dfs(0));

    }
    public static int dfs(int node) {
        for(int next: tree.get(node)) {
            depth[next] = 1 + dfs(next);
        }

        Collections.sort(tree.get(node), (a,b) -> depth[b] - depth[a]);
        int res = 0;
        for(int i=0; i<tree.get(node).size(); i++) {
            int next = tree.get(node).get(i);
            depth[next] += i;
            res = Math.max(res, depth[next]);
        }
        return res;
    }
}

//10
//-1 0 0 1 2 2 2 3 7 2