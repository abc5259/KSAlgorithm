package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15665 {
    static int M;
    static List<Integer> arr;
    static int[] res;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = new int[M];
        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        arr = new ArrayList<>(set);

        Collections.sort(arr);

        sb = new StringBuilder();
        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int val : res) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (Integer i : arr) {
            res[depth] = i;
            dfs(depth + 1);
        }
    }
}
// S2 N과 M(11) 백트래킹 DFS
// 14분
// 그냥 중복을 제거해서 해버리면 중복 순열과 똑같다.
// 주어진 arr 의 중복을 제거해서 인덱스를 무시하고 arr 의 원소만큼 반복하고
// depth 만큼 값을 채워넣고 반복한다음 순차적으로 오름차순이 형성된다 미리 정렬을 해둿기 때문에.