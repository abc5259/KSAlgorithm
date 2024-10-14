package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3584 {
    static class Node {
        Node parent;
        int v;
        public Node(int v) {
            this.v = v;
        }
    }
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            nodes = new Node[N+1];
            for (int i = 0; i <= N; i++) {
                nodes[i] = new Node(i);
            }

            for (int i = 0; i < N-1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nodes[b].parent = nodes[a];
            }

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            List<Node> aParents = getParents(nodes[a], new ArrayList<>(Arrays.asList(nodes[a])));
            List<Node> bParents = getParents(nodes[b], new ArrayList<>(Arrays.asList(nodes[b])));

            if(aParents.size() > bParents.size()) {
                int dif = aParents.size() - bParents.size();
                int aIdx = dif;
                int bIdx = 0;
                for(int i=0; i<bParents.size(); i++) {
                    if(aParents.get(aIdx).v == bParents.get(bIdx).v) {
                        sb.append(aParents.get(aIdx).v).append("\n");
                        break;
                    }
                    aIdx++;
                    bIdx++;
                }
            }
            else if(aParents.size() < bParents.size()) {
                int dif = bParents.size() - aParents.size();
                int aIdx = 0;
                int bIdx = dif;
                for(int i=0; i<aParents.size(); i++) {
                    if(aParents.get(aIdx).v == bParents.get(bIdx).v) {
                        sb.append(aParents.get(aIdx).v).append("\n");
                        break;
                    }
                    aIdx++;
                    bIdx++;
                }
            }
            else {
                for(int i=0; i<aParents.size(); i++) {
                    if(aParents.get(i).v == bParents.get(i).v) {
                        sb.append(aParents.get(i).v).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
    }
    public static List<Node> getParents(Node node, List<Node> nodes) {

        if(node.parent == null) {
            return nodes;
        }
        nodes.add(node.parent);
        return getParents(node.parent, nodes);
    }
}
