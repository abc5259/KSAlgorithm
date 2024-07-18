package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_22860 {
    static class Node {
        String name;
        boolean isFolder;
        List<Node> children = new ArrayList<>();

        public Node(String name, boolean isFolder) {
            this.name = name;
            this.isFolder = isFolder;
        }
    }
    static Map<String, int[]> map = new HashMap<>();
    static Node main = new Node("main", true);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Node> nodes = new ArrayList<>();
        nodes.add(main);
        for(int i=0; i<N+M; i++) {
            st = new StringTokenizer(br.readLine());
            String up = st.nextToken();
            String curr = st.nextToken();
            int folder = Integer.parseInt(st.nextToken());
            Node upNode = null;
            Node currNode = null;
            for (Node node : nodes) {
                if(node.name.equals(up)) {
                    upNode = node;
                }
                if(node.name.equals(curr)) {
                    currNode = node;
                }
                if(upNode != null && currNode != null) break;
            }

            if(currNode == null) {
                currNode = new Node(curr, folder == 1);
                nodes.add(currNode);
            }

            if(upNode == null) {
                upNode = new Node(up, true);
                upNode.children.add(currNode);
                nodes.add(upNode);
            }else {
                upNode.children.add(currNode);
            }

        }

        solve("main", main);

        int Q = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<Q; i++) {
            String query = br.readLine();
            answer.append(map.get(query)[0]).append(" ").append(map.get(query)[1]).append("\n");
        }
        System.out.print(answer);
    }
    public static Result solve(String name, Node node) {
        List<Node> fils = new ArrayList<>();
        Set<Node> fileSet = new HashSet<>();

        for (Node next : node.children) {
            if(!next.isFolder) {
                fils.add(next);
                fileSet.add(next);
                continue;
            }

            Result result = solve(name + "/" + next.name, next);
            fils.addAll(result.fils);
            fileSet.addAll(result.fileSet);
        }

        map.put(name, new int[]{fileSet.size(), fils.size()});
        return new Result(fils, fileSet);
    }

    static class Result {
        List<Node> fils = new ArrayList<>();
        Set<Node> fileSet = new HashSet<>();

        public Result(List<Node> fils, Set<Node> fileSet) {
            this.fils = fils;
            this.fileSet = fileSet;
        }
    }
}
