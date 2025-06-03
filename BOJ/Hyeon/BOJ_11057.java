package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11057 {
    static final int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//
//        int[] numbers = new int[10];
//        numbers[0] = 1;
//
//        int[] dp = new int[N + 1];
//
//        for (int i = 1; i <= N; i++) {
//            int sum = numbers[0];
//            for (int j = 1; j < 10; j++) {
//                numbers[j] = (numbers[j - 1] % MOD + numbers[j] % MOD) % MOD;
//                sum = (sum + numbers[j]) % MOD;
//            }
//        }
//        System.out.println(dp[N]);

        int[] dp = new int[10];
        Arrays.fill(dp, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < 10; j++) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }
        System.out.println(dp[9]);
    }
}

// S1 오르막 수 DP
// 일단 점화식을 통해서 풀었다. 한자리의 수를 다 더하면 10이고 2자리의 수는 55 3자리는 220 이었다
// 이는 누적합과 관련이 있었다. 현재의 값 + 이전의 값을 통해서 numbers 배열을 구하고 이 numbers 배열의 모든 수의 합을
// dp 라는 곳에 저장해서 n에 맞는 수를 출력했다

// n번의 반복을 통하고 무조건 10개의 수를 계산해야돼서 N*10의 시간복잡도와 배열의 누적합을 통해서 다음 배열에 대입하고
// 이에 대한 누적합을 구한다.

// 근데 이러면 dp가 필요없어?


// 리팫토링
// dp 를 원래 쓴 이유가 사실 없다 왜냐면 numbers 배열이 누적합으로 메모이제이션? 배열 접근이 되고있는데
// dp는 그냥 값 전달하는 변수 일뿐이니까 그리고 numbers 배열의 끝 값이 전체 총합과도 같았다.