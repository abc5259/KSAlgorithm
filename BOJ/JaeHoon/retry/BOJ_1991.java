package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991 {
    static int N;
    static class Node {
        char l;
        char r;
        char v;

        public Node(char l, char r, char v) {
            this.l = l;
            this.r = r;
            this.v = v;
        }
    }
    static StringBuffer sb = new StringBuffer();
    static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tree = new Node[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char v = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);
            tree[v-'A'] = new Node(l,r,v);
        }

        preorder(tree[0]);
        sb.append('\n');
        inorder(tree[0]);
        sb.append('\n');
        postorder(tree[0]);

        System.out.println(sb);
    }
    public static void preorder(Node node) {
        sb.append(node.v);
        if(node.l != '.') preorder(tree[node.l - 'A']);
        if(node.r != '.') preorder(tree[node.r - 'A']);
    }

    public static void inorder(Node node) {
        if(node.l != '.') inorder(tree[node.l - 'A']);
        sb.append(node.v);
        if(node.r != '.') inorder(tree[node.r - 'A']);
    }

    public static void postorder(Node node) {
        if(node.l != '.') postorder(tree[node.l - 'A']);
        if(node.r != '.') postorder(tree[node.r - 'A']);
        sb.append(node.v);
    }
}
