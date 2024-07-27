/**
 * 9934 - 완전 이진 트리 [성공|00:58:21]
 * 실버1, 재귀|트리, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_9934 {
    // 시간제한 1초 메모리제한 128MB
    // 깊이가 K인 완전 이진 트리 (2^k - 1)개의 노드
    // 중위순회
    // 각 레벨의 빌딩 번호를 구하는 프로그램

    static int k;
    static int[] building;
    static ArrayList<ArrayList<Integer>> ret;

    static void dfs(int start, int end, int level) {
        if (start > end) return;

        int mid = (start + end) / 2;
        if (start == end) {
            ret.get(level).add(building[mid]);
            return;
        }
        
        dfs(start, mid - 1, level + 1); // 왼쪽
        ret.get(level).add(building[mid]);
        dfs(mid + 1, end, level + 1); // 오른쪽
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        int node = (int)Math.pow(2, k) - 1;
        ret = new ArrayList<>();
        for (int i = 0; i < k; i++)
            ret.add(new ArrayList<>());

        building = new int[node];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < node; i++)
            building[i] = Integer.parseInt(st.nextToken());
        
        dfs(0, node-1, 0);

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < ret.get(i).size(); j++) {
                System.out.print(ret.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
