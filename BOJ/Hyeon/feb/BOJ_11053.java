package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
// 주어진 수열에서 오름차순으로 구성가능한 원소들을 선택하여 최대 길이를 찾는 것
// 제시된 수열에서 dp 메모이제이션을 구성해야한다.
// dp의 배열은 1로 초기화하고 arr 배열에서 이전 인덱스보다 큰 수면 작은 인덱스의 갯수 만큼 횟수의 덧셈이 있고,
// 이때 덧셈은 이전의 수의 +1 하는 값을 dp의 값으로 가진다.
// 이에 대한 최대값을 출력하라.
