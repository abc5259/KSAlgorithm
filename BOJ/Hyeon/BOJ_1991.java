package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1991 {
    private final static String Root = "A";
    static Map<String, String[]> nodes;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        nodes = new HashMap<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String node = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            nodes.put(node, new String[]{left, right});
        }

        preorder(Root);
        sb.append("\n");
        inorder(Root);
        sb.append("\n");
        postorder(Root);

        System.out.println(sb);
    }

    static void preorder(String r) {
        if (r.equals(".")) {
            return;
        }
        sb.append(r);
        preorder(nodes.get(r)[0]);
        preorder(nodes.get(r)[1]);
    }

    static void inorder(String r) {
        if (r.equals(".")) {
            return;
        }
        inorder(nodes.get(r)[0]);
        sb.append(r);
        inorder(nodes.get(r)[1]);
    }

    static void postorder(String r) {
        if (r.equals(".")) {
            return;
        }
        postorder(nodes.get(r)[0]);
        postorder(nodes.get(r)[1]);
        sb.append(r);
    }
}
// S1 트리 순회 재귀 Map
// 30분
// 일단 순회 자체가 VLR, LVR, LRV 인데 재귀를 통해서 기저사례 점검한다음 타고 내려가고
// 또 출력을 어디서 하냐가 문제 처음부터 출력하고 재귀타는 pre 나
// 왼쪽을 탐색했는데 없으면 그때돼서 출력하는 in 이나 이런식으로 판단하고
// O(1) 로 접근가능한 Map 자료구조를 통해서 진행