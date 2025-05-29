package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[k]);
    }
}

// G4 동전 1 DP
// 바텀 업 방식을 차용해서 했다.
// DP 에는 크게 2가지가 있다.
// 탑 다운 방식을 이용해서 큰 문제부터 시작해서 기저사레까지 간 후 그때 메모이제이션이 되어있으면 재귀를 호출하지 않고
// 기억 된 내용을 반환하고 아니라면 재귀를 반복해서 하위로 내려간다. 피보나치 생각 필요한 값만 계산
//
// 2번째는 바텀업을 이용해서 작은것부터 만들어서 큰것을 쓰기
// 재귀를 하지않고 반복문을 사용해서 이득이고 오히려 불필요하게 전체 범위를 계산하기도 한다. 메모리는 최적화되어있다.
//
// 1원짜리 동전으로 1원부터 10원까지 만들 수 있는 가짓수를 한다.
// 근데 1원부터 10원까지인데 1원의 개수는 내가 만들어내야되는 1원과 가지고 있는 1원을 통해서 1가지 이고
// 2원일때는 1원일때 1개 필요한거에다가 1원만큼 또 필요하니까 1개를 더하면된다 그래서 1개가 되고 이래서
// 1원이면 누적해서 더하게 되는ㄴ데
// dp[k까지의 수] 에서 dp[만들어야되는 돈 - 동전] 해서 만약 6원을 만들어야 하면 5원을 가지고 있을 때
// 6원 - 5원이라 dp[1]만큼을 누적해서 dp[6]에 더해주면된다.왜냐면 dp[6]에 5원을 태우면 1원만큼만 쓰이기 때문이다.