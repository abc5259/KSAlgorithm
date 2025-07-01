package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int[][] dp = new int[str1.length + 1][str2.length + 1];

        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int res = dp[str1.length][str2.length];
        sb.append(res).append("\n");

        int len1 = str1.length;
        int len2 = str2.length;

        // 역추적
        Deque<Character> stack = new ArrayDeque<>();

        while (res > 0) {
            if (dp[len1][len2] == dp[len1 - 1][len2]) {
                len1--;
            } else if (dp[len1][len2] == dp[len1][len2 - 1]) {
                len2--;
            } else {
                if (dp[len1][len2] == dp[len1 - 1][len2 - 1] + 1) {
                    stack.push(str1[len1 - 1]);
                    len1--;
                    len2--;
                    res--;
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}

// G4 LCS 2 DP
// LIS 문제처럼 DP의 역추적 문제를 다뤄봣다 이전에는 sb의 insert를 쓰거나 reverse를
// 사용했었는데 이제는 Stack 자료구조를 통해서 push pop을 통해 활용했다.
// len1 과 len2를 기존의 인덱스로 사용하고 res라는 우리가 구한 문자의 개수를 통해서 반복문을 활용한다.