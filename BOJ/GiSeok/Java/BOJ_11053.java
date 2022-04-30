/*
BaekJoon - 11053 가장 긴 증가하는 부분 수열 (05/07 토)

수열 = {10, 20, 10, 30, 50};
dp = {1, 1, 1, 1, 1};

dp의 각 요소가 처음~해당 요소까지의 가장 긴 증가하는 부분 수열의 길이라고 정의합니다.
처음에 dp[1]번째 즉, 수열의 첫 요소는 자기 자신만 부분 수열로 가지므로 dp[1] = 1로 초기화 시켜주고,
나머지 요소들은 아직 가장 긴 증가하는 부분 수열을 판단할 수 없지만 자기 자신만 부분 수열로 가질 수도 있으므로 1로 초기화합니다.

알고리즘은 인덱스를 1부터 하나하나 증가하면서 수열의 i번째 수를 1~(i-n)번째 수랑 비교하면서 i번째 수가 더 크다면,
i번째 가장 긴 증가하는 부분 수열 길이랑 1~(i-n)번째 가장 긴 증가하는 부분 수열 길이 + 1이랑 비교해서 더 큰 값을 dp[i]에 대입.

그러면 위와 같이 수열, dp가 정의되어 있다면
dp[1] = 1
dp[2] = Math.max(dp[1] + 1, dp[2])
dp[3] = 1
dp[4] = max(dp[4], dp[1] + 1)
      = max(dp[4], dp[2] + 1)
    .
    .
    .
순으로 진행하면서 결국 각 dp[i]에는 각각의 가장 긴 증가하는 수열의 길이가 대입됩니다.
*/
package BOJ.GiSeok.Java;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] numArr = new int[N + 1]; // 수열
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0;


        if (N != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++)
                numArr[i] = Integer.parseInt(st.nextToken());
            
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < i; j++) {
                    if (numArr[j] < numArr[i])
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        Arrays.sort(dp);
        System.out.println(dp[N]);
    }
}