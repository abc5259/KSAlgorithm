package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2018 {
    static int N, cnt, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            sum = 0;
            cur(i);
        }
        System.out.println(cnt);
    }

    static void cur(int start) {
        if (sum == N) {
            cnt++;
            return;
        } else if (sum > N) {
            return;
        }
        sum += start;
        cur(start + 1);
    }
}
// S5 수들의 합 5 재귀
// 12분
// 그냥 브루트포스 조건문에 숫자는 항상 이어져서 나오니까 dfs 연상해서
// 기저 조건 2개 걸어가지고 반복 시키게 했는데 답은 어찌 나왔지만 시간복잡도 상에서
// O(N X a) 스택오버플로우, 시간초과 위험
// 근데 N이 되기위한 항의 개수는 루트 2N으로 재귀 깊이가 최대 4500