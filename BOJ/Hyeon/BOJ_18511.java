package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18511 {
    static int N, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(res);
    }

    static void dfs(int num) {
        if (num > N) {
            return;
        }

        res = Math.max(res, num);

        for (int a : arr) {
            dfs(num * 10 + a);
        }
    }
}
// S5 큰 수 구성하기 DFS
// 20분
// 일단 문제를 착각해서 오래 걸렸다 나는 무조건 K 의 자리수 인줄 알고 depth 라는 매개 변수를 전달해서
// 재귀문으로 사용하고 depth 가 K 가 되면 탈출하는 기저조건을 만들었는데
// 알고보니 그냥 N 보다 작거나 같을 때의 최대값이라 N보다 크면 탈출하면 되었고
// 그래서 기저 사례는 num > K 였고
// 이게 통과가 되면 res 와 대소 비교해서 가장 큰 값을 계속 저장해두고
// 반복문 탐색과 기존 값 * 10 으로 자리수를 늘리면서 dfs 재귀 호출을 한다.