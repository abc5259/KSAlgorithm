package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[N];
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int max = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}

// S2 가장 긴 감소하는 부분 수열 DP
// 문제 파악이 좀 걸렸다 그리고 새롭게 생성되는 dp 배열마다 이전의 값들을 비교해야되기때문에 2개의 반복문을 통해서
// dp[i] 반복문과 dp[0]~ dp[i-1] 까지 반복하는 반복문을 2개를 중첩한다.
// 그리고 최대한 코드를 정리하기 위해 반복문을 여러개 쓰지않고 dp[i] 는 원래 1로 채웠는데
// Arrays.fill 대신 A 배열의 값을 채울때 같이 반복하였고
// max 값또한 같이 썼다.

// 최장 증가 부분 수열 알고리즘 Longest Increasing Subsequence
/*
for (int k = 0; k < n; k++) {
            length[k] = 1;
            for (int i = 0; i < k; i++) {
                if (arr[i] < arr[k]) {
                    length[k] = max(length[k], length[i] + 1);
                }
            }
        }
내 풀이와 일치한다. j번째 인덱스에서부터 i번째 이전까지의 검사와 추가 하지 않았을때의 값의 큰것을 업데이트하는것이다.
 */