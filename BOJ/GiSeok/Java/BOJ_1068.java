/**
 * 1068 - 트리 [성공(반례힌트)|01:37:06]
 * 골드5, 트리, 시도5
 * 
 * 트리 이론을 알아도 구현은 어렵다.
 * 
 * dfs에서 tree.get(idx).size() == 0을 기저사례로 두면 안되는 이유 *
 * 현재 구현방식은 실제로 메모리상에 해당 노드를 삭제하지 않고 '없는 척'을 하는 것과 같다.
 * 그렇기 때문에 삭제된 노드를 자식으로 가지고 있는 부모는 노드가 없다고 봐야함에도 불구하고 size()에는 삭제된 노드가 있어
 * size() == 0에 해당하지 못한다. 그래서 리프노드임에도 리프노드의 갯수에 포함되지 않음!!
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1068 {
    // 트리에서 노드 하나를 지웠을 때 남은 트리의 리프노드 갯수를 구하는 문제

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int N, V;
    static int ret;

    static void dfs(int idx) {
        int child = 0;
        
        for (int i = 0; i < tree.get(idx).size(); i++) {
            if (tree.get(idx).get(i) == V) continue;
            dfs(tree.get(idx).get(i));
            child++;
        }

        if (child == 0) { ret++; return; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
            tree.add(new ArrayList<>());

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (v == -1) root = i;
            else tree.get(v).add(i);
        }

        V = Integer.parseInt(br.readLine());

        if (V != root) dfs(root);

        System.out.println(ret);
    }
}
