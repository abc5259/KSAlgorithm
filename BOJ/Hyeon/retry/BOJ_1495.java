package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] volumes = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> currentSet = new HashSet<>();
        currentSet.add(S);

        for (int i = 0; i < N; i++) {
            int v = volumes[i];
            HashSet<Integer> nextSet = new HashSet<>();

            for (int volume : currentSet) {
                if (volume + v <= M) {
                    nextSet.add(volume + v);
                }
                if (volume - v >= 0) {
                    nextSet.add(volume - v);
                }
            }
            if (nextSet.isEmpty()) {
                System.out.println(-1);
                return;
            }
            currentSet = nextSet;
        }
        int max = 0;
        for (int vol : currentSet) {
            max = Math.max(max, vol);
        }
        System.out.println(max);
    }
}
// S1 기타리스트 DP
// 45분
// 계속 풀어서 매커니즘은 이해했는데 이게 내가 방문여부만 체크하다보니 이게 DP가 맞나 싶어서,,
// 헷갈렸다 사실상 dfs 아닌가 싶기도 하고 근데 N이 50이니까 2^50 은 시간초과이다..
// 계속 트리 형식을 가져가니까 그냥 단순히 내가 이전 dp 의 배열의 값과 현재 값을 비교해서
// 계속해서 배열에 넣어주는거가 DP라고 판단.
// 그냥 이전의 값을 기억해서 비교하고 이를 반복해서 중복되는 숫자 포함해서 set 을 갱신
// 즉 메모이제이션을 쓴다.