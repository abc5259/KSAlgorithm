package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1038_1 {
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N >= 1023) {
            System.out.println(-1);
            return;
        }
        long[][] dp = new long[11][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= 10; i++) {
            for (int j = 1; j < 10; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
            }
        }

        int target = N + 1;

        int len = 0;
        int first = 0;

        boolean find = false;
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (dp[i][j] == 0) {
                    continue;
                }
                if (target <= dp[i][j]) {
                    len = i;
                    first = j;
                    find = true;
                    break;
                } else {
                    target -= dp[i][j];
                }
            }
            if (find) {
                break;
            }
        }

        generateNum(first, 1, len);

        Collections.sort(list);
        System.out.println(list.get(target - 1));
    }

    static void generateNum(long currentNum, int currentLen, int targetLen) {
        if (currentLen == targetLen) {
            list.add(currentNum);
            return;
        }

        long last = currentNum % 10;
        for (int i = 0; i < last; i++) {
            generateNum(currentNum * 10 + i, currentLen + 1, targetLen);
        }
    }
}
// G5 감소하는 수 DP
// 30분
// 내가 손으로 풀었을 때는 점화식이 보이는 느낌이라
// 1자리 2자리 3자리 로 이어질 때 0부터 시작하는 것은 0
// 1부터 시작하는것은 이런식으로 해서 dp[i][j] = dp[i-1][j-1] + dp[i][j-1] 로 2차원 배열을 만들었다
// row 에는 자리수를 col 에는 시작숫자로 해서
// 1개부터 10개자리 까지 가능하고 시작은 0부터 9까지 가능하게 했다.
// 이를 통해 dp 배열을 채우고
// target 은 0이 포함되기에 N+1로 인덱스를 접근하려고 한다. len 은 길이이고 first 는 시작숫자로
// target 이 가지는 값 을 dp 배열보다 클때는 계속해서 target 을 증감해버리고
// 이떄 target 이 dp 보다 작을 때  그때의 i 값이 len 길이이고 j 값이 시작 숫자다
// 그래서 시작 숫자부터 generate 해서 가능한 숫자를 list 에 다 담은 후 이를 정렬해서 target -1 만큼의 인덱스로 접근해서
// 값을 구한다
// 재귀를 할때에는 현재 값에다가 * 10+i를 해서 재귀했고 current 와 target 의 길이를 비교해서 둘이 같을때만 list 를 추가한다
// 즉 N이 18일 때 dp[2][4] 에서 더 작아져서 target 이 3이라서 3번째 숫자. first가 4라서 4로 시작 len 이 2라서 2자리 숫자.
// 40 0번째 41 1번째 42 가 2번째로 당첨이 되었다.