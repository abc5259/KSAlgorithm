package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_5568 {
    static int n, k;
    static int[] arr;
    static boolean[] visit;
    static Set<String> cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        cards = new HashSet<>();

        dfs(0, "");

        System.out.println(cards.size());
    }

    static void dfs(int depth, String Num) {
        if (depth == k) {
            cards.add(Num);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, Num + arr[i]);
                visit[i] = false;
            }
        }
    }
}
// S4 카드 놓기 백트래킹
// 10분
// 순열을 통해서 카드를 선택하고 이 카드에 대한 값이 중복 없이 갯수만 구하기
// 때문에 Set 자료구조를 통해서 사이즈를 구하려 했다
// 개선점
// 정수로 접근을 했었는데 99정수를 4개 선택하고 가로로 하면 1억쯤이니까,, 그런데 그냥
// 정수를 따로 변환안하고 Set 의 제네릭 타입을 String 으로 둬도 가능했다.