// DP - boj.kr/9251 LCS
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251 {
    static int max(int n1, int n2) {
        if (n1 >= n2)
            return n1;
        else
            return n2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String sequence1 = br.readLine();
        String sequence2 = br.readLine();
        char[] seq1 = new char[sequence1.length() + 1];
        char[] seq2 = new char[sequence2.length() + 1];
        
        for (int i = 0; i < sequence1.length(); i++) {
            seq1[i+1] = sequence1.charAt(i);
        }
        for (int i = 0; i < sequence2.length(); i++) {
            seq2[i+1] = sequence2.charAt(i);
        }
        
        int[][] dp = new int[1001][1001];
        
        for (int i = 1; i < sequence1.length() + 1; i++) {
            for (int j = 1; j < sequence2.length() + 1; j++) {
                if (seq1[i] == seq2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        System.out.println(dp[seq1.length-1][seq2.length-1]);
    }
}