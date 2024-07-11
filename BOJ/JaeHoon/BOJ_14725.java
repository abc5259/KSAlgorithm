package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14725 {
    static int N;
    static StringBuilder result = new StringBuilder();
    static class Node implements Comparable<Node> {
        String name;
        List<Node> childs = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            return this.name.compareTo(o.name);
        }
    }
    static Node root = new Node("root");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());


        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String[] arr = new String[n];
            for(int j=0; j<n; j++) {
                arr[j] = st.nextToken();
            }

            dfs(root, arr, 0);
        }

        print(root, 0);
        System.out.println(result);
    }
    public static void print(Node node, int depth) {
        StringBuilder d = new StringBuilder();
        for(int i=0; i<depth-1; i++) {
            d.append("--");
        }
        if(!node.name.equals("root")) {
            d.append(node.name).append("\n");
            result.append(d);
        }

        Collections.sort(node.childs);
        for(Node child : node.childs) {
            print(child, depth+1);
        }
    }
    public static void dfs(Node node, String[] names, int depth) {
        if(depth == names.length) return;

        List<Node> childs = node.childs;
        for (Node child : childs) {
            if(child.name.equals(names[depth])) {
                dfs(child, names, depth+1);
                return;
            }
        }
        Node next = new Node(names[depth]);
        node.childs.add(next);
        dfs(next, names, depth+1);

    }
}
