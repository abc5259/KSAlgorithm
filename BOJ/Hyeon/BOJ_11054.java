package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp_inc = new int[N];

        for (int i = 0; i < N; i++) {
            dp_inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp_inc[j] >= dp_inc[i]) {
                    dp_inc[i] = dp_inc[j] + 1;
                }
            }
        }

        int[] dp_dec = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            dp_dec[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i] && dp_dec[j] >= dp_dec[i]) {
                    dp_dec[i] = dp_dec[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp_inc[i] + dp_dec[i] - 1);
        }
        System.out.print(max);
    }
}

// G4 가장 긴 바이토닉 부분 수열  DP
// 오름차순으로 증가하는 수열과 내림차순으로 감소하는 수열이 중복되게 만들어진게 바이토닉 수열인데
// 계속해서 앞에서 부터 시작해서 결과가 안나왔다
// trouble
// 그래서 보니까 앞 에서 오름차순 하고 뒤에서도 오름차순을 해야햇다
// 앞에서 오름차 + 앞에서 내림차가 아니라
// 앞에서 오름차 + 뒤에서 오름차 였던것이다.
// 그리고 오르고 내리는건 중복이라 1빼주면 최대값을 구할 수 있었다.

// 특정 원소를 기준으로 왼쪽은 증가 오른쪽은 감소하기에 앞에서 LIS 뒤에서 LIS 했어야 했다.