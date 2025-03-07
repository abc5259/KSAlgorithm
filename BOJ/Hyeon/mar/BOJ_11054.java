package BOJ.Hyeon.mar;

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
                if (arr[j] < arr[i] && dp_inc[i] <= dp_inc[j]) {
                    dp_inc[i] = dp_inc[j] + 1;
                }
            }
        }

        int[] dp_dec = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            dp_dec[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i] && dp_dec[i] <= dp_dec[j]) {
                    dp_dec[i] = dp_dec[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp_inc[i] + dp_dec[i] - 1);
        }
        System.out.println(max);
    }
}

// G4 가장 긴 바이토닉 부분 수열  DP
// 증가하는 수열과 감소하는 수열이 양쪽으로 있는 바이토닉 부분 수열인데
// 증가하는 DP와 감소하는 DP를 더하니까 값이 일치해지는것을 테스트케이스로 확인하였다
// 일단 DP의 경우 값을 선택하고 그 값간의 관계와 DP 배열에 누적되어있는 값이 더 클경우에만 그를 누적해서 더해서 계산하는
// 메모이제이션을 사용한다.