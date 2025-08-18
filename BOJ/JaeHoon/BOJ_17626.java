package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BOJ_17626 {
    static int END = 223;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=END; i++) set.add(i*i);

        if(set.contains(N)) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[N+1];
        Arrays.fill(dp, 1000000);
        dp[1] = 1;

        for(int i=2; i<=N; i++) {
            if(set.contains(i)) {
                dp[i] = 1;
                continue;
            }
            if(i % 2 == 0) dp[i] = dp[i/2]*2;
            for(int j=1; j<=END; j--) {
                int v = j*j;
                if(v < i) {
//                    System.out.println("i = " + i + "j = " + j);
                    dp[i] = Math.min(dp[i], dp[v] + dp[i-v]);
                }else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));

        System.out.println(dp[N]);
    }
}
