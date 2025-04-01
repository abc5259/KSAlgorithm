package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        if (n == 1) {
            dp[1] = arr[1];
        } else if (n == 2) {
            dp[2] = arr[1] + arr[2];
        } else {
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            for (int i = 3; i <= n; i++) {
                dp[i] = arr[i] + Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]);
            }
        }
        System.out.println(dp[n]);
    }
}
// 먼저 입력값의 배열을 만든다. 왜냐면 최종 출력화는 최댓값이 누적합을 통한 dp 라서
// dp에 값을 누적할 때 재사용할 수 없기 때문에 메모이제이션을 하기 위해 배열을 두고
// 세개 이상 안되기 때문에 1, 2 일 때의 입력값을 조건 분기하여 사용하고,
// 나머지는 반복문 점화식을 통해 해결한다.