package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9177 {
    static String word1;
    static String word2;
    static String word3;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (T-- > 0) {
            cnt++;
            st = new StringTokenizer(br.readLine());
            word1 = st.nextToken();
            word2 = st.nextToken();
            word3 = st.nextToken();
            dp = new boolean[word1.length()+1][word2.length()+1];

            dp[0][0] = true;

            for(int i=1; i<=word1.length(); i++) {
                dp[i][0] = word1.charAt(i-1) == word3.charAt(i-1) ? dp[i-1][0] : false;
            }

            for(int i=1; i<=word2.length(); i++) {
                dp[0][i] = word2.charAt(i-1) == word3.charAt(i-1) ? dp[0][i-1] : false;
            }

            for(int i=1; i<=word1.length(); i++) {
                for(int j=1; j<=word2.length(); j++) {
                    char curA = word1.charAt(i-1);
                    char curB = word2.charAt(j-1);
                    char curC = word3.charAt(i+j-1);

                    if(curA != curC && curB != curC) dp[i][j] = false;
                    else if(curA == curC && curB != curC) dp[i][j] = dp[i-1][j];
                    else if(curA != curC && curB == curC) dp[i][j] = dp[i][j-1];
                    else dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }


            if(dp[word1.length()][word2.length()]) {
                sb.append("Data set ").append(cnt).append(": ").append("yes\n");
            }else {
                sb.append("Data set ").append(cnt).append(": ").append("no\n");
            }
        }

        System.out.print(sb);
    }
}
